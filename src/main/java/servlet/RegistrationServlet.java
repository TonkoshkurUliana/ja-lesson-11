package servlet;

import domain.User;
import domain.UserRole;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import service.UserService;
import service.impl.UserServiceImpl;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "registration", value = "/registration")

public class RegistrationServlet extends HttpServlet {
    private final UserService userService = UserServiceImpl.getUserServiceImpl();

    public RegistrationServlet() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        userService.create(new User(email, firstName, lastName, password, UserRole.USER.toString()));
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");
        response.getWriter().close();
    }

}
