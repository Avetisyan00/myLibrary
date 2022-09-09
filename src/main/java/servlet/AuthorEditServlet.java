package servlet;

import manager.AuthorManager;
import model.Author;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/author/edit")
public class AuthorEditServlet extends HttpServlet {

    private final AuthorManager authorManager = new AuthorManager();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int authorId = Integer.parseInt(request.getParameter("authorId"));
        Author author = authorManager.getAuthorById(authorId);
        request.setAttribute("author", author);
        request.getRequestDispatcher("/WEB-INF/editAuthor.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int authorId = Integer.parseInt(request.getParameter("authorId"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Author author = Author.builder()
                .id(authorId)
                .name(name)
                .surname(surname)
                .email(email)
                .password(password)
                .build();
        authorManager.edit(author);
        response.sendRedirect("/authors");
    }
}
