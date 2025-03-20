package com.spring.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.spring.ex.dto.PersonDto;

public class PersonDao {

	String driver ="oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String userId = "sqlid";
	String userPw = "sqlpw";
	Connection conn =null;
	PreparedStatement ps =null;
	ResultSet rs = null;

	private PersonDao() {
		System.out.println("객체 생성");
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,userId,userPw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static PersonDao pdao;
	public static PersonDao getInstance() {
		if(pdao == null) {
			pdao = new PersonDao();
		}
		return pdao;
	}//getInstance
	
	public int insertPerson(String id, String name, String age){
		int cnt = -1;
		String sql = "insert into person values(person_seq.nextval,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, age);
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}
	
	public ArrayList<PersonDto> getAllPerson() {
	    ArrayList<PersonDto> lists = new ArrayList<PersonDto>();
	    PersonDto pd = null;
	    String sql = "select * from person order by num asc";
	    
	    try {
	        ps = conn.prepareStatement(sql);
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            pd = new PersonDto();
	            pd.setNum(rs.getInt("num"));
	            pd.setId(rs.getString("id"));
	            pd.setName(rs.getString("name"));
	            pd.setAge(rs.getInt("age"));
	            lists.add(pd);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    System.out.println("lists.size() : " + lists.size());
	    return lists;
	}
	
	public PersonDto oneSelectNum(int num) {
		PersonDto pd = null;
		String sql = "select * from person where num=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			if(rs.next()) {
				pd = new PersonDto();
				pd.setNum(rs.getInt("num"));
				pd.setId(rs.getString("id"));
				pd.setName(rs.getString("name"));
				pd.setAge(rs.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pd;
	}
	
	public int updatePerson(PersonDto pd) {
		int cnt = -1;
		String sql = "update person set id=?, name=?, age=? where num = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pd.getId());
			ps.setString(2, pd.getName());
			ps.setInt(3, pd.getAge());
			ps.setInt(4, pd.getNum());

			cnt = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}//updatePerson
	
	public int deletePerson(int num) {
		
		int cnt = -1;
		String sql ="delete from person where num=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, num);
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}
}