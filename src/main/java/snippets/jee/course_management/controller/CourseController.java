package snippets.jee.course_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/doAddCourse")
    public String doAddCourse (@ModelAttribute("course") CourseDTO courseDTO, Model model) {
        try {
            courseDAO.addCourse(courseDTO);
        } catch (Throwable th) {
            model.addAttribute("error", th.getLocalizedMessage());
            return "addCourse";
        }
        return "redirect:courses";
    }

    @RequestMapping("/course/update/{id}")
    public String updateCourse (@PathVariable int id, Model model) {
        //TODO: Error handling
        CourseDTO course = courseDAO.getCourse(id);
        model.addAttribute("course", course);
        model.addAttribute("title", "Update Course");
        return "updateCourse";
    }

    @RequestMapping("/doUpdateCourse")
    public String doUpdateCourse (@ModelAttribute("course") CourseDTO courseDTO, Model model) {
        try {
            courseDAO.updateCourse(courseDTO);
        } catch (Throwable th) {
            model.addAttribute("error", "更新失败59:)" + th.getMessage());
            return "updateCourse";
        }
        return "redirect:courses";
    }

    @RequestMapping("/course/delete/{id}")
    public String deleteCourse (@PathVariable("id") int courseId, Model model) {
        //TODO: Error handling
        courseDAO.deleteCourse(courseId);
        return "redirect:/courses";
    }
}
