package manager;

import db.DBConnectionProvider;
import model.Author;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorManager {

    private final Connection connection = DBConnectionProvider.getINSTANCE().getConnection();

    public void add(Author author) {
        String sql = "insert into author(`name`, surname, email, password, profile_pic) values(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, author.getName());
            preparedStatement.setString(2, author.getSurname());
            preparedStatement.setString(3, author.getEmail());
            preparedStatement.setString(4, author.getPassword());
            preparedStatement.setString(5, author.getProfilePic());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                author.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Author> getAllAuthors() {
        String sql = "select * from author";
        List<Author> authors = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                authors.add(getAuthorFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }

    private Author getAuthorFromResultSet(ResultSet resultSet) throws SQLException {

        return Author.builder()
                .name(resultSet.getString("name"))
                .surname(resultSet.getString("surname"))
                .email(resultSet.getString("email"))
                .password(resultSet.getString("password"))
                .profilePic(resultSet.getString("profile_pic"))
                .id(resultSet.getInt("id"))
                .build();
    }

    public Author getAuthorById(int id) {
        String sql = "select * from author where id = " + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                return getAuthorFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void removeAuthorById(int id) {
        String sql = "delete from author where id = " + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void edit(Author author) {
        String sql = "update author set `name` = ?, surname = ?, email = ?, password= ?, profile_pic = ? where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, author.getName());
            preparedStatement.setString(2, author.getSurname());
            preparedStatement.setString(3, author.getEmail());
            preparedStatement.setString(4, author.getPassword());
            preparedStatement.setInt(5, author.getId());
            preparedStatement.setString(6, author.getProfilePic());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
