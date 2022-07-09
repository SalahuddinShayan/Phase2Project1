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

import entity.Teachers;
import util.HibernateUtil;

/**
 * Servlet implementation class TeachersList
 */
@WebServlet("/TeachersList")
public class TeachersList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeachersList() {
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
		
		List<Teachers> teachers = session.createQuery(" from Teachers").list();
		
		out.println("<h1> Students List :-");
		out.println("<table>");
		
		out.println("<tr>");
		out.println("<th> Teacher Id </th>");
		out.println("<th> Teacher Name </th>");
		out.println("<th> Join Date </th>");
		out.println("</tr>");
		
		for(Teachers teacher : teachers ) {
			out.println("<tr>");
			out.println("<td>"+teacher.gettId()+"</td>");
			out.println("<td>"+teacher.gettName()+"</td>");
			out.println("<td>"+teacher.getDateOfJoining()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
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
