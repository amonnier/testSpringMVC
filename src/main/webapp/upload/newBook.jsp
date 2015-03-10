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

<h2><spring:message code="upload.livre.nouveau"/></h2>
<form:form action="${pageContext.request.contextPath}/upload.do" 
           commandName="bookBean" cssClass="pure-form pure-form-stacked" method="POST" 
           enctype="multipart/form-data"  class="form-horizontal">
    <div class="pure-g">
        <form:errors cssClass="pure-u-1" 
                     cssStyle="background-color: red; color: white; text-align: center" path="*"/>
    </div>
    <div class="form-group">

        <label><spring:message code="upload.livre.titre"/><form:input path="titre" class="form-control" />     </label>
                
    </div>
    <div class="form-group">
        <label><spring:message code="upload.livre.auteur"/><form:input class="form-control" path="auteur"/></label>
    </div>
    <div class="form-group">
        <label><spring:message code="upload.livre.description"/><form:textarea class="form-control" path="description"/></label>
    </div>
    <div class="form-group">
        <label><spring:message code="upload.livre.couverture"/><input type="file" name="couverture" id="couverture"/></label>
        <p class="help-block"><spring:message code="upload.livre.couverture.hint"/></p>
    </div>
    <div class="form-group">
        <label><spring:message code="upload.livre.fichier"/><input type="file" name="fichier" id="fichier"/></label>
        <p class="help-block"><spring:message code="upload.livre.fichier.hint"/></p>
    </div>
    <div class="form-group">
        <input type="submit" value="<spring:message code="upload.livre.submit"/>" class="btn btn-default"/>
    </div>
</form:form>




</body>
</html>
