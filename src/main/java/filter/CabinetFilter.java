package filter;

import domain.UserRole;
import shared.FilterService;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Arrays;


@WebFilter("/cabinet.jsp")
public class CabinetFilter implements Filter {

    private FilterService filterService = FilterService.getFilterService();


    public void destroy() {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        filterService.doFilterValidation(request, response, chain, Arrays.asList(UserRole.USER, UserRole.ADMIN));
    }

    public void init(FilterConfig fConfig) throws ServletException {}
}