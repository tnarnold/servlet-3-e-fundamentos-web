package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns="/busca")
public class BuscaEmpresa extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter w=resp.getWriter();
		w.println("<html>");
		w.println("<body>");
		w.println("Resultado da Busca:");
		w.println("<ul>");
		String filtro=req.getParameter("filtro");
		EmpresaDAO eDao=new EmpresaDAO();
		Collection<Empresa> empresas=eDao.buscaPorSimilaridade(filtro);
		for (Empresa empresa : empresas) {
			w.println("<li>"+empresa.getId()+": "+empresa.getNome()+"</li>");
		}
		w.println("</ul>");
		w.println("</body>");
		w.println("</html>");
		
	}
}
