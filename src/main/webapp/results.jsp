<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>



<link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.css">
<script type="text/javascript" language="javascript" src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript" language="javascript" src="//cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" language="javascript" src="//cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.js"></script>

<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/dataTables.bootstrap.js"></script>
<jsp:include page="/header.jsp" />



<script type="text/javascript" class="init">
    $(document).ready(function () {
        $('#example').dataTable();
    });
</script>


<c:if test="${empty searchBean.resultat}">
    <spring:message code="resultat.vide"/>
</c:if>
<c:if test="${not empty searchBean.resultat}">

    <h2 class="text-center">Résultats</h2>
    <div class="table-responsive">
        <div class="container">
            <div class="container-fluid">
                <div class="col-md-10 col-md-offset-1">
                    <table data-link="row" class="table table-hover" id="example"><thead><tr><th>Nom</th><th>Auteur</th></tr></thead>
                        <tbody  
                            <c:forEach items="${searchBean.resultat}" var="resultat">
                                <tr class="cursor" onclick="window.document.location = '${pageContext.request.contextPath}/book/${resultat.identifiant}/show.do'
                                            ;"> <td>${resultat.titre}</td>
                                    <td>${resultat.auteur}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</c:if>
</body>
</html>
