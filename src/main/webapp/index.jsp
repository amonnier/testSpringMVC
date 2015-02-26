<%-- 
    Document   : index
    Created on : 7 janv. 2015, 19:10:06
    Author     : guillaume
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<jsp:include page="header.jsp" />

<c:if test="${not empty errorMessage}">
    <div class="alert alert-danger" role="alert">
        ${errorMessage}
    </div>
</c:if>

<div class="page-header">
    <h1><spring:message code="accueil.index.message"/></h1>
    <c:if test="${empty utilisateur}">
        <form:form commandName="loginBean" 
                   action="${pageContext.request.contextPath}/index.do" method="POST" class="form-inline">
            <form:errors path="*">
                <div class="alert alert-danger" role="alert">
                    <form:errors path="*"/>
                </div>
            </form:errors>
            <div class="form-group">
                <label><spring:message code="accueil.login.email"/><form:input path="email"/></label>
            </div>
            <div class="form-group">
                <label><spring:message code="accueil.login.password"/><form:password path="password"/></label></div>
            <input type="submit" class="btn btn-info btn-lg" 
                   value="<spring:message code="accueil.login.submit"/>"/>
        </form:form>
    </c:if>
    <c:if test="${not empty utilisateur}">
        <h4> <spring:message code="accueil.accueil.bienvenue.message"/> ${utilisateur.usertag} !</h4>
        <a href="<c:url value="/user/${utilisateur.id}/show.do"/>">
            <spring:message code="accueil.utilisateur.voir.profil"/>
        </a>
    </c:if>
</div>



<h1>Les 5 derniers ajouts: </h1>


<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
        <li data-target="#myCarousel" data-slide-to="3"></li>
        <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <div class="carousel-inner" role="listbox">
        <c:if test="${not empty List5lasts}">
            <c:forEach items="${List5lasts}" var="livre" varStatus="status">
                <c:if test="${status.index eq 0}">
                    <div class="item active">
                        <img src="${livre.emplacementCouverture}"width="460" height="345" alt="Livre"  onclick="window.document.location = '${pageContext.request.contextPath}/book/${livre.identifiant}/show.do';">
                        <div class="carousel-caption">
                            <h3>${livre.titre}</h3>
                        </div>
                    </div>
                    </c:if>
                    <c:if test="${not(status.index eq 0)}">
                        <div class="item">
                            <img src="${livre.emplacementCouverture}" width="460" height="345" alt="Livre" onclick="window.document.location = '${pageContext.request.contextPath}/book/${livre.identifiant}/show.do';">
                            <div class="carousel-caption">
                                <h3>${livre.titre}</h3>          
                            </div>
                        </div>
                        </c:if>
                    </c:forEach>
                </c:if>



                <!-- Left and right controls -->
                <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>




            </body>
            </html>
