<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="<c:url value="/resources/js/timeline.js" />"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/timeline.css" />">

<div class="container">

    <legend>You events</legend>

    <ul id="eventsNavBar" class="nav nav-tabs nav-justified">
        <li id="dayLi" class="active"><a>by Day</a></li>
        <li id="weekLi"><a>by Week</a></li>
        <li id="monthLi"><a>by Month</a></li>
    </ul>

    <table id="tableOfEventsByDay" class="table table-condensed table-striped table-bordered table-hover ">


        <thead>
        <tr>
            <th>Time</th>
            <th>Events</th>

        </tr>
        </thead>

        <tbody>
        <%-- table is added from a script --%>
        </tbody>

    </table>

    <table id="tableOfEventsByWeek" class="table table-condensed table-striped table-bordered table-hover ">


        <thead>
        <tr>
            <th>Time</th>
            <th>Monday</th>
            <th>Tuesday</th>
            <th>Wednesday</th>
            <th>Thursday</th>
            <th>Friday</th>
            <th>Saturday</th>
            <th>Sunday</th>
        </tr>
        </thead>

        <tbody>
        <%-- table is added from a script --%>
        </tbody>

    </table>

    <c:forEach items="${eventsByDay}" var="element">
        <div class="eventByDay">
            <div class="subject" value="${element.subject}"></div>
            <div class="description" value="${element.description}"></div>
            <div class="dateStart" value="${element.dateStart}"></div>
            <div class="dateEnd" value="${element.dateEnd}"></div>
        </div>
    </c:forEach>


</div>
