<%-- 
    Document   : registro
    Created on : 08-abr-2020, 23:03:05
    Author     : pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="jquery-1.12.4.min.js" type="text/javascript"></script>
        <link rel="icon" href="<s:url value='/vistas/trophy.png'></s:url>" type="image/png"/>
        <link href="<s:url value='/design/design.css'></s:url>" rel="stylesheet" type="text/css"/>
        <title><s:text name="registro.usuario"></s:text></title>
        <script>
            $(document).ready(function () {
                $("#categoria").css("visibility", "hidden");
                $("label[for='categoria']").css("visibility", "hidden");
                $("[name='ladoDeJuego']").css("visibility", "hidden");
                $("label[for='registroAction_ladoDeJuego']").css("visibility", "hidden");
                $("label[for='registroAction_ladoDeJuegoReves']").css("visibility", "hidden");
                $("label[for='registroAction_ladoDeJuegoDerecha']").css("visibility", "hidden");
                $("label[for='registroAction_ladoDeJuegoAmbos']").css("visibility", "hidden");
                $("#rolJugador").click(function () {
                    $("#categoria").css("visibility", "visible");
                    $("label[for='categoria']").css("visibility", "visible");
                    $("[name='ladoDeJuego']").css("visibility", "visible");
                    $("label[for='registroAction_ladoDeJuego']").css("visibility", "visible");
                    $("label[for='registroAction_ladoDeJuegoReves']").css("visibility", "visible");
                    $("label[for='registroAction_ladoDeJuegoDerecha']").css("visibility", "visible");
                    $("label[for='registroAction_ladoDeJuegoAmbos']").css("visibility", "visible");
                });
                $("#rolAdministrador").click(function () {
                    $("#categoria").css("visibility", "visible");
                    $("label[for='categoria']").css("visibility", "visible");
                    $("[name='ladoDeJuego']").css("visibility", "visible");
                    $("label[for='registroAction_ladoDeJuego']").css("visibility", "visible");
                    $("label[for='registroAction_ladoDeJuegoReves']").css("visibility", "visible");
                    $("label[for='registroAction_ladoDeJuegoDerecha']").css("visibility", "visible");
                    $("label[for='registroAction_ladoDeJuegoAmbos']").css("visibility", "visible");
                });
                $("#rolArbitro").click(function () {
                    $("#categoria").css("visibility", "hidden");
                    $("label[for='categoria']").css("visibility", "hidden");
                    $("[name='ladoDeJuego']").css("visibility", "hidden");
                    $("label[for='registroAction_ladoDeJuego']").css("visibility", "hidden");
                    $("label[for='registroAction_ladoDeJuegoReves']").css("visibility", "hidden");
                    $("label[for='registroAction_ladoDeJuegoDerecha']").css("visibility", "hidden");
                    $("label[for='registroAction_ladoDeJuegoAmbos']").css("visibility", "hidden");
                });
            });
        </script>

    </head>
    <body>
        <div class="containerR">
            <div class="block-heading">
                <h2 class="text-info"><s:text name="form.registro"></s:text></h2></div>
        <s:form action="registroAction" method="POST" enctype = "multipart/form-data" cssStyle="height: 500px;">
                    <s:actionerror cssClass="error"></s:actionerror>
                    <div class="one-half">
                    <div class="form-groupReg"> 
                    <s:label for="fotoPerfil" key="usuario.fotoPerfil"></s:label>
                    <s:file name="fotoPerfil" accept="image/gif,image/png,image/jpeg,image/bmpimage/webp" label="Foto de perfil"></s:file><br/>
                    </div>
                    <div class="form-groupReg"> 
                    <s:label for="nombreCompleto" key="usuario.nombreCompleto"></s:label>
                    <s:textfield cssClass="form-controlReg" name="nombreCompleto" label="Nombre y apellidos"></s:textfield><br/>
                    </div>
                    <div class="form-groupReg" > 
                    <s:label key="usuario.dni"></s:label>
                    <s:textfield  cssClass="form-controlReg" name="dni" label="DNI"></s:textfield><br/>
                    </div>
                    <div class="form-groupReg">
                    <s:label key="usuario.email"></s:label>
                    <s:textfield cssClass="form-controlReg" name="email" label="Correo electronico"></s:textfield><br/>
                    </div>
                    </div>
                    <div class="one-third">
                    <div class="form-groupReg nombreUsu" > 
                    <s:label key="usuario.usuario"></s:label>
                    <s:textfield cssClass="form-controlReg" name="usuario" label="Nombre de usuario"></s:textfield><br/>
                    </div>
                    <div class="form-groupReg"> 
                    <s:label key="usuario.clave"></s:label>
                    <s:password  cssClass="form-controlReg" name="clave" label="Contraseña"></s:password><br/>
                    </div> 
                    <div class="form-groupReg sexo"> 
                    <s:label key="usuario.sexo"></s:label>
                    <s:radio cssClass="radio" label="Sexo" name="sexo"  list="listaDeSexo"></s:radio><br/>
                    </div>
                    </div>
                 
                    <div>            
                    <s:label  for="rol" key="usuario.tipoDeUsuario" cssStyle="padding-right: 189px;"></s:label><br>
                    <s:radio cssClass="radio" label="Tipo de usuario: " id="rol" name="rol" list="listaDeRol"></s:radio><br/>
                    </div>
                    <div class="form-groupReg"> 
                    <s:label  cssStyle="font-size:12px;" for="categoria" key="usuario.categoria"></s:label>
                    <s:select cssStyle="font-size:12px;" cssClass="radio" label="Categoria: " id="categoria" name="categoria" list="listaDeCategoria"></s:select><br/>
                    </div>
                    <div class="form-groupReg"> 
                    <s:label cssStyle="font-size:12px;" for="registroAction_ladoDeJuego" key="usuario.ladoDeJuego"></s:label>
                    <s:radio cssStyle="font-size:12px;" cssClass="radio" label="Lado de juego: " name="ladoDeJuego"  list="listaDeLadoDeJuego"></s:radio><br/>
                    </div>
                    </div>
                    <s:submit cssClass="btn btn-primary btn-block" cssStyle="padding-top: 4px;
margin-top: 100px;" key="Register"></s:submit>
            </s:form>
        </div>
    </body>
</html>
