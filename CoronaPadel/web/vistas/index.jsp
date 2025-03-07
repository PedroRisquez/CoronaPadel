<%-- 
    Document   : index
    Created on : 08-abr-2020, 22:56:34
    Author     : pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <title><s:text name="paginaPrincipal"></s:text> - CoronaPadel</title>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link href="<s:url value='/design/designIndex.css'></s:url>" rel="stylesheet" type="text/css"/>
            <link href="<s:url value='/design/designTable.css'></s:url>" rel="stylesheet" type="text/css"/>
            <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons%22%3E">
            <link rel="icon" href="<s:url value='/vistas/trophy.png'></s:url>" type="image/png"/>
        </head>
        <body>
        <s:set name="usuario" value="%{#session.usuario}"></s:set>
        <s:include value="header.jsp"></s:include>  
        <s:if test="#usuario.rol=='Arbitro' || #usuario.rol=='Referee'">
            <div style="padding-left: 170px;padding-top: 10%;margin-bottom: 20%;">
            <s:if test="!listaDePartidosArbitro.isEmpty()">
                <s:action name="gestionPartidoAction"></s:action>
                <h2 style="background-color:#ddd7c8;margin-right: 800px;
text-align: center;"><s:text name="partidosde"></s:text> <s:property value="#usuario.nombreCompleto"></s:property></h2> 

                    <table border="1">
                        <thead>
                            <tr>
                             <th><s:text name="partido.fechaInicio"></s:text></th>
                            <th><s:text name="partido.duracion"></s:text></th>
                            <th><s:text name="partido.parejaLocal"></s:text></th>
                            <th><s:text name="partido.puntuacion"></s:text></th>
                            <th><s:text name="partido.resultado"></s:text></th>
                            <th><s:text name="partido.puntuacion"></s:text></th>
                            <th><s:text name="partido.parejaVisitante"></s:text></th>
                            <th><s:text name="botonActualizar"></s:text></th>
                            </tr>
                        </thead>
                        <tbody>
                        <s:iterator value="listaDePartidosArbitro">
                            <tr>
                                <td><s:date name="fechaInicio" format="dd/MM/yyyy - HH:mm"></s:date></td>
                                <td><s:property value="duracion"></s:property></td>
                                <s:iterator value="resultados">

                                    <td><s:property value="parejaByIdParejaLocal.nombre"></s:property></td>
                                    <td><s:property value="puntuacionLocal"></s:property></td>
                                        <td>-</td>
                                        <td><s:property value="puntuacionVisitante"></s:property></td>
                                    <td><s:property value="parejaByIdParejaVisitante.nombre"></s:property></td>

                                        <td><s:form action="mostrarModificarPartidoAction">
                                            <s:hidden name="idResultado" value="%{idResultado}"></s:hidden>
                                            <s:hidden name="idPartido" value="%{idPartido}"></s:hidden>
                                            <s:submit key="botonActualizar"></s:submit>
                                        </s:form></td>
                                    </s:iterator>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </s:if>
            <s:if test="partido!=null">
                <s:form action="modificarPartidoAction">
                    <s:textfield label="Duracion" name="duracion" value="%{partido.duracion}"></s:textfield>
                    <s:textfield label="Pareja Local" value="%{resultado.parejaByIdParejaLocal.nombre}" readonly="true"></s:textfield>
                    <s:textfield label="Puntuacion local" name="puntuacionLocal" value="%{resultado.puntuacionLocal}"></s:textfield>                
                    <s:textfield label="Puntuacion visitante" name="puntuacionVisitante" value="%{resultado.puntuacionVisitante}"></s:textfield>                                          
                    <s:textfield label="Pareja Visitante" value="%{resultado.parejaByIdParejaVisitante.nombre}" readonly="true"></s:textfield>
                    <s:hidden name="idResultado" value="%{resultado.idResultado}"></s:hidden>
                    <s:hidden name="idPartido" value="%{partido.idPartido}"></s:hidden>
                    <s:submit key="partido.finalizar"></s:submit>
                </s:form>
            </s:if>
                </div>
        </s:if>
        <div id="inscripciones" style="padding-bottom: 284px;">
            <s:iterator value="listaDeCompeticionesDisponibles">
                <div class="competicion" style="border-top-width: 1px;border-top-style: solid;border-bottom-width: 1px;border-bottom-style: solid;border-left-width: 1px;border-left-style: solid;border-right-width: 1px;border-right-style: solid;"><s:property value="nombre"></s:property><br/></div>
                <div class="competicion" style="border-top-width: 1px;border-top-style: solid;border-bottom-width: 1px;border-bottom-style: solid;border-left-width: 1px;border-left-style: solid;border-right-width: 1px;border-right-style: solid;"><s:property value="descripcion"></s:property><br/></div>
               <div class="competicion" style="border-top-width: 1px;border-top-style: solid;border-bottom-width: 1px;border-bottom-style: solid;border-left-width: 1px;border-left-style: solid;border-right-width: 1px;border-right-style: solid;"><s:property value="administracion.nombre"></s:property><br/></div>
               <s:form action="inscribirse1Action" cssClass="margin-top: 20px;">
                    <s:hidden name="idCompeticion" value="%{idCompeticion}"></s:hidden>
                    <s:if test="#usuario.rol=='Jugador' || #usuario.rol=='Player'">
                        <s:submit key="inscribirse"></s:submit>
                    </s:if>
                    <s:else>
                        <s:submit key="inscribirse" disabled="true"></s:submit>
                    </s:else>
                </s:form><br/>
            </s:iterator>
        </div>

        <s:include value="footer.jsp"></s:include>
    </body>
</html>
