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

            <div class="alert alert-danger" role="alert">
                <form:errors path="*"/>
            </div>

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
    </c:if>
</div>

</body>
</html>
