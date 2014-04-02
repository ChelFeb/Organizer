<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script src="<c:url value="/resources/js/bootstrap-datetimepicker.js" />"></script>
<script src="<c:url value="/resources/js/locales/bootstrap-datetimepicker.ru.js" />"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-datetimepicker.css" />">
<link rel="stylesheet" href="<c:url value="/resources/css/main-style.css" />">
<script src="<c:url value="/resources/js/events.js" />"></script>

<div id="eventForm" class="container">

    <form:form method="POST" action="events" modelAttribute="eventDTO" name="eventDTO">

        <ul id="taskNavBar" class="nav nav-tabs nav-justified">
            <li id="taskLi" class="active"><a>Task</a></li>
            <li id="eventLi"><a>Event</a></li>
            <li id="dlEventLi"><a>Deadline Event</a></li>
        </ul>

        <div class="col-lg-6">
            <label class="control-label" for="subject">Subject:</label>

            <div>
                <form:input class="form-control" id="subject" type="text" path="subject" name="subject"/>
                <form:errors path="subject" cssClass="error"/>
            </div>

            <label class="control-label" for="description">Description:</label>

            <div for="description">
                <form:textarea class="form-control" id="description" rows="10" cols="40" type="text" path="description"
                               name="description"
                               autocomplete="off"/>
                <form:errors path="description" cssClass="error"/>
            </div>
            <input class="btn btn-default btn-block" type="submit" value="Ok">
        </div>

        <%--date picker Start the event--%>

        <div id="startTime" class="form-group">
            <label for="dtp_input1" class="col-md-2 control-label">Start of event</label>

            <div class="input-group date form_datetime col-md-5"
                 data-date-format="dd/mm/yyyy HH:ii" data-link-field="dtp_input1">
                <form:input id="startDate" class="form-control" size="8" type="text" path="startDate" name="startDate" readonly="true" />
                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
            <input type="hidden" id="dtp_input1" value=""/><br/>
        </div>


        <%--date picker Finish the event--%>

        <div id="finishTime" class="form-group">
            <label for="dtp_input2" class="col-md-2 control-label">End of the event</label>

            <div class="input-group date form_datetime col-md-5"
                 data-date-format="dd/mm/yyyy HH:ii" data-link-field="dtp_input1">
                <form:input id="endDate" class="form-control" size="8" type="text" readonly="true" name="endDate" path="endDate"/>
                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
            <input type="hidden" id="dtp_input2" value=""/><br/>
        </div>

        <%--date picker Deadline the event--%>

        <div id="deadlineTime" class="form-group">
            <label for="dtp_input3" class="col-md-2 control-label">Deadline of the event</label>

            <div class="input-group date form_datetime col-md-5"
                 data-date-format="dd/mm/yyyy HH:ii" data-link-field="dtp_input1">
                <form:input id="deadline" class="form-control" size="8" type="text" readonly="true" name="deadline" path="deadline" />
                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
            <input type="hidden" id="dtp_input3" value=""/><br/>
        </div>

        <form:input id="type" type="hidden" path="type" name="type" readonly="true" value="Task"/>

    </form:form>
</div>
