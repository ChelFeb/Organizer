<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

            <sec:authorize access="isAnonymous()">
                <a class="navbar-brand" href="/organizer/">Organizer</a>
            </sec:authorize>

            <sec:authorize access="isAuthenticated()">
                <a class="navbar-brand" href="/organizer/main/events">Add event</a>
                <a class="navbar-brand" href="/organizer/main">Tasks</a>
                <a class="navbar-brand" href="/organizer/main/events/timeline">Events</a>
            </sec:authorize>

        </div>

        <sec:authorize access="isAnonymous()">
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li id="registration"><a href="registration">Registration</a></li>
                    <li id="signIn"><a class="pull-right" href="login">Sign in</a></li>
                </ul>
            </div>
        </sec:authorize>

        <sec:authorize access="isAuthenticated()">
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/organizer/logout"> Logout </a></li>
                </ul>
            </div>
        </sec:authorize>


    </div>
</div>

<br>