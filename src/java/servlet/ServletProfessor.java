package servlet;

import dao.LoginDAO;
import dao.PessoaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Login;
import model.Pessoa;

@WebServlet(name = "ServletProfessor", urlPatterns = {"/ServletProfessor"})
public class ServletProfessor extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Pessoa pessoa = new Pessoa();
        Login user = new Login();
        PrintWriter redirecionamento = resp.getWriter();
        String acao = req.getParameter("acao");

        pessoa.setNome(req.getParameter("nome"));
        pessoa.setCpf(req.getParameter("cpf"));
        pessoa.setEndereco(req.getParameter("endereco"));
        pessoa.setEmail(req.getParameter("email"));
        pessoa.setTelefone(req.getParameter("telefone"));
        pessoa.setTipo(req.getParameter("tipo"));
        pessoa.setAtivo(Boolean.parseBoolean(req.getParameter("ativo")));

        switch (acao) {

            case "cad": {

                Calendar matricula = Calendar.getInstance();

                PessoaDAO.Create(pessoa);

                user.setIdPessoa(PessoaDAO.idLog);
                user.setMatricula(matricula.get(Calendar.YEAR) + ""
                        + (matricula.get(Calendar.MONTH) + 1) + "" + user.getIdPessoa());
                user.setSenha("1234");
                user.setAtivo(true);

                LoginDAO.Create(user);

                break;

            }

            case "upd": {

                pessoa.setId(Integer.parseInt(req.getParameter("id")));
                
                user.setMatricula(req.getParameter("matricula"));
                user.setSenha(req.getParameter("senha"));
                
                PessoaDAO.Update(pessoa);
                LoginDAO.Update(user);

                break;

            }

            case "del": {

                PessoaDAO.Delete(Integer.parseInt(req.getParameter("id")));

                break;

            }

        }

        redirecionamento.println("<script type=\"text/javascript\">");
        redirecionamento.println("location='../projeto/PROFESSOR/index.jsp';");
        redirecionamento.println("</script>");

    }

}
