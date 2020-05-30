<%-- 
    Document   : formActualizarAdmin
    Created on : 17-abr-2020, 15:32:30
    Author     : Nerea
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="<s:url value='/vistas/trophy.png'></s:url>" type="image/png"/>
        <s:set var="usuario" value="%{#session.usuario}"></s:set>
        <link href="../design/designIndex.css" rel="stylesheet" type="text/css"/>

        <title><s:text name="administracion.actualizar"></s:text></title>
        <s:head/>
    </head>
    <body>
        <s:include value="../header.jsp"></s:include>
        <h1><s:text name="administracion.actualizar"></s:text> <s:property value="#session.admin.nombre"></s:property></h1>
        <s:form action="actualizarAdmin">
            <s:actionerror cssClass="error"></s:actionerror>
            <s:label key="administracion.nombre"></s:label><s:textfield name="nombre"></s:textfield>
            <s:submit key="botonActualizar"></s:submit>
        </s:form>
        <s:form action ="/vistas/GestionAdministracion/verAdministraciones.jsp">
            <s:submit key="botonCancelar"></s:submit>
        </s:form>
        <s:include value="../footer.jsp"></s:include>
    </body>
</html>
