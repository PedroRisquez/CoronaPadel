
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <s:set var="usuario" value="%{#session.usuario}"></s:set>
        <link href="../design/designIndex.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" href="../trophy.png" type="image/png"/>
        <title><s:text name="competicion.modificar"></s:text></title>
        <s:head></s:head>
    </head>
    <body>
        <s:include value="../header.jsp"></s:include>
        <h1><s:text name="competicion.formMod"></s:text> <s:property value="%{competicion.nombre}"></s:property></h1>
        <s:form action="terminarModificarCompeticionAction" method="POST">
            <s:label key="administracion"></s:label><s:textfield name="administracion" value="%{competicion.administracion.nombre}" readonly="true"></s:textfield>            
            <s:label key="competicion.formato"></s:label><s:textfield name="formato" value="%{competicion.formato}" readonly="true"></s:textfield>     
            <s:label key="partido.fechaInicio"></s:label><s:textfield name="fechaInicio" value="%{competicion.fechaInicio}" readonly="true"></s:textfield>            
            <s:label key="partido.fechaFin"></s:label><s:textfield name="fechaFin" value="%{competicion.fechaFin}" label="Fecha fin" readonly="true"></s:textfield>     
            <s:label key="competicion.nPartidos"></s:label><s:textfield name="npartidos" value="%{competicion.npartidos}" readonly="true"></s:textfield>     
            <s:label key="competicion.nParejas"></s:label><s:textfield name="nparejas" value="%{competicion.nparejas}" readonly="true"></s:textfield>            
            <s:label key="competicion.nombreC"></s:label><s:textfield name="nombre" value="%{competicion.nombre}"></s:textfield>     
            <s:label key="competicion.descripcion"></s:label><s:textfield name="descripcion" value="%{competicion.descripcion}"></s:textfield>     
            <s:label key="competicion.privada"></s:label><s:textfield name="privada" value="%{competicion.privada}" readonly="true"></s:textfield>              
            <s:hidden name="idCompeticion" value="%{competicion.idCompeticion}"></s:hidden>
            <s:hidden name="formulario" value="si"></s:hidden>
            <s:submit key="botonActualizar"></s:submit>
        </s:form>
        <s:include value="../footer.jsp"></s:include>
    </body>
</html>
