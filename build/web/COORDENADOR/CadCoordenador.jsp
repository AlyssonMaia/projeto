<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Coordenador</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="../ServletCoordenador">
            <input type="text" name="nome" placeholder="Nome"/><br>
            <input type="text" name="cpf" placeholder="CPF"/><br>
            <input type="text" name="endereco" placeholder="Endereço"/><br>
            <input type="text" name="telefone" placeholder="Telefone"/><br>
            <input type="text" name="email" placeholder="E-mail"/><br>
            <input type="hidden" name="tipo" value="COORDENADOR"/>
            <input type="hidden" name="ativo" value="true"/>
            <input type="hidden" value="cad" name="acao"/>
            <input type="submit" value="Cadastrar"/>
        </form>
    </body>
</html>