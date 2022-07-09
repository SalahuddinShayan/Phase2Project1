package severlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.Students;
import util.HibernateUtil;

/**
 * Servlet implementation class StudentsList
 */
@WebServlet("/StudentsList")
public class StudentsList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentsList() {
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

		// 1.Gets sessin factory
		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();
		
		// 2 Gets product from DB
		List<Students> students = session.createQuery(" from Students").list();
		
		out.println("<h1> Students List :-");
		out.println("<table>");
		
		out.println("<tr>");
		out.println("<th> Student Id </th>");
		out.println("<th> Student Name </th>");
		out.println("<th> Email Id </th>");
		out.println("<th> Phone No. </th>");
		out.println("<th> Class Id </th>");
		out.println("<th> DOB </th>");
		out.println("</tr>");
		
		for(Students student : students ) {
			out.println("<tr>");
			out.println("<td>"+student.getId()+"</td>");
			out.println("<td>"+student.getName()+"</td>");
			out.println("<td>"+student.getEmailId()+"</td>");
			out.println("<td>"+student.getPhoneNo()+"</td>");
			out.println("<td>"+student.getClassId()+"</td>");
			out.println("<td>"+student.getDob()+"</td>");

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
