package servlet;

import manager.AuthorManager;
import manager.BookManager;
import model.Author;
import model.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/books/add")
public class AddBookServlet extends HttpServlet {

    private final AuthorManager authorManager = new AuthorManager();
    private final BookManager bookManager = new BookManager();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Author> authorList = authorManager.getAllAuthors();
        request.setAttribute("authors", authorList);
        request.getRequestDispatcher("/WEB-INF/addBook.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        int authorId = Integer.parseInt(request.getParameter("authorId"));

        Book book = Book.builder()
                .title(title)
                .description(description)
                .price(price)
                .author(authorManager.getAuthorById(authorId))
                .build();
        bookManager.add(book);
        response.sendRedirect("/books");
    }
}
