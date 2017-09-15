package snippets.jee.course_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import snippets.jee.course_management.dto.UserDTO;

@Controller
@SessionAttributes("user")
public class UserController {

    @RequestMapping (value="/login", method=RequestMethod.GET)
    public String login (Model model) {

        UserDTO user = new UserDTO();
        model.addAttribute("user", user);
        return "login";
    }

    @RequestMapping (value="/login", method=RequestMethod.POST)
    public String doLogin (@ModelAttribute ("user") UserDTO user, Model model) {

        //Hard-coded validation of user name and 
        //password to keep this example simple
        //But validation could be done against database or
        //any other means here.
        if ("admin".equals(user.getUserName()) && "admin".equals(user.getPassword())) {
            return "redirect:courses";
        }

        user.setMessage("Invalid user name or password. Please try again");
        return "login";
    }
}
