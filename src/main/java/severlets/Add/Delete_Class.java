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

import entity.Classes;
import util.HibernateUtil;

/**
 * Servlet implementation class Delete_Class
 */
@WebServlet("/Delete_Class")
public class Delete_Class extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete_Class() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("DeleteClass.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("Id");
		
		try {
		Classes cl = new Classes();
		cl.setClassId(Integer.parseInt(id));

		
		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		session.delete(cl);
		tx.commit();

		// 4. Close session
		session.close();

		PrintWriter pw = response.getWriter();
		pw.append("<html><body>");
		pw.append("Class delete successfully!");
		pw.append("<nav> <a href= 'mainMenu.html'>Click here to go to Main Menu</a><br>");
		pw.append("<a href= 'deleteClass.html'>Click here to delete another class.</a></nav>");
		pw.append("</body></html>");
	}
	catch(PersistenceException | NumberFormatException e) {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<a>ERROR! Please Make Sure that Class ID you have given is correct one and that you are giving valid Input.</a><br>");
		out.println("<nav> <a href= 'mainMenu.html'>Click here to go to Main Menu</a><br>");
		out.println("<a href= 'ClassesList'>Click here to view list of classes</a><br>");
		out.println("<a href= 'deleteClass.html'>Click here to try again.</a></nav>");
		out.println("</body></html>");
	}
	}

}
