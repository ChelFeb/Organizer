<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title><tiles:getAsString name="title"/></title>
    <meta content="text/html; charset=UTF-8">

    <script src="<c:url value="/resources/js/jquery-2.1.0.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-theme.min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/main-style.css" />">
</head>

<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="body"/>
<tiles:insertAttribute name="footer"/>

</html>