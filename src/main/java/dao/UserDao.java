package dao;


import domain.User;
import shared.AbstractCRUD;

import java.sql.SQLException;

// dao for User
public interface UserDao extends AbstractCRUD<User> {
    User getByUserEmail(String userEmail) throws SQLException;
    User getByUserPassword(String userEmail) throws SQLException;
    }

