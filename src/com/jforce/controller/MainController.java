package com.jforce.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jforce.dto.Voter;
import com.jforce.service.IVoterService;
import com.jforce.servicefactory.VoterServiceFactory;

@WebServlet("/controller/*")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		IVoterService voterService = VoterServiceFactory.getVoterServiceBean();

		if (request.getRequestURI().endsWith("validatevote")) {

			HttpSession session = request.getSession();
			int optionId = Integer.parseInt(request.getParameter("c1"));
			String username = (String) session.getAttribute("user");
			System.out.println(optionId);
			System.out.println(username);
			PrintWriter out = response.getWriter();
			boolean msg = voterService.validateVote(username);
			RequestDispatcher rd = null;
			if (msg) {
				rd = request.getRequestDispatcher("../alreadyVoted.jsp");
				rd.forward(request, response);

				System.out.println("Already Voted");
			} else {

				voterService.updateVote(username);

				rd = request.getRequestDispatcher("../success.jsp");
				rd.forward(request, response);
			}

			out.close();

		}

		// registration
		if (request.getRequestURI().endsWith("register")) {

			System.out.println("register started");

			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			Integer phone = Integer.parseInt(request.getParameter("phone"));
			String status = voterService.registerVoter(username, password, email, phone);

			RequestDispatcher rd = null;

			PrintWriter out = response.getWriter();
			if ("success".equalsIgnoreCase(status)) {
				System.out.println("forwarded to login.jsp  succes added");

//				out.println("<h1>SuccesFully Registered Please go back to login page</h1>");
                 response.sendRedirect("../login.jsp");
//				out.println("<h1 style='color:green text-align:center;'> Register Successfull</h1> ");
			} else if ("failed".equalsIgnoreCase(status)) {
				String output = "faield registration";
				handler(request, response, output);

//				out.println("<h1 style='color:return text-align:center;'> Register Failed...try again</h1> ");
			}

//			out.close();
		}

		// Authentication
		if (request.getRequestURI().endsWith("login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Voter voter = new Voter();
			Boolean flag = voterService.validateUser(username, password);

			RequestDispatcher rd = null;
			PrintWriter out = response.getWriter();

			if (flag) {
				request.setAttribute("user", username);
				HttpSession session = request.getSession();
				session.setAttribute("user", username);
				rd = request.getRequestDispatcher("../voting.jsp");
				rd.forward(request, response);

//				out.println("<h1 style='color:green text-align:center;'> Register Successfull</h1> ");
			} else {

				String output = "Invalid Credential";
				handler(request, response, output);

//				out.println("<h1 style='color:return text-align:center;'> Login Failed...try again</h1> ");
			}

//			out.close();
		}

		if (request.getRequestURI().endsWith("logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("../login.jsp");
		}
	}

	public void handler(HttpServletRequest request, HttpServletResponse response, String output)
			throws ServletException, IOException {

		request.setAttribute("output", output);
		RequestDispatcher dispatcher = request.getRequestDispatcher("../invalid.jsp");
		dispatcher.forward(request, response);

	}

}
