<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <s:set var="usuario" value="%{#session.usuario}"></s:set>
        <link rel="icon" href="../trophy.png" type="image/png"/>
        <link href="../design/designIndex.css" rel="stylesheet" type="text/css"/>
        <title><s:text name="seleccionarPareja"></s:text></title>
    </head>
    <body>
        <h1><s:text name="seleccionarPareja2"></s:text></h1>
        <s:if test="!listaDePareja.isEmpty()">
            <table border="1">
                <thead>
                    <tr>
                        <th><s:text name="pareja.nombre"></s:text></th>
                        <th><s:text name="usuario1"></s:text></th>
                        <th><s:text name="usuario2"></s:text></th>
                        <th></th>
                    </tr>
                </thead>
                <s:iterator value="listaDePareja">
                <tbody>
                    <tr>
                        <td><s:property value="nombre"></s:property></td>
                        <td><s:property value="usuarioByDni2.nombreCompleto"></s:property></td>
                        <td><s:property value="usuarioByDni1.nombreCompleto"></s:property></td>
                        <td><s:form action="inscribirse2Action">
                                <s:hidden name="idPareja" value="%{idPareja}"></s:hidden>
                                <s:submit key="confirmarSeleccion"></s:submit>
                        </s:form>
                        </td>
                    </tr>
                </tbody>
                </s:iterator>
            </table>
        </s:if>
        <s:else>
            <h4><s:text name="errorAsginar"></s:text></h4>
        </s:else>
        <s:include value="../footer.jsp"></s:include>    
    </body>
</html>
