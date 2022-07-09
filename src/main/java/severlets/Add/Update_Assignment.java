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

import entity.Assign;
import util.HibernateUtil;

/**
 * Servlet implementation class Update_Assignment
 */
@WebServlet("/Update_Assignment")
public class Update_Assignment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_Assignment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("updateAssignment.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("Id");
		String cid = request.getParameter("cId");
		String sid = request.getParameter("sId");
		String tid = request.getParameter("tId");
		
		try {
		Assign as = new Assign();
		as.setaId(Integer.parseInt(id));
		as.setClassId(Integer.parseInt(cid));
		as.settId(Integer.parseInt(tid));
		as.setsId(Integer.parseInt(sid));

		
		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		session.update(as);
		tx.commit();

		// 4. Close session
		session.close();

		PrintWriter pw = response.getWriter();
		pw.append("<html><body>");
		pw.append("Assignment update successfully!");
		pw.append("<nav> <a href= 'mainMenu.html'>Click here to go to Main Menu</a><br>");
		pw.append("<a href= 'updateAssignment.html'>Click here to update another Assignment.</a></nav>");
		pw.append("</body></html>");
	}
	catch(PersistenceException  | NumberFormatException e) {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<a>ERROR! Please Make Sure that Assign ID you have given is correct and that you are giving valid Input.</a><br>");
		out.println("<nav> <a href= 'mainMenu.html'>Click here to go to Main Menu</a><br>");
		out.println("<a href= 'AssignmentList'>Click here to view list of Assignment</a><br>");
		out.println("<a href= 'updateAssignment.html'>Click here to try again.</a></nav>");
		out.println("</body></html>");
	}
	}

}
