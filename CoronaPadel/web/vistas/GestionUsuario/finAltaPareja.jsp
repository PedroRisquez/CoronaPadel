<%-- 
    Document   : finAltaPareja
    Created on : 21-may-2020, 18:29:54
    Author     : pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <s:set var="usuario" value="%{#session.usuario}"></s:set>
        <link href="../design/designIndex.css" rel="stylesheet" type="text/css"/>
         <link rel="icon" href="<s:url value='/vistas/trophy.png'></s:url>" type="image/png"/>

        <title><s:text name="titleAlta"></s:text></title>
    </head>
    <body>
        <s:include value="../header.jsp"></s:include>
        <s:set var="pareja" value="%{#session.pareja}"></s:set>
        <h1><s:text name="introducirNombre"></s:text></h1>
        <s:form action="altaParejaAction">
            <s:label key="parejaPadel"></s:label><s:textfield name="pareja" value="%{#pareja.nombreCompleto}" label="Su pareja de padel es" readonly="true"></s:textfield><br/>
            <s:label key="nombre"></s:label><s:textfield name="nombre" label="Nombre"></s:textfield><br/>
            
            <s:submit key="crearPareja"></s:submit>
        </s:form>
        <s:include value="../footer.jsp"></s:include>
    </body>
</html>
