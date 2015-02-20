<%-- 
    Document   : index
    Created on : 7 janv. 2015, 19:10:06
    Author     : guillaume
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

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
<div>
    <spring:message code="accueil.derniers.livres"/>
    <ul>
        <c:if test="${not empty List5lasts}">
            <c:forEach items="${List5lasts}" var="livre">
                <li>${livre.titre}</li>
                </c:forEach>
            </c:if>
    </ul>
</div>
</body>
</html>
