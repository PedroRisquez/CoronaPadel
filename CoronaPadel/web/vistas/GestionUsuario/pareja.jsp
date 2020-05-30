<%-- 
    Document   : pareja
    Created on : 28-abr-2020, 18:04:54
    Author     : pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="<s:url value='/vistas/trophy.png'></s:url>" type="image/png"/>
        <s:set var="usuario" value="%{#session.usuario}"></s:set>
        <link href="../design/designIndex.css" rel="stylesheet" type="text/css"/>
        <link href="../design/designTable.css" rel="stylesheet" type="text/css"/>
        <title><s:text name="misParejas"></s:text> - <s:property value="#usuario.nombreCompleto"></s:property></title>
        </head>
        <body>
        <s:include value="../header.jsp"></s:include>
        <div style="padding-left: 170px;padding-top: 160px;">
        <h2 style="background-color:#ddd7c8;margin-right: 800px;
text-align: center;"><s:text name="parejasDe"></s:text> <s:property value="#usuario.nombreCompleto"></s:property></h2>
        <s:if test="!listaDeParejas.isEmpty()">
            <table border="1">
                <thead>
                    <tr>
                        <th><s:text name="pareja.nombre"></s:text></th>
                        <th><s:text name="usuario1"></s:text></th>
                        <th><s:text name="usuario2"></s:text></th>
                            <th></th>
                        </tr>
                    </thead>
                <s:iterator value="listaDeParejas">
                    <tbody>
                        <tr>
                            <td><s:property value="nombre"></s:property></td>
                            <td><s:property value="usuarioByDni2.nombreCompleto"></s:property></td>
                            <td><s:property value="usuarioByDni1.nombreCompleto"></s:property></td>
                            <td><s:form action="seleccionarModificarParejaAction">
                                    <s:hidden name="idPareja" value="%{idPareja}"></s:hidden>
                                    <s:submit key="botonActualizar"></s:submit>
                                </s:form></td>
                        </tr>
                    </tbody>
                </s:iterator>
            </table>

        </s:if>
        <s:else>
            <h4 style="background-color:#ddd7c8;margin-right: 800px;
text-align: center;"><s:text name="sinParejas"></s:text></h4>
        </s:else>
        <br/>
        <s:form action="irFormParejaAction">
            <s:submit key="crearPareja"></s:submit>
        </s:form>
        </div>
        
        <s:include value="../footer.jsp"></s:include>
    </body>
</html>
