package servlet;

import manager.AuthorManager;
import model.Author;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/authors/add")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,    // 1MB
        maxFileSize = 1024 * 1024 * 10,     // 10MB
        maxRequestSize = 1024 * 1024 * 100  // 100MB
)
public class AddAuthorServlet extends HttpServlet {

    private final AuthorManager authorManager = new AuthorManager();
    private static final String IMAGE_PATH = "C:\\Users\\Edgar\\IdeaProjects\\myLibrary\\projectImages";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/addAuthor.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Part profilePicPart = request.getPart("profilePic");

        long nanoTime = System.nanoTime();
        String fileName = nanoTime + "_" + profilePicPart.getSubmittedFileName();

        profilePicPart.write(IMAGE_PATH + fileName);

        Author author = Author.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .password(password)
                .profilePic(fileName)
                .build();
        authorManager.add(author);
        response.sendRedirect("/authors");
    }
}
