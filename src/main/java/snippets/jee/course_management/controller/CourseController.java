package snippets.jee.course_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import snippets.jee.course_management.dao.CourseDAO;
import snippets.jee.course_management.dto.CourseDTO;

@Controller
public class CourseController {

    @Autowired
    CourseDAO courseDAO;

    @RequestMapping("/courses")
    public String getCourses (Model model) {
        model.addAttribute("courses", courseDAO.getCourses());
        return "courses";
    }

    @RequestMapping("/addCourse")
    public String addCourse (@ModelAttribute("course") CourseDTO course, Model model) {
        if (course == null) {
            course = new CourseDTO();
        }
        model.addAttribute("course", course);
        return "addCourse";
    }
}
