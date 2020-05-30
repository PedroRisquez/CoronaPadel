<%-- 
    Document   : verAdmin
    Created on : 14-abr-2020, 12:41:15
    Author     : Nerea
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <s:set var="usuario" value="%{#session.usuario}"></s:set>
            <link href="../design/designIndex.css" rel="stylesheet" type="text/css"/>
            <link href="../design/designTable.css" rel="stylesheet" type="text/css"/>
            <link rel="icon" href="<s:url value='/vistas/trophy.png'></s:url>" type="image/png"/>
            <title><s:text name="administracion"></s:text> <s:property value="#session.admin.nombre"></s:property></title>
        </head>
        <body>
        <s:include value="../header.jsp"></s:include>
            <div style="padding-left: 170px;padding-top: 160px;">
                <h2 style="background-color:#ddd7c8;margin-right: 800px;
                    text-align: center;"><s:property value="#session.admin.nombre"></s:property></h2>
                <h4  style="background-color:#ddd7c8;margin-right: 800px;
                     text-align: center;"><s:text name="pistas"></s:text></h4>
            <s:if test="%{#session.listadoPistas.isEmpty()}">
                <p><s:text name="pistas.noExisten"></s:text></p>
            </s:if>
            <s:else>
                <table border="1">
                    <thead>
                        <tr>
                            <th><s:text name="pista.id"></s:text></th>
                            <th><s:text name="pista.localizacion"></s:text></th>
                            <th><s:text name="pista.cubierta"></s:text></th>
                            <th><s:text name="pista.pista"></s:text></th>
                            <th><s:text name="pista.suelo"></s:text></th>
                            </tr>
                        </thead>
                        <tbody>
                        <s:iterator value="#session.listadoPistas">
                            <tr>
                                <td><s:property value="idPista"></s:property></td>
                                <td><s:property value="localizacion"></s:property></td>
                                <td><s:property value="tipoDeCubierta"></s:property></td>
                                <td><s:property value="tipoDePista"></s:property></td>
                                <td><s:property value="tipoDeSuelo"></s:property></td>
                                <s:if test="%{#session.usuario.rol == 'Administrador' && #session.admin.usuario.dni == #session.usuario.dni}">
                                    <td>
                                        <s:form action="irActualizarPista">
                                            <s:hidden name="id" value="%{idPista}"></s:hidden>
                                            <s:submit key="botonActualizar"></s:submit>
                                        </s:form>
                                    </td>
                                </s:if>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </s:else>

            <s:if test="%{#session.usuario.rol == 'Administrador' && #session.admin.usuario.dni == #session.usuario.dni}">
                <s:form action="irRegistrarPista">
                    <s:submit key="pista.botonRegistro"></s:submit>
                </s:form>
            </s:if>
        </div>
        <div style="padding-left: 170px;padding-top: 30px;">
            <h4  style="background-color:#ddd7c8;margin-right: 800px;
                 text-align: center;"><s:text name="competiciones"></s:text></h4>
            <s:if test="%{#session.listadoCompeticiones.isEmpty()}">
                <p><s:text name="competiciones.noExisten"></s:text></p>
            </s:if>
            <s:else>
                <table border="1">
                    <thead>
                        <tr>
                            <th><s:text name="competicion.nombre"></s:text></th>
                            <th><s:text name="competicion.descripcion"></s:text></th>
                            </tr>
                        </thead>
                        <tbody>
                        <s:iterator value="#session.listadoCompeticiones">
                            <tr>
                                <td><s:property value="nombre"></s:property></td>
                                <td><s:property value="descripcion"></s:property></td>
                                    <td>
                                    <s:form action="informacionExtraCompeticionAction">
                                        <s:hidden name="idCompeticion" value="%{idCompeticion}"></s:hidden>
                                        <s:submit key="botonVer"></s:submit>
                                    </s:form>
                                </td>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </s:else>
        </div>
        <div style="padding-left: 170px;padding-top: 30px;padding-bottom: 90px;">   
            <h4  style="background-color:#ddd7c8;margin-right: 800px;
                 text-align: center;"><s:text name="clasificacion"></s:text></h4>
            <s:if test="%{#session.listadoClasificaciones.isEmpty()}">
                <p><s:text name="clasificacion.noExiste"></s:text></p>
            </s:if>
            <s:else>
                <table border="1" style="margin-bottom: 80px;">
                    <thead>
                        <tr>
                            <th><s:text name="clasificacion.usuario"></s:text></th>
                            <th><s:text name="clasificacion.puntuacion"></s:text></th>
                            </tr>
                        </thead>
                        <tbody>
                        <s:iterator value="#session.listadoClasificaciones">
                            <tr>
                                <td><s:property value="usuario.nombreCompleto"></s:property></td>
                                <td><s:property value="puntuacion"></s:property></td>
                                </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </s:else>
        </div>
        <s:include value="../footer.jsp"></s:include>
    </body>
</html>
