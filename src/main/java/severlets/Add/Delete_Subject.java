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

import entity.Subjects;
import util.HibernateUtil;

/**
 * Servlet implementation class Delete_Subject
 */
@WebServlet("/Delete_Subject")
public class Delete_Subject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete_Subject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("deleteSubject.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("Id");
		
		try {
		Subjects sb = new Subjects();
		sb.setsId(Integer.parseInt(id));

		
		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		session.delete(sb);
		tx.commit();

		// 4. Close session
		session.close();

		PrintWriter pw = response.getWriter();
		pw.append("<html><body>");
		pw.append("Subject updated successfully!");
		pw.append("<nav> <a href= 'mainMenu.html'>Click here to go to Main Menu</a><br>");
		pw.append("<a href= 'deleteSubject.html'>Click here to delete another subject.</a></nav>");
		pw.append("</body></html>");
	}
	catch(PersistenceException  | NumberFormatException e) {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<a>Please Make Sure that Subject ID you have given is correct and that you are giving valid Input.</a><br>");
		out.println("<nav> <a href= 'mainMenu.html'>Click here to go to Main Menu</a><br>");
		out.println("<a href= 'SunjectsList'>Click here to view list of subjects</a><br>");
		out.println("<a href= 'deleteSubject.html'>Click here to try again.</a></nav>");
		out.println("</body></html>");
	}
	}

}
