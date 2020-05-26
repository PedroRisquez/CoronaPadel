<%-- 
    Document   : login
    Created on : 10-abr-2020, 18:25:16
    Author     : pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <title><s:text name="inicio"></s:text></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../design/design.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" href="trophy.png" type="image/png"/>
        <s:head/>
    </head>
    <body>
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info"><s:text name="inicio"></s:text></h2>
                <p> Introduce el nombre y la contraseña para poder entrar en tu perfil</p>
            </div>
            <s:form action="loginAction">
                <s:actionerror cssClass="error"></s:actionerror>
                    <div class="form-group">
                    <s:label key="usuario.usuario"></s:label>
                    <s:textfield cssClass="form-control item" name="usuario" label="Usuario"></s:textfield><br/>
                    </div>
                    <div class="form-group">
                    <s:label key="usuario.clave"></s:label>
                    <s:password cssClass="form-control" name="clave" label="Contraseña"></s:password><br/>
                    </div>
                    <s:submit cssClass="btn btn-primary btn-block" key="login"></s:submit>
            </s:form>
            <s:form action="cargaRegistroAction">
                <s:submit cssClass="btn btn-primary btn-block" key="register"></s:submit>
            </s:form>
        </div>
    </body>
</html>