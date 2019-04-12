<%@page import="model.Login"%>
<%@page import="java.util.List"%>
<%@page import="model.Pessoa"%>
<%@page import="dao.PessoaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Diretor</title>
        <script type="text/javascript">
            function excluir(id,nome){
               if(window.confirm("Deseja realmente excluir o usuário " +nome+" ?")) {
                    location.href = "../ServletDiretor?id="+id+"&acao=del";
                }
            }
        </script>
    </head>
    <body>
        <%
           Pessoa user = (Pessoa)request.getAttribute("login");
           List<Pessoa> pessoas = PessoaDAO.Read("DIRETOR");
           if (pessoas != null) {
       %>
       <a href="CadDiretor.jsp"><b>Cadastro De Diretores</b><br/><br/></a>
       <a href="../COORDENADOR/index.jsp" >Gerenciar Coordenadores</a><br/><br/>
       <b>Lista de Diretores</b><br/><br/>
       <table border="1">
           <tr>
               <td>Nome</td>
               <td>Cargo</td>
               <td colspan="2" style="text-align: center;">Ação</td>
           </tr>
           <%for(Pessoa pessoa : pessoas){%>
           <tr>
               <td><%=pessoa.getNome()%></td>
               <td><%=pessoa.getTipo()%></td>
               <td><a  href="update.jsp?id=<%=pessoa.getId()%>,<%=pessoa.getTipo()%>"><img src="../IMAGENS/edit.png"/></a></td>
               <td><a  href="javascript://" onclick="excluir(<%=pessoa.getId()%>,'<%=pessoa.getNome()%>')"><img src="../IMAGENS/lixo.png"/></a></td>
           </tr>
           <%}}%>
       </table>
    </body>
</html>