package servlet;

import manager.AuthorManager;
import manager.BookManager;
import model.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/books/edit")
public class EditBookServlet extends HttpServlet {
    AuthorManager authorManager = new AuthorManager();
    BookManager bookManager = new BookManager();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        Book book = bookManager.getBookById(bookId);
        request.setAttribute("authors", authorManager.getAllAuthors());
        request.setAttribute("book", book);
        request.getRequestDispatcher("/WEB-INF/editBook.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        int authorId = Integer.parseInt(request.getParameter("authorId"));

        Book book = Book.builder()
                .id(bookId)
                .title(title)
                .description(description)
                .price(price)
                .author(authorManager.getAuthorById(authorId))
                .build();
        bookManager.edit(book);
        response.sendRedirect("/books");
    }
}
