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
        <link rel="icon" href="<s:url value='/vistas/trophy.png'></s:url>" type="image/png"/>
            <link href="../design/designIndex.css" rel="stylesheet" type="text/css"/>
            <link href="../design/designForm.css" rel="stylesheet" type="text/css"/>
            <title><s:text name="competicion.alta"></s:text></title>
        <s:head/>
    </head>
    <body>
        <s:include value="../header.jsp"></s:include>
            <div class="competiciones" style="padding-top: 20px;padding-bottom: 120px;margin-top: 8%; position:absolute;"> 
                  <h2 style="text-align:center;"><s:text name="competicion.form"></s:text></h2>
            <div class="formulario" style="margin-left:20%;margin-right: 20%;">
            <s:form  action="creaCompeticionAction"  style="padding-left: 10px; border-left-width: 1px; border-left-style: solid;border-bottom-width: 1px;border-bottom-style: solid;border-top-width: 1px;border-top-style: solid;border-right-width: 1px;border-right-style: solid;">
                <s:actionerror cssClass="error"></s:actionerror>
                <s:label  key="competicion.nombre"></s:label><br>
                <s:textfield  name="nombre"></s:textfield><br>
                <s:label  key="competicion.descripcion"></s:label><br>
                <s:textarea   name="descripcion"></s:textarea><br>
                <s:label   key="administracion.nombre"></s:label>
                <s:select    name="idAdministracion" id="idAdministracion" list="administracion" listValue="%{nombre}" listKey="idAdministracion"></s:select><br>
                <s:label key="competicion.privada"></s:label>
                <s:checkbox  name="privada" fieldValue="true"></s:checkbox><br>
                <s:label key="competicion.nParejas"></s:label>
                <s:textfield   name="nparejas"></s:textfield><br>
                <s:label  key="competicion.formato"></s:label>
                <s:select   id="formato" name="formato" list="formato"></s:select><br>
                <s:label  key="competicion.fechaInicio"></s:label>
                <s:textfield  name="fechaInicio"></s:textfield><br>
                <s:submit cssStyle="text-align:center;" key="competicion.crear"></s:submit>
            </s:form>
            </div>
        </div>
        <s:include value="../footer.jsp"></s:include>
    </body>
</html>
