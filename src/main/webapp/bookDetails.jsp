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

<jsp:include page="/header.jsp" />
<!--<script type="text/javascript" src="${pageContext.request.contextPath}/js/bookDetails.js"></script>-->
<script type="text/javascript">
    function ListCommentaires(comments, contextRoot) {
        this.liste = comments;
        this.contextRoot = contextRoot;
        this.toString = function (contextRoot) {
            var html = "";
            html += '<div class="commentaires">';
            for (commentaire of this.liste){
                var date = new Date(commentaire.date_commentaire);
                html += '<div class="commentaire">';
                html += '<spring:message code="book.details.commentaire.list.par"/> '
                        + '<a href="' + this.contextRoot + '/user/' + commentaire.utilisateur.id + '/show.do">'
                        + commentaire.utilisateur.usertag
                        + '</a>';
                html += '<spring:message code="book.details.commentaire.list.le"/>' + date.toLocaleFormat('%d %b %Y');
                html += '<spring:message code="book.details.commentaire.list.a"/>' + date.toLocaleFormat('%Hh%M');
                html += '<spring:message code="book.details.commentaire.list.separateur"/>';
                html += '<br/>' + commentaire.commentaire;
                html += '</div>';
            }
            html += '</div>';
            return html;
        };
    }
    function Book(titre, auteur, commentaires, contextRoot) {
        this.titre = titre;
        this.auteur = auteur;
        this.contextRoot = contextRoot;
        this.listCommentaires = new ListCommentaires(commentaires, contextRoot);
        this.toString = function () {
            var string = "";
            string += this.listCommentaires.toString();
            return string;
        };
    }

    function saveAndReload(contextRoot, bookId) {
        NProgress.start();
        var contenu = $('#content_commentaire').val();
        NProgress.inc();
        $.ajax({
            url: '' + contextRoot + '/comment/ajax/' + bookId + '/add.do',
            data: {commentaireContent: contenu},
            success: function (data) {
                var book = new Book(data.titre, data.auteur, data.commentaires, contextRoot);
                $("#content_commentaire").val("");
                $('#commentaires').hide().html(book.toString()).fadeIn('fast');
                NProgress.done();
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
        <input type="button" value="Enregistrer" onclick="javascript:saveAndReload('${pageContext.request.contextPath}', '${bookModel.identifiant}');" />
    </form:form>
</table>
<div id="commentaires">
    <table>
        <c:forEach items="${bookModel.commentaires}" var="commentaire">
            <tr><td><spring:message code="book.details.commentaire.list.par"/>
                    <a href="${pageContext.request.contextPath}/user/${commentaire.utilisateur.id}/show.do">${commentaire.utilisateur.usertag}</a>
                    <spring:message code="book.details.commentaire.list.le"/><fmt:formatDate type="date" value="${commentaire.date_commentaire}" pattern="dd-MM-yyyy" dateStyle="long"/>
                    <spring:message code="book.details.commentaire.list.a"/> <fmt:formatDate type="time" timeStyle="short" pattern="hh:mm" value="${commentaire.date_commentaire}"/> 
                    <spring:message code="book.details.commentaire.list.separateur"/><br/>${commentaire.commentaire}</td></tr>
                </c:forEach>
    </table> 
</div>
</body>
</html>
