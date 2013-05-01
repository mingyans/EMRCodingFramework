package edu.cmu.lti.uima.server;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.cmu.lti.uima.rules.hieratical.test;

public class EMRCoding extends HttpServlet {

	private static final long serialVersionUID = -3522462295690035558L;
	private static StandardOutput stdOut = StandardOutput.getInstance();

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RealPath.getInstance().set(
				request.getSession().getServletContext().getRealPath("") + "/");
		stdOut.setNull();
		String emr = request.getParameter("EMRIN");

		stdOut.setString("\nEMR " + emr);
		// if (!input.equals(""))
		// new test(input);
		// else
		// stdOut.setString("No SNOWMED Input!!");
		int times = 0;
		while (true) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			times++;
			if (times > 3)
				break;
		}
		request.setAttribute("REPORT", emr);
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context
				.getRequestDispatcher("/JD.jsp");
		dispatcher.forward(request, response);
	}
}
