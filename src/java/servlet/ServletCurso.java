package servlet;

import dao.CursoDAO;
import graduacao.Curso;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletCurso", urlPatterns = {"/ServletCurso"})
public class ServletCurso extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Curso curso = new Curso();

        curso.setNome(req.getParameter("nome"));
        curso.setArea("area");

        curso.setAtivo(true);

        CursoDAO.Create(curso);

        PrintWriter out = resp.getWriter();
        out.println(curso.getNome() + " cadastrado com Sucesso!");

    }

}
