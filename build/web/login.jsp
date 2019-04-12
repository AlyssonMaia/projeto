<%@page import="dao.PessoaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PWSA Log In</title>
    </head>
    <body>
    <center>
        <form action="ServletLogin" method="post">
            <input type="text" name="matricula" placeholder="Matricula" required/><br><br>
            <input type="password" name="senha" placeholder="Senha" required/><br><br>
            <input type="submit" value="Log In"/>
        </form>
    </center>
</body>
</html>