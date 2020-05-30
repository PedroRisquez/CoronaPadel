<%-- 
    Document   : modificarPareja
    Created on : 25-may-2020, 11:20:02
    Author     : pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <s:set var="usuario" value="%{#session.usuario}"></s:set>
        <link rel="icon" href="<s:url value='/vistas/trophy.png'></s:url>" type="image/png"/>
            <link href="<s:url value='/design/designIndex.css'></s:url>" rel="stylesheet" type="text/css"/>
            <link href="<s:url value='/design/designForm.css'></s:url>" rel="stylesheet" type="text/css"/>
            <title><s:text name="modificarPareja"></s:text></title>
        <s:head></s:head>
        </head>
        <body>
        <s:include value="../header.jsp"></s:include>
            <div class="competiciones" style="padding-top: 20px;padding-bottom: 20px;margin-top: 8%; position:absolute;"> 
                <h2 style="text-align:center;"><s:text name="modificarPareja"></s:text></h2>
                <div class="formulario" style="margin-left:20%;margin-right: 20%;">
                <s:form action="modificarParejaAction" style="padding-left: 10px; border-left-width: 1px; border-left-style: solid;border-bottom-width: 1px;border-bottom-style: solid;border-top-width: 1px;border-top-style: solid;border-right-width: 1px;border-right-style: solid;">
                    <s:actionerror cssClass="error"></s:actionerror>
                    <s:label key="nombre"></s:label>: <s:textfield name="nombre" value="%{pareja.nombre}"></s:textfield><br/>
                    <s:label key="usuario1"></s:label>: <s:textfield name="pareja1" value="%{pareja.usuarioByDni2.nombreCompleto}" readonly="true"></s:textfield><br/>
                    <s:label key="usuario2"></s:label>: <s:textfield name="pareja1" value="%{pareja.usuarioByDni1.nombreCompleto}" readonly="true"></s:textfield><br/>
                    <s:hidden name="idPareja" value="%{pareja.idPareja}"></s:hidden>
                    <s:submit key="botonActualizar"></s:submit>
                </s:form>
            </div>
        </div>
        <s:include value="../footer.jsp"></s:include>      
    </body>
</html>
