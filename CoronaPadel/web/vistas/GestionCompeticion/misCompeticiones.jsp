<%-- 
    Document   : misCompeticiones
    Created on : 27-may-2020, 11:21:36
    Author     : Nerea
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="../trophy.png" type="image/png"/>
        <link href="<s:url value='/design/designIndex.css'></s:url>" rel="stylesheet" type="text/css"/>
        <link href="<s:url value='/design/designTable.css'></s:url>" rel="stylesheet" type="text/css"/>
        <s:set var="usuario" value="%{#session.usuario}"></s:set>
        <title><s:text name="competicion.verTodas"></s:text> - <s:property value="#usuario.nombreCompleto"></s:property></title>
        <s:head/>
    </head>
    <body>
        <s:include value="../header.jsp"></s:include>
        <div style="padding-left: 170px;padding-top: 160px;">
        <h2 style="background-color:#ddd7c8;margin-right: 800px;
text-align: center;"><s:text name="competicion.verDe"></s:text> <s:property value="#usuario.nombreCompleto"></s:property></h2>  
        <s:if test ="!listaCompeticion.isEmpty()">
            <table border="1" style="left: 200px;top: 120px;">
                <thead>
                    <tr>
                        <th><s:text name="competicion.nombre"></s:text></th>
                        <th><s:text name="competicion.descripcion"></s:text></th>
                        <th><s:text name="competicion.masInfo"></s:text></th>
                        <th><s:text name="competicion.verPartidos"></s:text></th>
                        <th><s:text name="competicion.verRanking"></s:text></th>
                        </tr>
                    </thead>
                    <tbody>
                    <s:iterator value="listaCompeticion">
                        <tr>
                            <td><s:property value="nombre"></s:property></td>
                            <td><s:property value="descripcion"></s:property></td>
                            <td><s:form action="extraInfo">
                                    <s:hidden name="idCompeticion" value="%{idCompeticion}"></s:hidden>
                                    <s:submit key="info"></s:submit>
                                </s:form>
                            </td>
                                
                            <td>
                                <s:form action="verPartidos">
                                    <s:hidden name="idCompeticion" value="%{idCompeticion}"></s:hidden>
                                    <s:submit key="partidos"></s:submit>
                                </s:form>
                            </td>
                            <td>
                                <s:form action="verRankingJugador">
                                    <s:hidden name="idCompeticion" value="%{idCompeticion}"></s:hidden>
                                    <s:submit key="ranking"></s:submit>
                                </s:form>
                            </td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
            <s:if test="!listaPartidos.isEmpty()">
                <table border="1">
                    <thead>
                        <tr>
                            <th><s:text name="rol.arbitro"></s:text></th>
                            <th><s:text name="partido.fechaInicio"></s:text></th>
                            <th><s:text name="partido.duracion"></s:text></th>
                            <th><s:text name="partido.parejaLocal"></s:text></th>
                            <th><s:text name="partido.puntuacion"></s:text></th>
                            <th><s:text name="partido.resultado"></s:text></th>
                            <th><s:text name="partido.puntuacion"></s:text></th>
                            <th><s:text name="partido.parejaVisitante"></s:text></th>
                            </tr>
                        </thead>
                        <tbody>
                        <s:iterator value="listaPartidos">
                            <tr>
                                <td><s:property value="usuario.nombreCompleto"></s:property></td>
                                <td><s:date name="fechaInicio" format="dd/MM/yyyy - HH:mm"></s:date></td>
                                <td><s:property value="duracion"></s:property></td>
                                <s:iterator value="resultados">
                                    <td><s:property value="parejaByIdParejaVisitante.nombre"></s:property></td>
                                    <td><s:property value="puntuacionVisitante"></s:property></td>                               
                                        <td>-</td>
                                        <td><s:property value="puntuacionLocal"></s:property></td>
                                    <td><s:property value="parejaByIdParejaLocal.nombre"></s:property></td> 
                                </s:iterator>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </s:if>  

            <s:if test="!listaRanking.isEmpty()">
                <table border="1">
                    <thead>
                        <tr>
                            <th><s:text name="pareja.nombre"></s:text></th>
                            <th><s:text name="partido.puntuacion"></s:text></th>
                            </tr>
                        </thead>
                        <tbody>
                        <s:iterator value="listaRanking">
                            <tr>
                            <s:if test="%{pareja.usuarioByDni1.nombreCompleto == #usuario.nombreCompleto or 
                                  pareja.usuarioByDni2.nombreCompleto == #usuario.nombreCompleto}">
                                <td style="font-weight: bold;"><s:property value="pareja.nombre"></s:property></td>   
                                    <td style="font-weight: bold;"><s:property value="puntuacion"></s:property></td>
                            </s:if>
                            <s:else>
                                <td><s:property value="pareja.nombre"></s:property></td>   
                                <td><s:property value="puntuacion"></s:property></td>
                            </s:else>
                                
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </s:if>  
            <s:if test="competicion!=null">
                <h2 style="background-color:#ddd7c8;margin-right: 800px;
text-align: center;"><s:text name="competicion.datos"></s:text></h2>
                    <table border="1">
                        <tbody>
                            <tr>
                                <td><s:text name="competicion.nombreC"></s:text></td>
                            <td><s:property value="competicion.nombre"></s:property></td>
                            </tr>
                            <tr>
                                <td><s:text name="competicion.descripcion"></s:text></td>
                            <td><s:property value="competicion.descripcion"></s:property></td>
                            </tr>
                            <tr>
                                <td><s:text name="competicion.formato"></s:text> </td>
                            <td><s:property value="competicion.formato"></s:property></td>
                            </tr>
                            <tr>
                                <td><s:text name="competicion.nparejas"></s:text></td>
                            <td><s:property value="competicion.nparejas"></s:property></td>
                            </tr>
                            <tr>
                                <td><s:text name="competicion.npartidos"></s:text></td>
                            <td><s:property value="competicion.npartidos"></s:property></td>
                            </tr>
                            <tr>
                                <td><s:text name="competicion.fechaInicio"></s:text></td>
                            <td><s:date name="competicion.fechaInicio" format="dd/MM/yyyy"></s:date></td>
                            </tr>
                            <tr>
                                <td><s:text name="competicion.fechaFin"></s:text></td>
                            <td><s:date name="competicion.fechaFin" format="dd/MM/yyyy"></s:date></td>
                            </tr>
                            <tr>
                                <td><s:text name="competicion.privada"></s:text></td>
                                <td>
                                <s:if test ="%{competicion.privada}">
                                    <s:text name="si"></s:text>
                                </s:if>
                                <s:else>
                                    <s:text name="no"></s:text>
                                </s:else>
                            </td>
                        </tr>
                        <tr>
                            <td><s:text name="administracion.nombre"></s:text></td>
                            <td><s:property value="competicion.administracion.nombre"></s:property></td>
                            </tr>
                            <tr>
                                <td><s:text name="administracion.admin"></s:text></td>
                            <td><s:property value="competicion.usuario.nombreCompleto"></s:property></td>
                            </tr>
                        </tbody>
                    </table>
            </s:if>
        </s:if>
        <s:else>
            <p><s:text name="noCompeticiones"></s:text></p>  
        </s:else>
        </div>
        <s:include value="../footer.jsp"></s:include>
    </body>
</html>
