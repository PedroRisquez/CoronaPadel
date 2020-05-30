<%-- 
    Document   : verAdministraciones
    Created on : 14-abr-2020, 12:30:39
    Author     : Nerea
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="<s:url value='/vistas/trophy.png'></s:url>" type="image/png"/>
        <link href="../design/designIndex.css" rel="stylesheet" type="text/css"/>
        <link href="../design/designTable.css" rel="stylesheet" type="text/css"/>
        <title><s:text name="administraciones.verTodas"></s:text></title>
        </head>
        <body>
        <s:set var="usuario" value="%{#session.usuario}"></s:set>
        <s:include value="../header.jsp"></s:include>
            <div style="padding-left: 170px;padding-top: 160px;">
                <h2 style="background-color:#ddd7c8;margin-right: 800px;
text-align: center;"><s:text name="administraciones"></s:text></h2>
            <s:if test="%{#session.listadoAdministraciones.isEmpty()}">
                <p><s:text name="administraciones.noExisten"></s:text></p>
            </s:if>
            <s:else>
                <table border="1">
                    <thead>
                        <tr>
                            <th><s:text name="administracion.nombre"></s:text></th>
                            </tr>
                        </thead>
                        <tbody>
                        <s:iterator value="#session.listadoAdministraciones">
                            <tr>
                                <td><s:property value="nombre"></s:property></td>
                                    <td>
                                    <s:form action="verAdmin">
                                        <s:hidden name="id" value="%{idAdministracion}"></s:hidden>
                                        <s:submit key="botonVer"></s:submit>
                                    </s:form>
                                </td>
                                <s:if test="%{#session.usuario.rol == 'Administrador' && usuario.dni == #session.usuario.dni}">
                                    <td>
                                        <s:form action="irActualizarAdmin">
                                            <s:hidden name="id" value="%{idAdministracion}"></s:hidden>
                                            <s:submit key="administracion.botonActualizar"></s:submit>
                                        </s:form>
                                    </td>
                                    <td>
                                        <s:form action="borrarAdmin">
                                            <s:hidden name="id" value="%{idAdministracion}"></s:hidden>
                                            <s:submit key="botonBorrar"></s:submit>
                                        </s:form>
                                    </td>
                                </s:if>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </s:else>
            <s:if test="%{#session.usuario.rol == 'Administrador'}">
                <s:form action="/vistas/GestionAdministracion/formAltaAdmin.jsp">
                    <s:submit key="administracion.botonRegistro"></s:submit>
                </s:form>
            </s:if>
        </div>
        <s:include value="../footer.jsp"></s:include>

    </body>
</html>
