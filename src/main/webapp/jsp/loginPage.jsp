
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/VendingCSS.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Baloo+Chettan" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        <title>ElectroVend</title>
    </head>
    <body>
        <div class="container">
            <%@include file="headerFragment.jsp" %>
            <h4>Please Login To Make Administrative Changes:</h4>
            <c:if test="${param.login_error == 1}">
                <h3>Wrong id or password!</h3>
            </c:if> 
            <form method="post" class="signin" action="j_spring_security_check">
                <fieldset>
                    <table cellspacing="0">
                        <tr>
                            <th><label for="username">Username</label></th>
                            <td><input id="username_or_email" name="j_username" type="text" /></td>
                        </tr>
                        <tr>
                            <th><label for="password">Password</label></th>
                            <!-- #2b - must be j_password for Spring -->
                            <td><input id="password" name="j_password" type="password" /></td>
                        </tr>
                        <tr>
                            <th></th>
                            <td><input name="commit" type="submit" value="Sign In" /></td>
                        </tr>
                    </table>
                </fieldset>
            </form> 
        </div>

    </body>
</html>
