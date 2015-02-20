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
<h4><spring:message code="book.details.message"/> ${bookModel.auteur}</h4>      
<img src="${bookModel.emplacementCouverture}" width="300"/>
<table>
    <tr>
        <td><spring:message code="book.details.titre"/></td>
        <td>${bookModel.titre}</td>
    </tr>
    <tr>
        <td><spring:message code="book.details.auteur"/></td>
        <td>${bookModel.auteur}</td>
    </tr>
    <tr>
        <td><spring:message code="book.details.description"/></td>
        <td>${bookModel.auteur}</td>
    </tr>
    <tr>
        <td><spring:message code="book.details.uploade.by"/></td>
        <%-- Si l'utilisateur est different d'anonyme, on met un lien vers son profil--%>
        <c:if test="${not(bookModel.uploader.id eq 2)}">
            <td>
                <a href="<c:url value="/user/${bookModel.uploader.id}/show.do"/>">
                    ${bookModel.uploader.usertag}</a>
            </td>
        </c:if>
        <%--Sinon, on affiche juste son usertag --%>
        <c:if test="${bookModel.uploader.id eq 2}">
            <td>
                ${bookModel.uploader.usertag}
            </td>
        </c:if>
    </tr>
    <tr>
        <td><spring:message code="book.details.telecharger"/></td>
        <td colspan="2">
            <a href="${pageContext.request.contextPath}/book/${bookModel.identifiant}/get.do"><input type="button" value="<spring:message code="book.details.button.telecharger"/>"/></a></td>
    </tr>
</table>
<table>
    <form:form action="${pageContext.request.contextPath}/comment/${bookModel.identifiant}/add.do" commandName="commentaireBean"
               cssClass="pure-form pure-form-stacked" method="POST" >
        <form:textarea path="commentaire"/>
        <input type="submit" value="Enregistrer"/>
    </form:form>
</table>
</body>
</html>
