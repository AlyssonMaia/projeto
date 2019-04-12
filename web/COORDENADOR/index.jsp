<%@page import="java.util.List"%>
<%@page import="dao.PessoaDAO"%>
<%@page import="model.Pessoa"%>
<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Coordenador</title>
        <script type="text/javascript">
            function excluir(id, nome) {
                if (window.confirm("Deseja realmente excluir o usuário " + nome + " ?")) {
                    location.href = "../ServletCoordenador?id=" + id + "&acao=del";
                }
            }
        </script>
    </head>
    <body>
        <h1>Coordenador</h1>
        <%
            List<Pessoa> pessoas = PessoaDAO.Read("COORDENADOR");
            if (pessoas != null) {
        %>
        <a href="CadCoordenador.jsp"><b>Cadastro De Coordenadores</b><br/><br/></a>
        <a href="../PROFESSOR/index.jsp" >Gerenciar Professores</a><br/><br/>
        <a href="../ALUNO/index.jsp" >Gerenciar Alunos</a><br/><br/>
        <b>Lista de Coordenadores</b><br/><br/>
        <table border="1">
            <tr>
                <td>Nome</td>
                <td>Cargo</td>
                <td colspan="2" style="text-align: center;">Ação</td>
            </tr>
            <%for (Pessoa pessoa : pessoas) {%>
            <tr>
                <td><%=pessoa.getNome()%></td>
                <td><%=pessoa.getTipo()%></td>
                <td><a  href="update.jsp?id=<%=pessoa.getId()%>,<%=pessoa.getTipo()%>"><img src="../IMAGENS/edit.png"/></a></td>
                <td><a  href="javascript://" onclick="excluir(<%=pessoa.getId()%>, '<%=pessoa.getNome()%>')"><img src="../IMAGENS/lixo.png"/></a></td>	    
            </tr>
            <%}
               }%>
        </table>
    </body>
</html>