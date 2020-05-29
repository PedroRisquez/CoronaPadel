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
            <div style="padding-left: 14px;padding-top: 14px;padding-right: 14px;padding-bottom: 14px;margin-left: 30px;" >
                <h2 class="letras" ><s:text name="competicion.form"></s:text></h2>
            <s:form cssClass="altas"  action="creaCompeticionAction" cssStyle="padding-left: 14px;padding-top: 14px;padding-right: 14px;padding-bottom: 14px;margin-left: 30px;">
                <s:actionerror cssClass="error"></s:actionerror>
                <s:label cssClass="letras" key="competicion.nombre"></s:label>
                <s:textfield cssClass="letras" name="nombre"></s:textfield><br>
                <s:label cssClass="letras" key="competicion.descripcion"></s:label>
                <s:textarea cssClass="letras"  name="descripcion"></s:textarea><br>
                <s:label  cssClass="letras" key="administracion.nombre"></s:label>
                <s:select  cssClass="letras"  name="idAdministracion" id="idAdministracion" list="administracion" listValue="%{nombre}" listKey="idAdministracion"></s:select><br>
                <s:label cssClass="letras" key="competicion.privada"></s:label>
                <s:checkbox cssClass="letras"  name="privada" fieldValue="true"></s:checkbox><br>
                <s:label cssClass="letras" key="competicion.nParejas"></s:label>
                <s:textfield cssClass="letras"  name="nparejas"></s:textfield><br>
                <s:label cssClass="letras" key="competicion.formato"></s:label>
                <s:select cssClass="letras"  id="formato" name="formato" list="formato"></s:select><br>
                <s:label cssClass="letras" key="competicion.fechaInicio"></s:label>
                <s:textfield cssClass="letras" name="fechaInicio"></s:textfield><br>
                <s:submit cssClass="letras" key="competicion.crear"></s:submit>
            </s:form>
        </div>
        <s:include value="../footer.jsp"></s:include>
    </body>
</html>
