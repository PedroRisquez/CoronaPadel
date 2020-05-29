<%@taglib prefix="s" uri="/struts-tags"%>
<header>
    <link href="design/designIndex.css" rel="stylesheet" type="text/css"/>
    <div class="brandingImgWrap"> 
        <s:a action="cargarCompeticionesInscripcion"><img src="/CoronaPadel/logo.jpeg" alt="" width="50"/></s:a>
    </div>
    <ul class="botones">
        <s:if test="#usuario!=null">
            <div >
                <s:a action="irUsuarioAction"><s:if test="#usuario.fotoPerfil==null"><img src="../coach.png" alt="" width="40" style="margin-left: 110px;"/></s:if><s:else><img src="../img/<s:property value="#usuario.fotoPerfil"></s:property>" width="40"/></s:else></s:a>
                   
                            <li> <s:form action="logoutAction">
                    <s:submit key="logout"></s:submit>
                </s:form>
            </li>
             </div>
        </s:if>
        <s:else>
            <s:form action="cargaRegistroAction">
                <li> <s:submit key="registrarse"></s:submit></li>
                </s:form>
            <li> <s:form action="/vistas/login.jsp">
                    <s:submit key="login"></s:submit>
                </s:form></li>
            </s:else>
    </ul>
    <nav  class="botones2">
        <s:if test="#usuario!=null">
            <s:if test="#usuario.rol=='Administrador'">
                <li > <s:form action="irCreaCompeticionAction">
                        <s:submit key="creaCompeticion"></s:submit>
                    </s:form></li>
                <li>  <s:form action="gestionCompeticionAction">
                        <s:submit key="competiciones"></s:submit>
                    </s:form> </li>
                </s:if>
                <s:if test="#usuario.rol=='Arbitro'">
                <li>   <s:form action="gestionPartidoAction">
                        <s:submit key="misPartidos"></s:submit>
                    </s:form></li>

            </s:if>

            <li><s:form action="irAdministraciones">
                    <s:submit key="administraciones.verTodas"></s:submit>
                </s:form></li>

        </s:if>
    </nav>
</header>
