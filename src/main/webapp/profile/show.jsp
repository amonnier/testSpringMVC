<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<jsp:include page="/header.jsp" />

<h4>Compte de l'utilisateur ${user.usertag}</h4>
<c:if test="${user.id == utilisateur.id}">
    <a href="<c:url value="/user/${user.id}/modify.do"/>">Modifier le profil</a>
</c:if>
<p>Liste des livres uploadés par ${user.usertag} :</p>
<ul>
    <c:forEach items="${user.listeLivres}" var="livre">
        <li><a href="<c:url value="/book/${livre.identifiant}/show.do"/>">${livre.titre}</a></li>
    </c:forEach>
</ul>
<c:if test="${empty user.listeLivres}">
    <p style="color:red;">Pas de livres uploadés !</p>
</c:if>
</body>
</html>