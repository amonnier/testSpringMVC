<%-- 
    Document   : index
    Created on : 7 janv. 2015, 19:10:06
    Author     : guillaume
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<jsp:include page="header.jsp" />
<h4><spring:message code="book.details.message"/> ${bookModel.auteur}</h4>      
    <ul>
            <li>${bookModel}</li>
        </ul>
        ${bookModel.emplacement}
    </body>
</html>
