<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Aluno</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="../ServletAluno">
            <input type="text" name="nome" placeholder="Nome"/><br>
            <input type="text" name="cpf" placeholder="CPF"/><br>
            <input type="text" name="endereco" placeholder="Endereço"/><br>
            <input type="text" name="email" placeholder="E-mail"/><br>
            <input type="text" name="telefone" placeholder="Telefone"/><br>
            <input type="hidden" name="tipo" value="ALUNO"/>
            <input type="hidden" name="ativo" value="true"/>
            <input type="hidden" name="acao" value="cad"/>
            <input type="submit" value="Cadastrar"/>
        </form>
    </body>
</html>