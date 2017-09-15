<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
        <c:if test="${user.messageExists()}">
            <span style="color:red;">
                ${user.message}<br/>
            </span>
        </c:if>

        <form id="loginForm" method="POST">
            User Id : <input type="text" name="userName" required="required" value="${user.userName}"/><br/>
            Password : <input type="password" name="password"/><br/>
            <button type="submit">Submit</button>
        </form>
    </body>
</html>
