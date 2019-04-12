<%@page import="model.Login"%>
<%@page import="dao.LoginDAO"%>
<%@page import="dao.PessoaDAO"%>
<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Diretor</title>
    </head>
    <body>
        <%
            String id = request.getParameter("id");
            id = id.replace(" ", "");
            String[] para = id.split(",|\\s");

            Pessoa update = new Pessoa();
            update.setId(Integer.parseInt(para[0]));
            update.setTipo(para[1]);

            Pessoa upd = PessoaDAO.Read(update);
            Login updl = LoginDAO.Read(upd.getId());
        %>
        <form action="../ServletDiretor">
            <input type="hidden" name="id" value="<%=upd.getId()%>"/>
            <input type="text" name="nome" value="<%=upd.getNome()%>"/><br>
            <input type="text" name="cpf" value="<%=upd.getCpf()%>"/><br>
            <input type="text" name="endereco" value="<%=upd.getEndereco()%>"/><br>
            <input type="text" name="email" value="<%=upd.getEmail()%>"/><br>
            <input type="text" name="telefone" value="<%=upd.getTelefone()%>"/><br>
            <input type="text" name="titulacao" value="<%=upd.getTitulacao()%>"/><br>
            <input type="hidden" name="tipo" value="<%=upd.getTipo()%>"/>
            <input type="hidden" name="ativo" value="<%=upd.isAtivo()%>"/>
            <input type="text" name="matricula" value="<%=updl.getMatricula()%>"/><br>
            <input type="password" name="senha" value="<%=updl.getSenha()%>"/><br>
            <input type="hidden" name="acao" value="upd"/>
            <input type="submit"value="Atualização"/>
        </form>
    </body>
</html>