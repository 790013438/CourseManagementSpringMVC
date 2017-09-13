package snippets.jee.course_management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import snippets.jee.course_management.dto.CourseDTO;

@Repository
public class CourseDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDatesource (DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<CourseDTO> getCourses() {
        List<CourseDTO> courses = jdbcTemplate.query("select * from course", new CourseRowMapper());
        return courses;
    }

    public static final class CourseRowMapper implements RowMapper<CourseDTO> {
        @Override
        public CourseDTO mapRow (ResultSet resultSet, int rowNum) throws SQLException {
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setId(resultSet.getInt("id"));
            courseDTO.setName(resultSet.getString("name"));
            courseDTO.setCredits(resultSet.getInt("credits"));
            return courseDTO;
        }
    }

    public void addCourse (final CourseDTO course) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                String sql = "insert into Course (name, credits) values (?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql, new String[] {"id"});
                preparedStatement.setString(1, course.getName());
                preparedStatement.setInt(2, course.getCredits());
                return preparedStatement;
            }
        }, keyHolder);

        course.setId(keyHolder.getKey().intValue());
    }
}
