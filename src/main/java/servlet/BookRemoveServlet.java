package servlet;

import manager.BookManager;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/books/remove")
public class BookRemoveServlet extends HttpServlet {

    private final BookManager bookManager = new BookManager();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        bookManager.removeBookById(bookId);
        response.sendRedirect("/books");
    }


}
