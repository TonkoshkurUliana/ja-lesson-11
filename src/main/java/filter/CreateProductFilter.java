package filter;

import domain.UserRole;
import shared.FilterService;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Arrays;


@WebFilter("/createProduct.jsp")
public class CreateProductFilter implements Filter {
    FilterService filterService = FilterService.getFilterService();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        filterService.doFilterValidation(request, response, chain, Arrays.asList( UserRole.ADMIN));
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
