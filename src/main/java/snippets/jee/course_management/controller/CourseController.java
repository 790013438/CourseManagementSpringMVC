package snippets.jee.course_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import snippets.jee.course_management.dao.CourseDAO;

@Controller
public class CourseController {

    @Autowired
    CourseDAO courseDAO;

    @RequestMapping("/courses")
    public String getCourses (Model model) {
        model.addAttribute("courses", courseDAO.getCourses());
        return "courses";
    }
}
