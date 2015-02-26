<%-- 
    Document   : index
    Created on : 7 janv. 2015, 19:10:06
    Author     : guillaume
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="header.jsp" />
<script type="text/javascript">
    function ajaxComment() {
        var contenu = $('#content_commentaire').val();
//        $.post("${pageContext.request.contextPath}/comment/ajax/${bookModel.identifiant}/add.do",
//                {commentaireContent: contenu},
//        {
//            complete: function (jqXHR) {
//                alert("ok");
//                $("#commentaires").html(jqXHR.responseText);
//            }
//        });

        $.ajax({
            type: 'POST',
            data: {'commentaireContent': contenu},
            url: '${pageContext.request.contextPath}/comment/ajax/${bookModel.identifiant}/add.do',
            success: function (jqXHR) {
                alert("ok");
                $("#commentaires").html(jqXHR.responseText);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus + "," + errorThrown + "," + jqXHR.responseText); //error logging
            }
        });
    }
</script>
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
        <td>${bookModel.description}</td>
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
        <spring:message code="book.details.commentaire.new.placeholder.not.connected" var="messageNotConnected"/>
        <spring:message code="book.details.commentaire.new.placeholder.connected" var="messageConnected"/>
        <form:textarea id="content_commentaire" disabled="${empty utilisateur}"
                       path="commentaire"
                       placeholder="${empty utilisateur ? messageNotConnected:messageConnected}" 
                       maxlength="1000"/>
        <!--<input type="button" value="Enregistrer" onclick="javascript:ajaxComment();" />-->
        <input ${empty utilisateur? 'disabled':''} type="submit" value="<spring:message code="book.details.commentaire.new.submit"/>"/>
    </form:form>
</table>
<div id="commentaires">
    <table>
        <c:forEach items="${bookModel.commentaires}" var="commentaire">
            <tr><td><spring:message code="book.details.commentaire.list.par"/>${commentaire.utilisateur.usertag}
                    <spring:message code="book.details.commentaire.list.le"/><fmt:formatDate type="date" value="${commentaire.date_commentaire}" pattern="dd-MM-yyyy" dateStyle="long"/>
                    <spring:message code="book.details.commentaire.list.a"/> <fmt:formatDate type="time" timeStyle="short" pattern="hh:mm" value="${commentaire.date_commentaire}"/> 
                    <spring:message code="book.details.commentaire.list.separateur"/><br/>${commentaire.commentaire}</td></tr>
                </c:forEach>
    </table> 
</div>
</body>
</html>
