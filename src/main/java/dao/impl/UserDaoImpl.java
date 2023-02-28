package dao.impl;

import dao.UserDao;
import domain.User;
import connection.ConnectionUtils;
import domain.UserRole;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private final static String READ_ALL = "select * from users";
    private final static String CREATE = "insert into users(`email`,`firstName`, `lastName`,`password`, `role`) values (?,?,?,?,?)";
    private final static String READ_BY_ID = "select * from users where id =?";
    private final static String READ_BY_EMAIL = "select * from users where email=?";
    private final static String UPDATE_BY_ID = "update users set email=?, firstName = ?, lastName = ?, role=?  where id = ?";
    private final static String DELETE_BY_ID = "delete from users where id=?";

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);
    private String email;

    public UserDaoImpl() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        connection = ConnectionUtils.openConnection();
    }

    @Override
    public User create(User user) {
        try {
            preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getUserEmail());
            preparedStatement.setString(2, user.getUserFirstName());
            preparedStatement.setString(3, user.getUserLastName());
            preparedStatement.setString(4, user.getUserPassword());
            preparedStatement.setString(5, user.getUserRole());
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();
            user.setUserId(rs.getInt(1));
        } catch (SQLException e) {
            LOGGER.error(e);
        }

        return user;
    }

    @Override
    public User read(Integer id) {
        User user = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();

            Integer userId = result.getInt("id");
            String email = result.getString("email");
            String firstName = result.getString("firstName");
            String lastName = result.getString("lastName");
            String password = result.getString("password");
            String role = result.getString("role");
            user = new User(userId, email, firstName, lastName, password,  UserRole.USER.toString());

        } catch (SQLException e) {
            LOGGER.error(e);
        }

        return user;
    }

    @Override
    public User update(User user) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setString(1, user.getUserEmail());
            preparedStatement.setString(2, user.getUserFirstName());
            preparedStatement.setString(3, user.getUserLastName());
            preparedStatement.setString(4, user.getUserRole());
            preparedStatement.setInt(5, user.getUserId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }

        return user;

    }

    @Override
    public void delete(Integer id) {
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public List<User> readAll() {
        List<User> userRecords = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                Integer userId = result.getInt("id");
                String email = result.getString("email");
                String firstName = result.getString("firstName");
                String lastName = result.getString("lastName");
                String password = result.getString("password");
                String role = result.getString("role");
                userRecords.add(new User(userId, email, firstName, lastName, password, UserRole.USER.toString()));
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }

        return userRecords;
    }

    @Override
    public List<User> readAllId(Integer id) {
        return null;
    }

    public User getByUserEmail(String email) {
        this.email = email;
        User user = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_EMAIL);
            preparedStatement.setString(1, email);
            ResultSet result = preparedStatement.executeQuery();
            result.next();

            int userId = result.getInt("id");
            String firstName = result.getString("firstName");
            String lastName = result.getString("lastName");
            String role = result.getString("role");
            String password = result.getString("password");

            user = new User(userId, email, firstName, lastName, password, UserRole.valueOf(role.toUpperCase()).toString());
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return user;
    }

    @Override
    public User getByUserPassword(String userEmail) throws SQLException {
        return null;
    }
}
