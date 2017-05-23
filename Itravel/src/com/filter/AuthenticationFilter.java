package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.RegisterBean;
import com.dao.PostDao;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {
	private ServletContext context;


    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		RegisterBean user = new RegisterBean();
		
		String uri = req.getRequestURI();
		this.context.log("Requested Resource::" + uri);

		HttpSession session = req.getSession(false);
		if(session!=null){
			user = (RegisterBean) session.getAttribute("user");
		}
		System.out.println("user in filter "+user);
		if (user==null && !(uri.contains("JS") ||uri.contains("css") ||uri.endsWith("SignIn.jsp")||uri.endsWith("SignInServlet")||uri.endsWith("Register.jsp")||uri.endsWith("RegisterServlet")||uri.endsWith("CheckUserServlet"))) {
			this.context.log("Unauthorized access request");
			System.out.println("Unauthorized access request");
			res.sendRedirect("SignIn.jsp");
		} else {
			// pass the request along the filter chain
			PostDao PostDao = new PostDao();
			request.getServletContext().setAttribute("listreq", PostDao.listAllPost());
			chain.doFilter(request, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");
	}

}
