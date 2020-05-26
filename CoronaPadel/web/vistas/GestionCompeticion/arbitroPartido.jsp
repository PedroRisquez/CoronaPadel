<%-- 
    Document   : arbitroPartido
    Created on : 21-abr-2020, 20:57:57
    Author     : pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="icon" href="../trophy.png" type="image/png"/>
         <link href="../design/designIndex.css" rel="stylesheet" type="text/css"/>
        <s:set var="usuario" value="%{#session.usuario}"></s:set>
        <title><s:text name="partidos.gestion"></s:text></title>
        <s:head/>
        </head>
        <body>
            <s:include value="../header.jsp"></s:include>
            <h1><s:text name="partidosde"></s:text> <s:property value="#usuario.nombreCompleto"></s:property></h1> 
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
                            
                            <td>
                            <s:form action="mostrarModificarPartidoAction">
                                <s:hidden name="idResultado" value="%{idResultado}"></s:hidden>
                                <s:hidden name="idPartido" value="%{idPartido}"></s:hidden>
                                <s:submit name="botonActualizar"></s:submit>
                            </s:form>
                            </td>
                        </s:iterator>
                    </tr>
                </s:iterator>
            </tbody>
        </table>

        <s:if test="partido!=null">
            <s:form action="modificarPartidoAction">
                <s:actionerror cssClass="error"></s:actionerror>
                <s:label key="partido.duracion"></s:label><s:textfield name="duracion" value="%{partido.duracion}"></s:textfield>
                <s:label key="partido.parejaLocal"></s:label><s:textfield value="%{resultado.parejaByIdParejaLocal.nombre}" readonly="true"></s:textfield>
                <s:label key="partido.puntuacionLocal"></s:label><s:textfield name="puntuacionLocal" value="%{resultado.puntuacionLocal}"></s:textfield>                
                <s:label key="partido.puntuacionVisitante"></s:label><s:textfield name="puntuacionVisitante" value="%{resultado.puntuacionVisitante}"></s:textfield>                                          
                <s:label key="partido.parejaVisitante"></s:label><s:textfield value="%{resultado.parejaByIdParejaVisitante.nombre}" readonly="true"></s:textfield>
                <s:hidden name="idResultado" value="%{resultado.idResultado}"></s:hidden>
                <s:hidden name="idPartido" value="%{partido.idPartido}"></s:hidden>
                <s:submit name="botonFinalizarPartido"></s:submit>
            </s:form>
        </s:if>
        <s:include value="../footer.jsp"></s:include>
    </body>
</html>
