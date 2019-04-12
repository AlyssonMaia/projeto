<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Diretor</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/ServletDiretor">
            <input type="text" name="nome" placeholder="Nome"/><br>
            <input type="text" name="cpf" placeholder="CPF"/><br>
            <input type="text" name="endereco" placeholder="Endereço"/><br>
            <input type="text" name="email" placeholder="E-mail"/><br>
            <input type="text" name="telefone" placeholder="Telefone"/><br>
            <input type="text" name="titulacao" placeholder="Titulação"/><br>
            <input type="hidden" name="tipo" value="DIRETOR"/>
            <input type="hidden" name="ativo" value="true"/>
            <input type="hidden" value="cad" name="acao"/>
            <input type="submit" value="Cadastrar"/>
        </form>

    </body>
</html>
