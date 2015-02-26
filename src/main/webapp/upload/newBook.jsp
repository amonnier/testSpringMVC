<%-- 
    Document   : newBook
    Created on : 21 janv. 2015, 18:00:59
    Author     : guillaume
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<jsp:include page="/header.jsp" />

<h2>Nouveau livre : </h2>
<form:form action="${pageContext.request.contextPath}/upload.do" 
           commandName="bookBean" cssClass="pure-form pure-form-stacked" method="POST" 
           enctype="multipart/form-data"  class="form-horizontal">
    <div class="pure-g">
        <form:errors cssClass="pure-u-1" 
                     cssStyle="background-color: red; color: white; text-align: center" path="*"/>
    </div>
    <div class="form-group">

        <label>Titre du livre :<form:input path="titre" class="form-control" />     </label>
                
    </div>
    <div class="form-group">
        <label>Auteur du livre : <form:input class="form-control" path="auteur"/></label>
    </div>
    <div class="form-group">
        <label>Description : <form:textarea class="form-control" path="description"/></label>
    </div>
    <div class="form-group">
        <label>Couverture : <input type="file" name="couverture" id="couverture"/></label>
        <p class="help-block">Couverture du livre au format jpeg ou png.</p>
    </div>
    <div class="form-group">
        <label>Emplacement : <input type="file" name="fichier" id="fichier"/></label>
        <p class="help-block">Fichier au format pdf ou epub.</p>
    </div>
    <div class="form-group">
        <input type="submit" value="Enregistrer" class="btn btn-default"/>
    </div>
</form:form>




</body>
</html>
