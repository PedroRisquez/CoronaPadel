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
        <link href="<s:url value='/design/designIndex.css'></s:url>" rel="stylesheet" type="text/css"/>
        <link href="<s:url value='/design/designTable.css'></s:url>" rel="stylesheet" type="text/css"/>
        <link rel="icon" href="<s:url value='/vistas/trophy.png'></s:url>" type="image/png"/>
        <title><s:text name="administracion.registro"></s:text></title>
        <s:head/>
    </head>
    <body>
        <s:include value="../header.jsp"></s:include>
        <div style="padding-left: 170px;padding-top: 160px;">
        <h2 style="background-color:#ddd7c8;margin-right: 800px;
text-align: center;"><s:text name="administracion.registro"></s:text></h2>
        <s:form action="registroAdministracion">
            <s:actionerror cssClass="error"></s:actionerror>
            <s:label key="administracion.nombre"></s:label><s:textfield name="nombre"></s:textfield>
            <p><s:text name="administracion.pistas"></s:text></p>
            <s:submit key="botonRegistrar"></s:submit>
        </s:form>
            </div>
        <s:include value="../footer.jsp"></s:include> 
    </body>
</html>
