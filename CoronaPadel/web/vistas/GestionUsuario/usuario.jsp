<%-- 
    Document   : usuario
    Created on : 10-abr-2020, 19:02:49
    Author     : pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="../trophy.png" type="image/png"/>
        <link href="../design/designIndex.css" rel="stylesheet" type="text/css"/>
        <link href="../design/designTable.css" rel="stylesheet" type="text/css"/>
        
        
        <s:set var="usuario" value="%{#session.usuario}"></s:set>
        <title><s:text name="miPerfil"></s:text> - <s:property value="#usuario.nombreCompleto"></s:property></title>
        <s:head/>
    </head>
    <body>
        <s:include value="../header.jsp"></s:include>
        <div style="padding-left: 170px;padding-top: 160px;">
        <h2 style="background-color:#ddd7c8;margin-right: 800px;
text-align: center;"><s:text name="miPerfil"></s:text> <s:property value="#usuario.nombreCompleto"></s:property></h2>
        <s:if test="#usuario.fotoPerfil!=null">
            <img src="../img/<s:property value="#usuario.fotoPerfil"></s:property>" height="100"/>
        </s:if>
        <s:else>
            <h4><s:text name="sinFoto"></s:text></h4>
        </s:else>
        <h2 style="background-color:#ddd7c8;margin-right: 800px;
text-align: center;">Datos</h2>
        <table border="1">
            <thead>
                <tr>
                    <th><s:text name="vista.usuario.dni"></s:text></th>
                    <th><s:text name="vista.usuario.nombre"></s:text></th>
                    <th><s:text name="vista.usuario.usuario"></s:text></th>
                    <th><s:text name="vista.usuario.email"></s:text></th>
                    <th><s:text name="vista.usuario.sexo"></s:text></th>
                    <th><s:text name="vista.usuario.rol"></s:text></th>
                        <s:if test="#usuario.rol == 'Jugador'">
                        <th><s:text name="vista.usuario.categoria"></s:text></th>
                        <th><s:text name="vista.usuario.ladoDeJuego"></s:text></th>
                        </s:if>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><s:property value="#usuario.dni"></s:property></td>
                    <td><s:property value="#usuario.nombreCompleto"></s:property></td>
                    <td><s:property value="#usuario.usuario"></s:property></td>
                    <td><s:property value="#usuario.email"></s:property></td>
                    <td><s:property value="#usuario.sexo"></s:property></td>
                    <td><s:property value="#usuario.rol"></s:property></td>
                    <s:if test="#usuario.rol == 'Jugador'">
                        <td><s:property value="#usuario.categoria"></s:property></td>
                        <td><s:property value="#usuario.ladoDeJuego"></s:property></td>
                    </s:if>
                </tr>
            </tbody>
        </table>
        <s:form action="mostrarFormularioModificarUsuarioAction">
            <s:hidden name="modificar"></s:hidden>
            <s:hidden name="formulario" value="no"></s:hidden>
            <s:submit key="modificarPerfil"></s:submit>
        </s:form>
        <s:if test="#usuario.rol=='Administrador' or #usuario.rol=='Jugador'">
            <s:form action="irParejas">
                <s:submit key="misParejas"></s:submit>
            </s:form>  
        </s:if>
        </div>
        <s:include value="../footer.jsp"></s:include>
    </body>
</html>