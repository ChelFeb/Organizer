<%--
  Created by IntelliJ IDEA.
  User: jack
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error page.Page Not Found</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<c:url value='resources/style.css' />" rel="stylesheet">
</head>
<body>
<button onclick="history.back()">Back to Previous Page</button>
<h1>HTTP Status 404 Page Not Found.</h1>
<br/>

<p class="errorMessage">
    <b>Request URI:</b>
    ${pageContext.request.scheme}://${header.host}${pageContext.errorData.requestURI}
</p>
<h3>Oops! A 404 error happened because the resource could not be found.</h3>
<br/>
</body>
</html>
