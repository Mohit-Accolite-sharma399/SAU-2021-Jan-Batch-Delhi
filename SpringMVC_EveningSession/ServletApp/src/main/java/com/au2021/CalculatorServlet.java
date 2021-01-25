package com.au2021;

import com.au2021.service.CalculatorService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {

	private CalculatorService service = new CalculatorService();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/views/enter.jsp").forward(
				request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String input1 = request.getParameter("input1");
		String input2 = request.getParameter("input2") ;

		boolean isValidInput = service.validateInput(input1, input2);

		if (isValidInput) {
			request.getRequestDispatcher("/WEB-INF/views/Result.jsp").forward(
					request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/views/enter.jsp").forward(
					request, response);
		}
	}

}