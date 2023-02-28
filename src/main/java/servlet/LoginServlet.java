package servlet;

import com.google.gson.Gson;
import domain.User;
import dto.UserLogin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.log4j.Logger;
import service.UserService;
import service.impl.UserServiceImpl;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "login", value = "/login")

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserService userService = UserServiceImpl.getUserServiceImpl();
    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class);


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");


        User user = null;
        try {
            user = userService.getByUserEmail(email);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (user != null && user.getUserPassword().equals(password)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("role", user.getUserRole().toString());

            UserLogin userLogin = new UserLogin();
            userLogin.destinationUrl = "cabinet.jsp";
            userLogin.userEmail = user.getUserEmail();
            String json = new Gson().toJson(userLogin);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
            response.getWriter().close();
        }
    }

}
