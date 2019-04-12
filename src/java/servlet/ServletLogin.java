package servlet;

import dao.LoginDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;

@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter redirecionamento = resp.getWriter();
        
        String matricula = req.getParameter("matricula");
        String senha = req.getParameter("senha");

        Pessoa user = LoginDAO.userAuthentication(matricula, senha);
        
        if (user != null) {

            //redirecionamento.println("Login com Sucesso!");
            //resp.sendRedirect(user.getTipo() + "/index.jsp");
            //req.setAttribute("login", user);
            req.getSession().setAttribute("usuario", user);
            //req.getRequestDispatcher(user.getTipo() + "/index.jsp").forward(req, resp);
            //req.getRequestDispatcher(user.getTipo() + "/index.jsp").forward(req, resp);
            req.getRequestDispatcher("sessao.jsp").forward(req, resp);
        } else {
            
            redirecionamento.println("<script type=\"text/javascript\">");
            redirecionamento.println("alert('Matricula ou Senha inválidos!');");
            redirecionamento.println("location='login.jsp';");
            redirecionamento.println("</script>");
            
        }

    }

}