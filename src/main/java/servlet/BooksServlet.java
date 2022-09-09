package servlet;

import manager.BookManager;
import model.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/books")
public class BooksServlet extends HttpServlet {
    private BookManager bookManager = new BookManager();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> bookList = bookManager.getAllBooks();
        request.setAttribute("bookList", bookList);
        request.getRequestDispatcher("/WEB-INF/books.jsp").forward(request, response);
    }
}
