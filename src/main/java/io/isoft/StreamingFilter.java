package io.isoft;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

public class StreamingFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, new HttpServletResponseWrapper((HttpServletResponse) response) {
             public void setHeader(String name, String value) {
                  if (!("Connection".equalsIgnoreCase(name) && "Close".equalsIgnoreCase(value))) {
                       super.setHeader(name, value);
                  }
             }
        });
   }
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
