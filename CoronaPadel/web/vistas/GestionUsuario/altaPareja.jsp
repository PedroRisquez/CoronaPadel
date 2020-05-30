<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <s:set var="usuario" value="%{#session.usuario}"></s:set>
            <link href="../design/designIndex.css" rel="stylesheet" type="text/css"/>
            <link href="../design/designTable.css" rel="stylesheet" type="text/css"/>
            <link href="../design/designForm.css" rel="stylesheet" type="text/css"/>

            <link rel="icon" href="<s:url value='/vistas/trophy.png'></s:url>" type="image/png"/>
        <title><s:text name="nuevaPareja"></s:text></title>
        <s:head/>
    </head>
    <body>
        <s:include value="../header.jsp"></s:include>
            <div style="padding-left: 170px;padding-top: 100px;padding-bottom: 400px; background-color: #fff;">
                <h2 style="background-color:#ddd7c8; opacity: 80%; margin-right: 800px;
                    text-align: center;"><s:text name="crearPareja"></s:text></h2>
            <s:form action="filtraUsuarioPareja" >
                <s:label key="usuarioOdni"></s:label><s:textfield name="usuarioOdni" label="Intruzca el usuario o el dni de su pareja"></s:textfield>
                <s:submit key="botonBuscar"></s:submit>
            </s:form>
            <s:form action="irFormParejaAction">
                <s:submit key="botonFiltro"></s:submit>
            </s:form>
            <h2 style="background-color:#ddd7c8;margin-right: 800px;
                text-align: center;"><s:text name="seleccionaPareja"></s:text>:</h2>
            <s:if test="!listaDeUsuario.isEmpty()">
                <table border="1">
                    <thead>
                        <tr>
                            <th><s:text name="vista.usuario.nombre"></s:text></th>
                            <th><s:text name="vista.usuario.usuario"></s:text></th>
                            <th><s:text name="vista.usuario.sexo"></s:text></th>
                            <th><s:text name="vista.usuario.categoria"></s:text></th>
                            <th><s:text name="vista.usuario.ladoDeJuego"></s:text></th>
                            </tr>
                        </thead>
                    <s:actionerror cssClass="error"></s:actionerror><br/>
                    <s:iterator value="listaDeUsuario">
                        <tbody>    
                            <tr>
                                <td><s:property value="nombreCompleto"></s:property></td>
                                <td><s:property value="usuario"></s:property></td>
                                <td><s:property value="sexo"></s:property></td>
                                <td><s:property value="categoria"></s:property></td>
                                <td><s:property value="ladoDeJuego"></s:property></td>
                                <td><s:form action="irFinAltaParejaAction">                                   
                                        <s:hidden name="dni" value="%{dni}"></s:hidden>
                                        <s:hidden name="formulario" value="no"></s:hidden>
                                        <s:submit key="seleccionar"></s:submit>
                                    </s:form></td>
                            </tr>
                        </tbody>
                    </s:iterator>
                </table>
            </s:if>
            <s:else>
                <h4 style="background-color:#ddd7c8;margin-right: 800px;
                    text-align: center;"><s:text name="noHayUsuario"></s:text></h4>
            </s:else>
        </div>
        <s:include value="../footer.jsp"></s:include>
    </body>
</html>
