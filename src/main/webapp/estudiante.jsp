<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 17/04/2023
  Time: 10:26 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Estudiante</title>
</head>
<body>
<h1>REGISTRAR ESTUDIANTE</h1>
<form action="registroE" method="post">
    <label>registrarse</label>
    <div>
        <input type="text" name="usarname">
        <input type="password" name="password">
        <input type="submit" value="registrar">
    </div>



</form>
<form action="registroE" method="get">
    <label>iniciar seccion</label>

    <div>
        <input type="text" name="usarname2">
        <input type="password" name="password2">
        <input type="submit" value="inisiar seccion">
    </div>


</form>

</body>
</html>
