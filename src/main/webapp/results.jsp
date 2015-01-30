<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<jsp:include page="header.jsp" />
        
<c:forEach items="${searchBean.resultat}" var="resultat">
    <a href="${pageContext.request.contextPath}/book/${resultat.identifiant}/show.do">${resultat.titre}</a>
</c:forEach>
    </body>
</html>
