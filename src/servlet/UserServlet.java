package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDao;


/**
 * Servlet implementation class UserServlet
 */
@WebServlet(name="/UserServlet",urlPatterns="/user")
public class UserServlet extends HttpServlet {
	
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// 放在第一行
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String method = request.getParameter("method");
		UserDao ud = new UserDao();
		
		switch (method) {
		case "loginPage":
			request.getRequestDispatcher("login.jsp").forward(request, response);
			break;
		case "registPage":
			request.getRequestDispatcher("register.jsp").forward(request, response);
			break;
		case "login":
			//ajax请求的响应方式
			String username = request.getParameter("username");
			String sno = request.getParameter("sno");
			String msg = ud.login(username, sno, request);
			if(msg.equals("验证成功")){
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else{
				response.getWriter().write("<script language='javasrcipt'>alert("+msg+");</script>");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			break;
		case "register":
			//ajax退出
			register(request,response);
			break;
		case "editPage":
			//ajax退出
			updatePage(request,response);
			break;
		case "update":
			//ajax退出
			update(request,response);
			break;
		default:
			break;
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String sno = request.getParameter("sno");
		String xi = request.getParameter("xi");
		String qudui = request.getParameter("qudui");
		Integer id = Integer.parseInt(request.getParameter("id"));
		UserDao ud = new UserDao();
		String[] field1 = {"username","sno","xi","qudui"};
		String[] field2 = {username,sno,xi,qudui};
		ud.update(field1, field2, id);
		response.sendRedirect("index.jsp");
	}

	private void updatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int id = Integer.parseInt(request.getParameter("id"));
	    int type = Integer.parseInt(request.getParameter("type"));
	    UserDao ud = new UserDao();
	    User user = ud.getDrugById(id);
	    request.setAttribute("user", user);
	    if(type==1){
	    	//修改
	    	request.getRequestDispatcher("show.jsp").forward(request, response);
	    }else{
	    	//查看
	    	request.getRequestDispatcher("updata.jsp").forward(request, response);
	    }
	}

	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String sno = request.getParameter("sno");
		String xi = request.getParameter("xi");
		String qudui = request.getParameter("qudui");
		User user = new User();
		user.setQudui(qudui);
		user.setSno(sno);
		user.setUsername(username);
		user.setXi(xi);
		UserDao ud = new UserDao();
		ud.insert(user);
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
