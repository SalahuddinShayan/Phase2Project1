package severlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("Login.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("uname");
		String password = request.getParameter("pwd");
		PrintWriter pw = response.getWriter();
		
		String a = "admin";
		String b = "123";
		if(userName.equals(a) && password.equals(b)) {
			
			pw.println("<html><body>");
			pw.println("Login successful!");
			pw.println("<nav> <a href='mainMenu.html'>Click here to go to Main Menu</a></nav>");
			pw.println("</body></html>");
		}
		else {
			pw.println("<a>Wrong Cerdential</a>");
			pw.println("<nav> <a href='index.html'>Click here to try again</a>");
		}
			
			
	}

}
