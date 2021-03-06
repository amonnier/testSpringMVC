

<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
    <head>
        <link rel='stylesheet' href='${pageContext.request.contextPath}/webjars/bootstrap/3.3.2/css/bootstrap.min.css'>
        <link rel='stylesheet' href='${pageContext.request.contextPath}/webjars/bootstrap/3.3.2/css/bootstrap-theme.min.css'>
        <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/jquery/2.1.3/jquery.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.2/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/nprogress.js"></script>
        <link rel=stylesheet title="style" href="${pageContext.request.contextPath}/css/style.css" >
        <link rel=stylesheet title="style" href="${pageContext.request.contextPath}/css/nprogress.css" >
        <link rel=stylesheet title="style" href="${pageContext.request.contextPath}/css/bootstrap-editable.css" >
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-editable.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil</title>

    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">     
                <div class="navbar-header">

                    <a class="navbar-brand" href="<c:url value='/'/>"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> <spring:message code="header.link.home"/></a>  
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="<c:url value="/welcome/print.do"/>"><spring:message code="header.link.print.hello"/></a></li>
                        <li><a href="<c:url value="/index/register.do"/>"><spring:message code="header.link.register"/></a></li>
                        <li><a href="<c:url value="/index/invalidate.do"/>"><spring:message code="header.link.session.invalidate"/></a></li>
                        <li><a href="<c:url value="/upload.do"/>"><spring:message code="header.link.upload"/></a></li>
                        <li>
                            <form class="navbar-form navbar-left input-group" role="search" action="${pageContext.request.contextPath}/search.do" method="POST">
                                <div class="form-group">
                                    <input type="text" class="form-control" name="recherche" id="recherche" path="recherche" placeholder="<spring:message code="header.search.placeholder"/>"/>
                                </div>
                                <span class="input-group-btn">
                                    <button type="submit" class="btn btn-default "  ><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
                                </span>
                            </form>


                        </li>


                    </ul> 
                </div>
            </div>
        </nav>