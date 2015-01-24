<%-- 
    Document   : register
    Created on : 8 janv. 2015, 13:35:41
    Author     : guillaume
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
  
        <jsp:include page="header.jsp" />

        <form:form commandName="registerBean" cssClass="pure-form pure-form-stacked" method="POST">
            <div class="pure-g">
                <form:errors cssClass="pure-u-1" 
                             cssStyle="background-color: red; color: white; text-align: center" path="*"/>
            </div>
            <label>Pseudo ? <form:input path="usertag"/></label>
            <label>Email ? <form:input path="email"/></label>
            <label>Password ? <form:password path="password"/></label>
            <label>Password Confirmation ? <form:password path="passwordConfirmation"/></label>
            <input type="submit" class="pure-button pure-button-primary" value="Envoyer"/>

        </form:form> 
    </body>
</html>
