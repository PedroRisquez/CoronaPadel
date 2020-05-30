<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="<s:url value='/vistas/trophy.png'></s:url>" type="image/png"/>
        <s:set var="usuario" value="%{#session.usuario}"></s:set>
            <link href="<s:url value='/design/designIndex.css'></s:url>" rel="stylesheet" type="text/css"/>
            <link href="<s:url value='/design/designForm.css'></s:url>" rel="stylesheet" type="text/css"/>
            <title><s:text name="modificarPerfil"></s:text> - <s:property value="#usuario.nombreCompleto"></s:property></title>
        <s:head/>
    </head>
    <body>
        <s:include value="../header.jsp"></s:include>
            <div class="competiciones" style="padding-top: 20px;padding-bottom: 300px;margin-top: 8%; position:absolute;">
                <h2 style="text-align:center;"><s:text name="modificarPerfil"></s:text></h2>
                <div class="formulario" style="margin-left:20%;margin-right: 20%;">    
                <s:form action="modificarUsuarioAction" method="POST" enctype = "multipart/form-data" style="padding-left: 10px; border-left-width: 1px; border-left-style: solid;border-bottom-width: 1px;border-bottom-style: solid;border-top-width: 1px;border-top-style: solid;border-right-width: 1px;border-right-style: solid;">
                    <s:if test="#usuario.fotoPerfil!=null">
                        <img src="../img/<s:property value="#usuario.fotoPerfil"></s:property>" height="100"/>
                    </s:if>
                    <s:else>
                        <h4><s:text name="perfilSinFoto"></s:text></h4>
                    </s:else>
                    <s:actionerror cssClass="error"></s:actionerror><br/>    
                    <s:label for="fotoPerfil" key="usuario.fotoPerfil"></s:label><s:file name="fotoPerfil" accept="image/gif,image/png,image/jpeg,image/bmpimage/webp" label="Foto de perfil"></s:file><br/>
                    <s:label for="nombreCompleto" key="usuario.nombreCompleto"></s:label><s:textfield name="nombreCompleto" value="%{#usuario.nombreCompleto}" label="Nombre y apellidos"></s:textfield><br/>
                    <s:label key="usuario.dni"></s:label><s:textfield name="dni" value="%{#usuario.dni}" label="DNI" readonly="true"></s:textfield><br/>
                    <s:label for="rol" key="usuario.tipoDeUsuario"></s:label><s:textfield name="rol" value="%{#usuario.rol}" label="Tipo de cuenta" readonly="true"></s:textfield><br/>
                    <s:label key="usuario.usuario"></s:label><s:textfield name="usuario" value="%{#usuario.usuario}" label="Nombre de usuario"></s:textfield><br/>
                    <s:label key="usuario.email"></s:label><s:textfield name="email" value="%{#usuario.email}" label="Correo electronico"></s:textfield><br/>
                    <s:label key="usuario.sexo"></s:label><s:radio label="Sexo" name="sexo" value="%{#usuario.sexo}" list="listaDeSexo"></s:radio><br/>
                    <s:if test="#usuario.rol == 'Jugador' || #usuario.rol == 'Administrador'">
                        <s:label for="categoria" key="usuario.categoria"></s:label><s:select label="Categoria" value="%{#usuario.categoria}" id="categoria" name="categoria" list="listaDeCategoria"></s:select><br/>
                        <s:label for="registroAction_ladoDeJuego" key="usuario.ladoDeJuego"></s:label><s:radio label="Lado de juego" value="%{#usuario.ladoDeJuego}" name="ladoDeJuego"  list="listaDeLadoDeJuego"></s:radio><br/>
                    </s:if>
                    <s:label key="usuario.clave"></s:label><s:password name="clave" label="Contraseña"></s:password><br/>
                    <s:label key="usuario.clave.confirmar"></s:label><s:password name="claveConfirmar" label="Confirmar Contraseña"></s:password><br/>
                    <s:hidden name="formulario" value="si"></s:hidden>
                    <s:submit key="modificarCredenciales"></s:submit>
                </s:form>
            </div>
        </div>
        <%--<s:include value="../footer.jsp"></s:include>--%>
    </body>
</html>
