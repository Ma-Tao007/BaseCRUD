package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import bean.User;
import util.DBUtil;

public class UserDao {
	/**
	 * 登陆验证
	 * @param username
	 * @param password
	 * @param request 
	 * @return
	 */
	public String login(String username,String sno, HttpServletRequest request){
		String sql = "select * from user where username='"+username+"'";
	     Connection conn = DBUtil.getConn();
	     Statement state = null;
	     ResultSet rs = null;
	     User user = new User();
	     Boolean flag = false;
	     try {
	         state = conn.createStatement();
	         rs = state.executeQuery(sql);
	         while(rs.next())
	         {
	        	 flag = true;
	        	 user.setId(rs.getInt("id"));
	        	 user.setUsername(rs.getString("username"));
	        	 user.setSno(rs.getString("sno"));
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	     } finally {
	         DBUtil.close(state, conn);
	     }
	     if(!flag){
	    	 return "用户名不存在";
	     }else{
	    	 if(user.getSno().equals(sno)){
	    		 //存到session中
	    		 request.getSession().setAttribute("userinfo", user);
	    		 return "验证成功";
	    		 
	    	 }else{
	    		 return "密码错误";
	    	 }
	     }
	}
	/**
	 * 新增
	 */
	public boolean insert(User user){
		boolean f = false;
        String sql = "insert into user(xi,qudui,username,sno) values('"+user.getXi()+"'"
        		+ ",'"+user.getQudui()+"','"+user.getUsername()+"','"+user.getSno()+"')";
        
        Connection conn = DBUtil.getConn();
        Statement state = null;
        int a = 0;
        try {
            state = conn.createStatement();
            System.out.println(sql);
            a = state.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(state, conn);
        }
        if (a > 0) {
            f = true;
        }
        return f;
	}
	
	/**
	 * 单个通过id查询
	 */
	public User getDrugById(Integer id){
		User d = new User();
	     String sql = "select * from user where id="+id;
	     
	     Connection conn = DBUtil.getConn();
	     Statement state = null;
	     ResultSet rs = null;
	     try {
	         state = conn.createStatement();
	         rs = state.executeQuery(sql);
	         while(rs.next())
	         {
	        	 d.setId(rs.getInt("id"));
	        	 d.setXi(rs.getString("xi"));
	        	 d.setQudui(rs.getString("qudui"));
	        	 d.setUsername(rs.getString("username"));
	        	 d.setSno(rs.getString("sno"));
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	     } finally {
	         DBUtil.close(state, conn);
	     }
	     return d;
	}
	
	  /**
     * 修改*/
    public boolean update(String []strlist,String []strlist1,Integer id) {
        String sql = "update user set ";
        for(int i=0;i<strlist.length;i++)
        {
            if(i!=strlist.length-1)
                sql+=strlist[i]+"='" + strlist1[i] + "',";
            else sql+=strlist[i]+"='" + strlist1[i] + "' where id=" + id + "";
        }

        Connection conn = DBUtil.getConn();
        Statement state = null;
        boolean f = false;
        int a = 0;

        try {
            state = conn.createStatement();
            a = state.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(state, conn);
        }
        
        if (a > 0) {
            f = true;
        }
        return f;
    }
    
    /**
     * 查找所有
     */
    public List<User> getAllByPage(){
    	List<User> list = new ArrayList<>();
	     String sql = "select * from user ";
	     
	     Connection conn = DBUtil.getConn();
	     Statement state = null;
	     ResultSet rs = null;
	     try {
	         state = conn.createStatement();
	         rs = state.executeQuery(sql);
	         while(rs.next())
	         {
	        	 User d = new User();
	        	 d.setId(rs.getInt("id"));
	        	 d.setXi(rs.getString("xi"));
	        	 d.setQudui(rs.getString("qudui"));
	        	 d.setUsername(rs.getString("username"));
	        	 d.setSno(rs.getString("sno"));
	             list.add(d);
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	     } finally {
	         DBUtil.close(state, conn);
	     }
    	return list;
    }
}
