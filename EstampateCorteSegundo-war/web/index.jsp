<%-- 
    Document   : index
    Created on : 23-mar-2018, 0:34:31
    Author     : Nectia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <script type="text/javascript" src="lib/jquery-1.11.2.min.js"></script>
    <link rel=StyleSheet HREF="styles.css" TYPE="text/css" MEDIA=screen>    
</head>
<body>
    <div id="caja">
        <h1>Login</h1>
        <form  action="<%= request.getContextPath()%>/loginServlet" method="post">
            <input type="text" name="usuario" placeholder="Ingrese el usuario" required/>
            <input type="password" name="pass" placeholder="Ingrese la contraseña" required/>
            <input type="submit" name="enviar" value="Ingresar"/>
        </form>
    </div>
</body>
</html>
