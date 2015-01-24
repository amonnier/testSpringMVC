

<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <link rel='stylesheet' href='${pageContext.request.contextPath}/webjars/bootstrap/3.3.2/css/bootstrap.min.css'>
        <link rel='stylesheet' href='${pageContext.request.contextPath}/webjars/bootstrap/3.3.2/css/bootstrap-theme.min.css'>
        <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.2/js/bootstrap.min.js"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil</title>
    </head>
    <body>
        <ul class="nav nav-tabs">
        <li role="presentation" class="active"><a href="<c:url value="/"/>">Home</a></li>
        <li role="presentation"><a href="<c:url value="/welcome/print.do"/>">Print the hello !</a><spring:eval var="constant" expression="T(com.test.springmvc.springmvcproject.constants.MappingConstants).ACTION_REGISTER"/></li>
        <li role="presentation"><a href="<c:url value="/index/register.do"/>">Register</a></li>
        <li role="presentation"><a href="<c:url value="/index/invalidate.do"/>">Invalider la session</a></li>
    </ul>
   