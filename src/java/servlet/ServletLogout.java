package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletLogout", urlPatterns = {"/ServletLogout"})
public class ServletLogout extends HttpServlet {
    
    final String SAIR = "logout";
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter redirecionamento = resp.getWriter();
        
        String logout = req.getParameter("logout");
        String param = req.getParameter("param");
        
        if(param != null && param.equals("logout")){
        
        //if (logout.equals(SAIR)) {
            
            req.getSession().invalidate();
          //  resp.sendRedirect("../DIRETOR/sessao.jsp");
            
            redirecionamento.println("<script type=\"text/javascript\">");
            redirecionamento.println("alert('Usuario realizou logout com sucesso!');");
            redirecionamento.println("location='login.jsp';");
            redirecionamento.println("</script>");
        
        }
    }
}