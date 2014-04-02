<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<script type="text/javascript">
    $(function () {
        $("[rel='tooltip']").tooltip();
    });
    function getRandomPlace(id)  {
        var generator = Math.floor(Math.random() * 6) + 3;
        document.getElementById(id).className = "col-md-"+ generator;
        document.getElementById("s"+id).className = "col-md-"+ (10 - generator);
    };
</script>

<div class="container">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12" align="center"><h3>You tasks</h3></div>
        </div>
        <c:forEach items="${userEvents}" var="element">
        <div class="row">
            <div id="${element.id}"></div>
            <div class="col-md-2" title='<h3>${element.subject}<br></h3><h6>${element.shortDescription}</h5><br>
            <c:if test="${element.deadLine!=null}">Deadline: <fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${element.deadLine}" /></c:if>'
                 rel='tooltip' data-placement="right" data-html='true'>
                <div class="box">
                    <h4><c:choose>
                        <c:when test='${element.done}'>
                            <span class="glyphicon glyphicon-ok ok on-left"></span>
                            <del>${element.subject}</del>
                        </c:when>
                        <c:otherwise>
                            <c:if test="${element.deadLine!=null}">
                                <span class="glyphicon glyphicon-bell on-right"></span>
                            </c:if>
                            ${element.subject}
                         </c:otherwise>
                    </c:choose></h4>

                </div>
            </div>
            <div id="s${element.id}"></div>
            <script>
                getRandomPlace("${element.id}");
            </script>
        </div>
        </c:forEach>
    </div>
</div>