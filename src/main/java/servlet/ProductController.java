package servlet;

import domain.Magazine;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.MagazineService;
import service.impl.MagazineServiceImpl;


import java.io.IOException;

@WebServlet(name = "productController", value = "/productController")
public class ProductController extends HttpServlet {
    private final MagazineService magazineService = MagazineServiceImpl.getMagazineServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String productId = req.getParameter("id");
        Magazine product = magazineService.read(Integer.parseInt(productId));

        req.setAttribute("product", product);
        req.getRequestDispatcher("singleProduct.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        String information = request.getParameter("information");
        String price = request.getParameter("price");

        Magazine magazine = new Magazine(name, information, getValidatedPrice(price));
        magazineService.create(magazine);

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");
    }

    private double getValidatedPrice(String price) {
        if(price == null || price.isEmpty()) {
            return 0;
        }
        return Double.parseDouble(price);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}