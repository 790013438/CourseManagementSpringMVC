# Course Management Spring MVC
## 配置数据库
## 使用jdbcTemplate增删查改
## controller
先从最简单的开始
## Calling Spring MVC Controller
spring#Calling_Spring_MVC_Controller分支 courses没出结果，是因为没有编译，误会误会
## Mapping data using @ModelAttribute
## Using parameters in @RequestMapping
Here, we map the updateCourse method to handle a request with the following URL pattern: /course/update/{id}, where {id} could be replaced with the ID (number) of any existing course, or for that matter, any integer. To access the value of this parameter, we used the @PathVariable annotation in the arguments.
## session
The preHandle method of the interceptor is called before Spring executes any request.  If we return true from the method, then the request is handled further; else, it is aborted. In preHandle, we first check whether the user object is present in the session.  The presence of the user object means that the user is already logged in. In such a case, we don't do anything more in this interceptor and return true. If the user is not logged in, then we redirect to the login page and return false so that Spring does not process this request further.
