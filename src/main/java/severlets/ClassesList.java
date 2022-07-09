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

import entity.Classes;
import entity.Students;
import util.HibernateUtil;

/**
 * Servlet implementation class ClassesList
 */
@WebServlet("/ClassesList")
public class ClassesList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassesList() {
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
		
		List<Classes> classes = session.createQuery(" from Classes").list();
		
		out.println("<h1> Students List :-");
		out.println("<table>");
		
		out.println("<tr>");
		out.println("<th> Class Id </th>");
		out.println("<th> Class Name </th>");
		out.println("<th> Start Date </th>");
		out.println("<th> Expected Duration in Months </th>");
		out.println("</tr>");
		
		for(Classes Class : classes ) {
			out.println("<tr>");
			out.println("<td>"+Class.getClassId()+"</td>");
			out.println("<td>"+Class.getClassName()+"</td>");
			out.println("<td>"+Class.getStartDate()+"</td>");
			out.println("<td>"+Class.getExpectedDuration()+"</td>");
			

			out.println("</tr>");
		}
		out.println("</table><br>");
		out.println("<nav><a href='mainMenu.html'>Click Here to go to Main Menu.</a></nav>");
		out.append("</body></html>");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
