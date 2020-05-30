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
            <link href="<s:url value='/design/designIndex.css'></s:url>" rel="stylesheet" type="text/css"/>
            <link href="<s:url value='/design/designForm.css'></s:url>" rel="stylesheet" type="text/css"/>
            <title><s:text name="administracion.actualizar"></s:text></title>
        <s:head/>
    </head>
    <body>
        <s:include value="../header.jsp"></s:include>
            <div class="competiciones" style="padding-top: 20px;padding-bottom: 5px;margin-top: 8%; position:absolute;">
                <h2 style="text-align:center;"><s:text name="administracion.actualizar"></s:text> <s:property value="#session.admin.nombre"></s:property></h2>
                <div class="formulario" style="margin-left:20%;margin-right: 20%;">
                <s:form action="actualizarAdmin" style="padding-left: 10px; border-left-width: 1px; border-left-style: solid;border-bottom-width: 1px;border-bottom-style: solid;border-top-width: 1px;border-top-style: solid;border-right-width: 1px;border-right-style: solid;">
                    <s:actionerror cssClass="error"></s:actionerror>
                    <s:label key="administracion.nombre"></s:label>: <s:textfield name="nombre"></s:textfield>
                    <br/><s:submit key="botonActualizar"></s:submit>
                </s:form>
            </div>
        </div>
        <s:include value="../footer.jsp"></s:include>
    </body>
</html>
