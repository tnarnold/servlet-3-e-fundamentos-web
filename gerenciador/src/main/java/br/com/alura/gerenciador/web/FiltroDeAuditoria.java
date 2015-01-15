package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter{
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain fc) throws IOException, ServletException {
		HttpServletRequest hr=(HttpServletRequest) req;
		System.out.println("Usuario acessando URI "+hr.getRequestURI());
		

		System.out.println("Usuario "+getUsuario(hr)+" acessadno o sistema");
		fc.doFilter(req, resp);
	}

	private String getUsuario(HttpServletRequest hr) throws IOException,
			ServletException {
		String usuario="<deslogado>";
		Cookie[] cookies=hr.getCookies();
		if(cookies==null) return usuario;
		for(Cookie cookie: cookies){
			if(cookie.getName().equals("usuario.logado")){
				usuario=cookie.getValue();
			}
		}
		
		return usuario;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
