package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import org.apache.log4j.Logger;
import service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final static Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
    private static UserService userServiceImpl;
    private UserDao userDao;

    public UserServiceImpl() {
        try {
            userDao = new UserDaoImpl();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            LOGGER.error(e);
        }
    }

    public static UserService getUserServiceImpl() {;
        if (userServiceImpl == null) {
            userServiceImpl = new UserServiceImpl();
        }

        return userServiceImpl;
    }

    @Override
    public User create(User t) {
        return userDao.create(t);
    }

    @Override
    public User read(Integer id) {
        return userDao.read(id);
    }

    @Override
    public User update(User t) {
        return userDao.update(t);
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }

    @Override
    public List<User> readAll() {
        return userDao.readAll();
    }

    @Override
    public List<User> readAllId(Integer id) {
        return null;
    }

    @Override
    public User getByUserEmail(String userEmail) throws SQLException {
        return userDao.getByUserEmail(userEmail);
    }

    @Override
    public User getbyUserPassword(String password)  {
        return null;
    }
}