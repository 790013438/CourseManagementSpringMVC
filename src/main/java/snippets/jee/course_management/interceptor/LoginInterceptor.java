package snippets.jee.course_management.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import snippets.jee.course_management.dto.UserDTO;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        //get session from request
        HttpSession httpSession = httpServletRequest.getSession();
        UserDTO userDTO = (UserDTO) httpSession.getAttribute("user");

        //Check if the current request is for /login. In that case
        //do nothing, else we will execute the request in loop
        //Intercept only if request is not /login
        String contextString = httpServletRequest.getContextPath();
        if (!(contextString + "/login").equals(httpServletRequest.getRequestURI()) && (userDTO == null || userDTO.getUserName() == null)) {
            //User is not logged in. Redirect to /login
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login");
            //do not process this request further
            return false;
        }
        return true;
    }

}
