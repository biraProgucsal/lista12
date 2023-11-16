jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inserir Prato</title>
</head>
<body>
    <h1>Inserir Novo Prato</h1>
    <form action="InserirPratoServlet" method="post">
        Nome: <input type="text" name="nome"><br>
        Tipo: <input type="text" name="tipo"><br>
        Ingredientes: <input type="text" name="ingredientes"><br>
        <input type="submit" value="Inserir">
    </form>
</body>
</html>

