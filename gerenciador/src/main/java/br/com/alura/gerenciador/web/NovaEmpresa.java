package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns="/novaempresa")
public class NovaEmpresa extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String nome =req.getParameter("nome");
		EmpresaDAO edao=new EmpresaDAO();
		edao.adiciona(new Empresa(nome));
		PrintWriter w=resp.getWriter();
		w.println("<html><body>Empresa adicionanda com sucesso:"+nome+"</body></html>");
		
		
	}
}
