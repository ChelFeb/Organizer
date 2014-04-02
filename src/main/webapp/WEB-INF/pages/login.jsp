<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<script src="<c:url value="/resources/js/signIn.js" />"></script>

<div id="login" class="container">

    <div class="starter-template">
        <p class="text-center bg-danger">${fail}</p>
    </div>

    <form:form method="post" action="j_spring_security_check" cssClass="form-signin">
        <legend class="text-info">Enter your login and password</legend>

        <div>
            <label class="col-sm-2 control-label">
                Login:
            </label>

            <div>
                <input id="userEmail" class="form-control" type="text" name='j_username'/>
            </div>
            <label class="col-sm-2 control-label">
                Password:
            </label>

            <div>
                <input id="userPassword" class="form-control" type="password" name='j_password'/>
            </div>
            <label class="checkbox">
                <input id="rememberMe" type="checkbox" name="_spring_security_remember_me">Remember
            </label>

        </div>

        <div>
            <input type="submit" class="btn-sm btn-primary btn-block" value="Ok"/>
        </div>
    </form:form>


</div>
