package servlet;


import domain.Bucket;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import service.BucketService;
import service.impl.BucketServiceImpl;


import java.io.IOException;
import java.util.Date;

@WebServlet(name = "bucketController", value = "/bucketController")

public class BucketController extends HttpServlet {

    private BucketService bucketService = BucketServiceImpl.getBucketServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String productId = request.getParameter("magazineId");

        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        Bucket bucket = new Bucket(userId, Integer.parseInt(productId), new Date());
        bucketService.create(bucket);

        response.setContentType("text/plane");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bucketId = req.getParameter("bucketId");
        bucketService.delete(Integer.parseInt(bucketId));

        resp.setContentType("text/plane");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("Success");
    }
}


