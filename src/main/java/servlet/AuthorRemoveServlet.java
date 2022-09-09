package servlet;

import manager.AuthorManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/author/remove")
public class AuthorRemoveServlet extends HttpServlet {
    private final AuthorManager authorManager = new AuthorManager();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int authorId = Integer.parseInt(request.getParameter("authorId"));
        authorManager.removeAuthorById(authorId);
        response.sendRedirect("/authors");
    }
}
