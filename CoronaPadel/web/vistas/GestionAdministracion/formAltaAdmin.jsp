<%-- 
    Document   : formAltaAdmin
    Created on : 15-abr-2020, 13:34:35
    Author     : Nerea
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <s:set var="usuario" value="%{#session.usuario}"></s:set>
        <link href="../design/designIndex.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" href="<s:url value='/vistas/trophy.png'></s:url>" type="image/png"/>
        <title><s:text name="administracion.registro"></s:text></title>
        <s:head/>
    </head>
    <body>
        <s:include value="../header.jsp"></s:include>
        <h1><s:text name="administracion.registro"></s:text></h1>
        <s:form action="registroAdministracion">
            <s:actionerror cssClass="error"></s:actionerror>
            <s:label key="administracion.nombre"></s:label><s:textfield name="nombre"></s:textfield>
            <p><s:text name="administracion.pistas"></s:text></p>
            <s:submit key="botonRegistrar"></s:submit>
        </s:form>
        <s:include value="../footer.jsp"></s:include> 
    </body>
</html>
