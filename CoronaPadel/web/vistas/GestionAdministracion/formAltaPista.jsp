<%-- 
    Document   : formAltaPista
    Created on : 15-abr-2020, 15:28:46
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
            <title><s:text name="pista.registro"></s:text></title>
        <s:head/>
    </head>
    <body>
        <s:include value="../header.jsp"></s:include>
        <h1><s:text name="pista.registro"></s:text></h1>
        <s:form action="registroPista">
            <s:actionerror cssClass="error"></s:actionerror>
            <s:label key="pista.localizacion"></s:label><s:textfield name="localizacion"></s:textfield><br>
            <s:label key="pista.cubierta"></s:label><s:select id="tipoDeCubierta" name="tipoDeCubierta" list="#session.listadoCubierta"></s:select><br>
            <s:label key="pista.pista"></s:label><s:select id="tipoDePista" name="tipoDePista" list="#session.listadoPista"></s:select><br>
            <s:label key="pista.suelo"></s:label><s:select  id="tipoDeSuelo" name="tipoDeSuelo" list="#session.listadoSuelo"></s:select><br>
            <s:submit key="botonRegistrar"></s:submit>
        </s:form>
        <s:include value="../footer.jsp"></s:include>
    </body>
</html>
