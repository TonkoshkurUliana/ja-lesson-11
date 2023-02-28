package servlet;

import com.google.gson.Gson;
import domain.Magazine;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.MagazineService;
import service.impl.MagazineServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "products", value = "/products")
public class ProductServlet extends HttpServlet {
    private MagazineService productService = MagazineServiceImpl.getMagazineServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

            List<Magazine> products = productService.readAll();
            String json = new Gson().toJson(products);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
            response.getWriter().close();
        }
    }

