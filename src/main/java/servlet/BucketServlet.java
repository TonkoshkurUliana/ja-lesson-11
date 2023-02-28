package servlet;

import com.google.gson.Gson;
import domain.Bucket;
import domain.Magazine;
import dto.BucketDto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.BucketService;
import service.MagazineService;
import service.impl.BucketServiceImpl;
import service.impl.MagazineServiceImpl;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(name = "bucket", value = "/bucket")

public class BucketServlet extends HttpServlet {

    private	BucketService bucketService = BucketServiceImpl.getBucketServiceImpl();
    private MagazineService productService = MagazineServiceImpl.getMagazineServiceImpl();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer idUser = (Integer) session.getAttribute("userId");

        List<Bucket> buckets = bucketService.readAllId(idUser);
        Map<Integer, Magazine> idToProduct = productService.readAllMap();
        List<BucketDto> listOfBucketDtos = map(buckets, idToProduct);

        String json = new Gson().toJson(listOfBucketDtos);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        response.getWriter().close();
    }


    public List<BucketDto> map(List<Bucket> buckets, Map<Integer, Magazine> idToProduct){

        return	buckets.stream().map(bucket->{
            BucketDto bucketDto = new BucketDto();
            bucketDto.bucketId = bucket.getId();
            bucketDto.purchaseDate = bucket.getPurchaseDate();

            Magazine product = idToProduct.get(bucket.getProductId());
            bucketDto.name = product.getName();
            bucketDto.information = product.getInformation();
            bucketDto.price = product.getPrice();

            return bucketDto;
        }).collect(Collectors.toList());

    }
}