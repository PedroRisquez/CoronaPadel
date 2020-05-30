<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <s:set var="usuario" value="%{#session.usuario}"></s:set>
        <link rel="icon" href="<s:url value='/vistas/trophy.png'></s:url>" type="image/png"/>
        <link href="../design/designIndex.css" rel="stylesheet" type="text/css"/>
        <link href="../design/designTable.css" rel="stylesheet" type="text/css"/>
        <title><s:text name="seleccionarPareja"></s:text></title>
    </head>
    <body>
        <s:include value="../header.jsp"></s:include>
        <div style="padding-left: 170px;padding-top: 160px;">
        <h1 style="background-color:#ddd7c8;margin-right: 800px;
text-align: center;"><s:text name="seleccionarPareja2"></s:text></h1>
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
            <h4 style="background-color:#ddd7c8;margin-right: 800px;
text-align: center;"><s:text name="errorAsginar"></s:text></h4>
        </s:else>
        </div>
        <s:include value="../footer.jsp"></s:include>    
    </body>
</html>
