<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<jsp:include page="/header.jsp" />
<script type="text/javascript">
    function enableModification() {
        var valueSpanUserTag = $('#userTag').text();
        var valueSpanUserEmail = $('#userEmail').text();

        $('#userInformation').hide().fadeIn('fast');
        $('#userTag').html('<input type="text" class="form-control" id="inputUserTag" value="' + valueSpanUserTag + '"/>');
        $('#userEmail').html('<input type="text" id="inputUserEmail" value="' + valueSpanUserEmail + '"/>');
        $('#validationButton').show();
        $('#linkEnableModifications').hide();
    }
    ;
    $(document).ready(function () {
        $.fn.editable.defaults.mode = 'inline';
        $('#untest').editable();
    });
</script>
<h4>Compte de l'utilisateur ${user.usertag}</h4>

<c:if test="${user.id == utilisateur.id}">
    <a href="#" id="linkEnableModifications" onclick="enableModification();">Modifier le profil</a>
</c:if>
<table id="userInformation">
    <tr>
        <td><label>usertag : </label> <span id="userTag">${user.usertag}</span></td>
    </tr>
    <tr>
        <td><label>adresse email : </label> <span id="userEmail">${user.email}</span></td>
    </tr>
</table>
    <span id="untest" class="editable editable-click" data-pk="1" data-type="text" href="#" data-title="test data">blah</span>
<input type="button" id="validationButton" style="display: none" value="Valider"/>
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