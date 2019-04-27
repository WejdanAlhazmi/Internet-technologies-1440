package uqu.lab9.servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uqu.jeelab.dao.BooksDAO;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RegistrationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/form.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BooksDAO booksDAO = new BooksDAO();
		ArrayList result = null;
		try {
			result = booksDAO.getBooks();
			request.setAttribute("books", result);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/list.jsp").forward(request, response);
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
