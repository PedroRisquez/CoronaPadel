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
            <link href="../design/designIndex.css" rel="stylesheet" type="text/css"/>
            <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons%22%3E">
            <link rel="icon" href="vistas/trophy.png" type="image/png"/>
        </head>
        <body>
        <s:set name="usuario" value="%{#session.usuario}"></s:set>
        <s:include value="header.jsp"></s:include>  
        <s:if test="#usuario.rol=='Arbitro'">
            <s:action name="gestionPartidoAction"></s:action>
            <h1><s:text name="partidosDe"></s:text> <s:property value="#usuario.nombreCompleto"></s:property></h1> 

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
        </s:if>
            <div id="inscripciones">
            <s:iterator value="listaDeCompeticionesDisponibles">
                <s:property value="nombre"></s:property><br/>
                <s:property value="descripcion"></s:property><br/>
                <s:property value="administracion.nombre"></s:property><br/>
                <s:form action="inscribirse1Action">
                    <s:hidden name="idCompeticion" value="%{idCompeticion}"></s:hidden>
                    <s:if test="%{#usuario.rol=='Jugador'}">
                        <s:submit key="Inscribirse"></s:submit>
                    </s:if>
                    <s:else>
                        <s:submit key="Inscribirse" disabled="true"></s:submit>
                    </s:else>
                </s:form>
            </s:iterator>
        </div>

        <s:include value="footer.jsp"></s:include>
    </body>
</html>
