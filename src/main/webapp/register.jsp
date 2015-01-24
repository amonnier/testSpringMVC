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

<div class="row">
    <div class="col-md-4"></div>
  <div class="col-md-4">
    <form:form commandName="registerBean" method="POST">
        <div class="pure-g">
            <form:errors cssClass="pure-u-1" 
                         cssStyle="background-color: red; color: white; text-align: center" path="*"/>
        </div>
        <div class="form-group">
            <label>Pseudo </label>              
            <form:input path="usertag" type="text" class="form-control" placeholder="Enter pseudo"/>
        </div>
        <div class="form-group">
            <label>Email </label>       
            <form:input type="email" path="email" class="form-control" placeholder="Enter email"/> 
        </div>
        <div class="form-group">
            <label>Password </label>  
            <form:password path="password" class="form-control" placeholder="Enter password"/> 
        </div>
        <div class="form-group">
            <label>Password Confirmation </label>            
            <form:password class="form-control" path="passwordConfirmation" placeholder="Enter password confirmation"/>          
        </div>

        <input type="submit" class="btn btn-default" value="Envoyer"/>

    </form:form> 
</div>
</div>
</body>
</html>
