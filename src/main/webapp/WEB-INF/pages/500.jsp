<%--
  Created by IntelliJ IDEA.
  User: jack
--%>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" language="java" %>
<html>
<head>
    <title>Error page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<button onclick="history.back()">Back to Previous Page</button>
<h1>HTTP Status 500</h1>

<h3> An exception has occurred in your application </h3>
<button onclick="window.alert('${pageContext.exception.message}')">For advance users</button>
</body>
</html>
