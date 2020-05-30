<%-- 
    Document   : completarCompeticion
    Created on : 27-abr-2020, 12:27:30
    Author     : pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <s:set var="usuario" value="%{#session.usuario}"></s:set>
        <link rel="icon" href="<s:url value='/vistas/trophy.png'></s:url>" type="image/png"/>
            <link href="<s:url value='/design/designIndex.css'></s:url>" rel="stylesheet" type="text/css"/>
            <link href="<s:url value='/design/designForm.css'></s:url>" rel="stylesheet" type="text/css"/>
            <link href="<s:url value='/design/designTable.css'></s:url>" rel="stylesheet" type="text/css"/>
        <s:set var="competicion" value="%{#session.competicion}"></s:set>
        <title><s:text name="competicion.alta"></s:text></title>
        <s:head/>
    </head>
    <body>
        <s:include value="../header.jsp"></s:include>
            <div class="competiciones" style="padding-top: 20px;padding-bottom: 300px;margin-top: 8%; position:absolute;">
                <h2><s:text name="competicion.form"></s:text></h2>
                <div class="formulario" style="margin-left:20%;margin-right: 20%;">                
            <s:form action="finCompletaCompeticionAction" style="padding-left: 10px; border-left-width: 1px; border-left-style: solid;border-bottom-width: 1px;border-bottom-style: solid;border-top-width: 1px;border-top-style: solid;border-right-width: 1px;border-right-style: solid;">
                <s:actionerror name="error" value="" ></s:actionerror>
                <s:actionerror cssClass="error"></s:actionerror>
                <s:if test="!listaDeParejas.isEmpty()">
                    <table border="1" style="width:100%;">
                        <thead>
                            <tr>
                                <th><s:text name="usuario1"></s:text></th>
                                <th><s:text name="usuario2"></s:text></th>
                                <th><s:text name="pareja.nombre"></s:text></th>
                                <th><s:text name="seleccionar"></s:text></th>
                                </tr>
                            </thead>
                            <tbody>
                            <s:iterator value="listaDeParejas">
                                <tr>
                                    <td><s:property value="usuarioByDni2.nombreCompleto"></s:property></td>
                                    <td><s:property value="usuarioByDni1.nombreCompleto"></s:property></td>
                                    <td><s:property value="nombre"></s:property></td>
                                    <td><s:checkbox name="idPareja" value="false" fieldValue="%{idPareja}" theme="simple"></s:checkbox></td>
                                    </tr>
                            </s:iterator>
                        </tbody> 
                    </table>
                </s:if>
                <s:else>
                    <h2>No hay parejas que puedan jugar en la fecha seleccionada.</h2>
                </s:else>
                <s:if test="!listaDeArbitros.isEmpty()">
                    <s:label key="rol.arbitro"></s:label><s:radio list="listaDeArbitros" name="dni" listValue="%{nombreCompleto}" listKey="dni"></s:radio>
                </s:if>
                <s:else>
                    <h2>No hay arbitros disponibles para la fecha seleccionada.</h2>
                </s:else>
                <s:hidden name="asigna" value="true"></s:hidden>
                <div><s:submit key="asignarParejas"></s:submit></div>
            </s:form>
        </div>
    </div>
    <s:include value="../footer.jsp"></s:include>   
</body>
</html>
