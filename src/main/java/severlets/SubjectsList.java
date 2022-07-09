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

import entity.Subjects;
import entity.Teachers;
import util.HibernateUtil;

/**
 * Servlet implementation class SubjectsList
 */
@WebServlet("/SubjectsList")
public class SubjectsList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectsList() {
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
		
		List<Subjects> subjects = session.createQuery(" from Subjects").list();
		
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
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
