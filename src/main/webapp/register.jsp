<%-- 
    Document   : register
    Created on : 8 janv. 2015, 13:35:41
    Author     : guillaume
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>

    <jsp:include page="header.jsp" />

    <spring:message code="register.pseudo.placeholder.label" var="placeholderPseudo"/>
    <spring:message code="register.email.placeholder.label" var="placeholderEmail"/>
    <spring:message code="register.password.placeholder.label" var="placeholderPassword"/>
    <spring:message code="register.password.confirmation.placeholder.label" var="placeholderConf"/>
    <spring:message code="register.submit" var="submit"/>
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form:form commandName="registerBean" method="POST">
                <div class="pure-g">
                    <form:errors cssClass="pure-u-1" 
                                 cssStyle="background-color: red; color: white; text-align: center" path="*"/>
                </div>
                <div class="form-group">
                    <label><spring:message code="register.pseudo.label"/></label>              
                    <form:input path="usertag" type="text" class="form-control" 
                                placeholder="${placeholderPseudo}"/>
                </div>
                <div class="form-group">
                    <label><spring:message code="register.email.label"/></label>       
                    <form:input type="email" path="email" class="form-control"
                                placeholder="${placeholderEmail}"/> 
                </div>
                <div class="form-group">
                    <label><spring:message code="register.password.label"/></label>  
                    <form:password path="password" class="form-control" 
                                   placeholder="${placeholderPassword}"/> 
                </div>
                <div class="form-group">
                    <label><spring:message code="register.password.confirmation.label"/></label>            
                    <form:password class="form-control" path="passwordConfirmation" 
                                   placeholder="${placeholderConf}"/>          
                </div>

                <input type="submit" class="btn btn-default" value="${submit}"/>

            </form:form> 
        </div>
    </div>
</body>
</html>
