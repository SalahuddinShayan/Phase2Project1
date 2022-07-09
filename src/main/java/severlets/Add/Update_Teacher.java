package severlets.Add;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.PersistenceException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Teachers;
import util.HibernateUtil;

/**
 * Servlet implementation class Update_Teacher
 */
@WebServlet("/Update_Teacher")
public class Update_Teacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_Teacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("updateTeacher.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("Id");
		String tName = request.getParameter("name");
		String doj = request.getParameter("doj");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
		Teachers th = new Teachers();
		th.settId(Integer.parseInt(id));
		th.settName(tName);
		try {
			th.setDateOfJoining(sdf.parse(doj));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		session.update(th);
		tx.commit();

		// 4. Close session
		session.close();

		PrintWriter pw = response.getWriter();
		pw.append("<html><body>");
		pw.append("Teacher updated successfully!");
		pw.append("<nav> <a href= 'mainMenu.html'>Click here to go to Main Menu</a><br>");
		pw.append("<a href= 'udateTeacher.html'>Click here to update another teacher.</a></nav>");
		pw.append("</body></html>");
	}
	catch(PersistenceException  | NumberFormatException e) {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<a>ERROR! Please Make Sure that Teacher ID you have given is correct and that you are giving valid Input.");
		out.println("<nav> <a href= 'mainMenu.html'>Click here to go to Main Menu</a><br>");
		out.println("<a href= 'TeachersList'>Click here to view list of Teachers</a><br>");
		out.println("<a href= 'updateTeachers.html'>Click here to try again.</a></nav>");
		out.println("</body></html>");
	}	}

}
