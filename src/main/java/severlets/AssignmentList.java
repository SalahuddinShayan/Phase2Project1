package severlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.Assign;
import util.HibernateUtil;

/**
 * Servlet implementation class AssignmentList
 */
@WebServlet("/AssignmentList")
public class AssignmentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignmentList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.append("<html><body>");

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();
		
		List<Assign> as = session.createQuery(" from Assign").list();
		
		out.println("<h1>Assignment List :-");
		out.println("<table>");
		
		out.println("<tr>");
		out.println("<th> Assign Id </th>");
		out.println("<th> Class Id </th>");
		out.println("<th> Subject Id </th>");
		out.println("<th> Teacher Id </th>");
		out.println("</tr>");
		
		for(Assign assign : as ) {
			out.println("<tr>");
			out.println("<td>"+assign.getaId()+"</td>");
			out.println("<td>"+assign.getClassId()+"</td>");
			out.println("<td>"+assign.getsId()+"</td>");
			out.println("<td>"+assign.gettId()+"</td>");
			

			out.println("</tr>");
			
			out.println("</table><br>");
			out.println("<nav><a href='mainMenu.html'>Click Here to go to Main Menu.</a></nav>");
			out.append("</body></html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
