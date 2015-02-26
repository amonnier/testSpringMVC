<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<jsp:include page="header.jsp" />

<c:if test="${empty searchBean.resultat}">
    <spring:message code="resultat.vide"/>
</c:if>
<c:if test="${not empty searchBean.resultat}">

    <h2 class="text-center">Résultats</h2>
    <div class="table-responsive">

        <table data-link="row" class="table table-hover"><tr><td>Nom</td><td>Auteur</td></tr>
            <c:forEach items="${searchBean.resultat}" var="resultat">
                <tr onclick="window.document.location = '${pageContext.request.contextPath}/book/${resultat.identifiant}/show.do';"> <td>${resultat.titre}</td>
                    <td>${resultat.auteur}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

</c:if>
</body>
</html>
