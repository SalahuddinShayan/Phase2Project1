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
import org.hibernate.query.Query;

import entity.Students;
import entity.Subjects;
import entity.Teachers;
import util.HibernateUtil;

/**
 * Servlet implementation class Class_Report
 */
@WebServlet("/Class_Report")
public class Class_Report extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Class_Report() {
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
		String id = request.getParameter("Id");

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();
		
Query qr = session.createQuery(" from Students where classId = ?1");
qr.setParameter(1, Integer.parseInt(id));
List<Students> students = qr.list();
		
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
		
		
		Query qr2 = session.createQuery("select s from Subjects s, Assign a where s.sId = a.sId and a.classId = ?1", Subjects.class);
		qr2.setParameter(1, Integer.parseInt(id));
		 List<Subjects> subjects= qr2.list();
		out.println("<h1> Students List :-");
		out.println("<table>");
		
		out.println("<tr>");
		out.println("<th> Subject Id </th>");
		out.println("<th> Subject Name </th>");
		out.println("</tr>");
		
		for(Subjects subject : subjects ) {
			out.println("<tr>");
			out.println("<td>"+subject.getsId()+"</td>");
			out.println("<td>"+subject.getsName()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.append("</body></html>");
		
Query qr3 = session.createQuery(" Select t from Teachers t, Assign a where t.tId = a.tId and a.classId = ?1", Teachers.class);
qr3.setParameter(1, Integer.parseInt(id));
List<Teachers> teachers = qr3.list();
		
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
