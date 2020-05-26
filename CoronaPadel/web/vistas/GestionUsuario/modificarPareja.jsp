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
        <link rel="icon" href="../trophy.png" type="image/png"/>
        <link href="../design/designIndex.css" rel="stylesheet" type="text/css"/>
        <title><s:text name="modificarPareja"></s:text></title>
        <s:head></s:head>
    </head>
    <body>
        <s:include value="../header.jsp"></s:include>
        <h1><s:text name="modificarPareja"></s:text></h1>
        <s:form action="modificarParejaAction">
            <s:actionerror cssClass="error"></s:actionerror>
            <s:label key="nombre"></s:label>: <s:textfield name="nombre" value="%{pareja.nombre}"></s:textfield><br/>
            <s:label key="usuario1"></s:label>: <s:textfield name="pareja1" value="%{pareja.usuarioByDni2.nombreCompleto}" readonly="true"></s:textfield><br/>
            <s:label key="usuario2"></s:label>: <s:textfield name="pareja1" value="%{pareja.usuarioByDni1.nombreCompleto}" readonly="true"></s:textfield><br/>
            <s:hidden name="idPareja" value="%{pareja.idPareja}"></s:hidden>
            <s:submit key="botonActualizar"></s:submit>
        </s:form>
    </body>
</html>
