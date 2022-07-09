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

import entity.Students;
import util.HibernateUtil;

/**
 * Servlet implementation class Add_Student
 */
@WebServlet("/Add_Student")
public class Add_Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_Student() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("addStudent.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("Id");
		String studentName = request.getParameter("name");
		String eId = request.getParameter("EId");
		String phone = request.getParameter("no");
		String classId = request.getParameter("cId");
		String dob = request.getParameter("dob");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
		Students st = new Students();
		st.setId(Integer.parseInt(id));
		st.setName(studentName);
		st.setEmailId(eId);
		st.setPhoneNo(Long.parseLong(phone));
		st.setClassId(Integer.parseInt(classId));
		try {
			st.setDob(sdf.parse(dob));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		session.save(st);
		tx.commit();

		// 4. Close session
		session.close();

		PrintWriter pw = response.getWriter();
		pw.append("<html><body>");
		pw.append("Student Added successfully!");
		pw.append("<nav> <a href= 'mainMenu.html'>Click here to go to Main Menu");
		pw.append("<a href= 'addStudent.html'>Click here to add another student.</a></nav>");
		pw.append("</body></html>");
	}
	catch(PersistenceException  | NumberFormatException e) {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<a>Please Make Sure that Student ID you have given is Not already Used and that you are giving valid Input.</a><br>");
		out.println("<a>Also Make sure that You assinging the student to a existing class.</a><br> ");
		out.println("<nav> <a href= 'mainMenu.html'>Click here to go to Main Menu</a><br>");
		out.println("<a href= 'StudentsList'>Click here to view list of Students</a><br>");
		out.println("<a href= 'addStudent.html'>Click here to try again.</a></nav>");
		out.println("</body></html>");
	}
	
	}
	}


