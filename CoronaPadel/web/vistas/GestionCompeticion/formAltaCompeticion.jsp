<%-- 
    Document   : formAltaCompeticion
    Created on : 27-abr-2020, 12:00:15
    Author     : pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <s:set var="usuario" value="%{#session.usuario}"></s:set>
        <link rel="icon" href="../trophy.png" type="image/png"/>
        <link href="../design/designIndex.css" rel="stylesheet" type="text/css"/>
        <title><s:text name="competicion.alta"></s:text></title>
        <s:head/>
    </head>
    <body>
        <s:include value="../header.jsp"></s:include>
        <h1><s:text name="competicion.form"></s:text></h1>
        <s:form action="creaCompeticionAction">
            <s:actionerror cssClass="error"></s:actionerror>
            <s:label key="competicion.nombre"></s:label><s:textfield name="nombre"></s:textfield><br>
            <s:label key="competicion.descripcion"></s:label><s:textarea name="descripcion"></s:textarea><br>
            <s:label key="administracion.nombre"></s:label><s:select name="idAdministracion" id="idAdministracion" list="administracion" listValue="%{nombre}" listKey="idAdministracion"></s:select><br>
            <s:label key="competicion.privada"></s:label><s:checkbox name="privada" fieldValue="true"></s:checkbox><br>
            <s:label key="competicion.nParejas"></s:label><s:textfield name="nparejas"></s:textfield><br>
            <s:label key="competicion.formato"></s:label><s:select id="formato" name="formato" list="formato"></s:select><br>
            <s:label key="competicion.fechaInicio"></s:label><s:textfield name="fechaInicio"></s:textfield><br>
            <s:submit key="competicion.crear"></s:submit>
        </s:form>
        <s:include value="../footer.jsp"></s:include>
    </body>
</html>
