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

        <form:form action="${pageContext.request.contextPath}/upload.do" 
                   commandName="bookBean" cssClass="pure-form pure-form-stacked" method="POST" 
                   enctype="multipart/form-data">
                        <div class="pure-g">
                <form:errors cssClass="pure-u-1" 
                             cssStyle="background-color: red; color: white; text-align: center" path="*"/>
            </div>
            <label>Titre du livre : <form:input path="titre"/></label>
            <label>Auteur du livre : <form:input path="auteur"/></label>
            <label>Description : <form:textarea path="description"/></label>
            <label>Couverture : <input type="file" name="couverture" id="couverture"/></label>
            <label>Emplacement : <input type="file" name="fichier" id="fichier"/></label>
            <input type="submit" value="Enregistrer"/>
        </form:form>
    </body>
</html>
