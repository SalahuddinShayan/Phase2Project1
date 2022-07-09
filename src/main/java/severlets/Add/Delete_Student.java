package severlets.Add;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.PersistenceException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Students;
import util.HibernateUtil;

/**
 * Servlet implementation class Delete_Student
 */
@WebServlet("/Delete_Student")
public class Delete_Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete_Student() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("deleteStudent.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("Id");
		
		try {
		Students st = new Students();
		st.setId(Integer.parseInt(id));
				
		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		session.delete(st);
		tx.commit();

		// 4. Close session
		session.close();

		PrintWriter pw = response.getWriter();
		pw.append("<html><body>");
		pw.append("Student deleted successfully!");
		pw.append("<nav> <a href= 'mainMenu.html'>Click here to go to Main Menu</a><br>");
		pw.append("<a href= 'deleteStudent.html'>Click here to delete another student.</a></nav>");
		pw.append("</body></html>");
	}
	catch(PersistenceException  | NumberFormatException e) {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<a>ERROR! Please Make Sure that Student ID you have given is correct.</a>");
		out.println("<nav> <a href= 'mainMenu.html'>Click here to go to Main Menu</a><br>");
		out.println("<a href= 'StudentsList'>Click here to view list of Students</a><br>");
		out.println("<a href= 'deleteStudent.html'>Click here to try again.</a></nav>");
		out.println("</body></html>");
	}
	}

}
