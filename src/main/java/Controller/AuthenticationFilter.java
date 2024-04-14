package Controller;



/*public class AuthenticationFilter implements Filter {

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        
        if (httpRequest.getSession().getAttribute("user") == null) {
            
            httpResponse.sendRedirect("Home.html?error=Please login to access this page");
        } else {
            // User is authenticated, continue with the request
            chain.doFilter(request, response);
        }
    }

    // Other methods of the Filter interface are not needed in this example
    public void destroy() {}
    public void init(FilterConfig fConfig) throws ServletException {}
    
}*/