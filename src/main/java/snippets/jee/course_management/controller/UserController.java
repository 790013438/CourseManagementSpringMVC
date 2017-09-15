package snippets.jee.course_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import snippets.jee.course_management.dto.UserDTO;

@Controller
public class UserController {

    @RequestMapping (value="/login", method=RequestMethod.GET)
    public String login (Model model) {

        UserDTO user = new UserDTO();
        model.addAttribute("user", user);
        return "login";
    }

}
