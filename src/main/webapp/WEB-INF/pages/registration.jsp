<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="<c:url value="/resources/js/NavBarRegistrationActive.js" />"></script>

<div class="starter-template">
    <p class="text-center bg-danger">${errorMessage}</p>
</div>

<div class="container">
    <div>
        <form:form method="POST" action="registration" modelAttribute="userInfo" name="userInfo" cssClass="form-signin">
            <legend class="text-info">Please fill user information for registration</legend>

            <div>
                <label for="email" class="col-sm-2 control-label">Email:</label>

                <div>
                    <form:input path="email" cssClass="form-control" id="email" type="text"/>
                    <form:errors path="email" cssClass="errorMessage"/>
                </div>

                <label for="password" class="col-sm-2 control-label">Password:</label>

                <div>
                    <form:input path="password" cssClass="form-control" id="password" type="password"/>
                    <form:errors path="password" cssClass="errorMessage"/>
                </div>

                <label class="col-sm-2 control-label">Repeat_Password:</label>

                <div>
                    <form:input path="confirmPassword" cssClass="form-control" type="password" id="confirmPassword"/>
                    <form:errors path="confirmPassword" cssClass="errorMessage"/>
                </div>
            </div>

            <div>
                <input type="submit" class="btn-sm btn-primary btn-block" value="Register"/>
            </div>
        </form:form>

    </div>
</div>
