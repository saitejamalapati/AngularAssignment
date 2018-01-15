package com.accolite.rest.RestProject.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accolite.rest.RestProject.Model.Post;

public class PostService {
	
	List<Post> postList = new ArrayList<Post>();
	
	public PostService() {
		super();
	}
	
	public List<Post> getPosts(int userID) throws ClassNotFoundException, SQLException {
		List<Post> postList = new ArrayList<Post>();
		try {
			Connection con = MyConnection.getConnection();
			String query = "select * from post where userID="+userID;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				int id, userid;
				String data;
				id = rs.getInt("ID");
				data = rs.getString("data");
				userid = rs.getInt("userID");
				Post temp = new Post(id,userid,data);
				postList.add(temp);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return postList;
	}
	
	public Post getPostByID(int ID) throws ClassNotFoundException, SQLException {
		Post temp = null;
		try {
			Connection con = MyConnection.getConnection();
			String query = "select * from post where ID="+ID;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				int id, userid;
				String data;
				id = rs.getInt("ID");
				data = rs.getString("data");
				userid = rs.getInt("userID");
				temp = new Post(id,userid,data);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	    return temp;
	}
	
	public boolean addPost(Post post, int userID) throws ClassNotFoundException, SQLException {
		try {
			Connection con = MyConnection.getConnection();
			String query = "insert into post(userID,data) values(" + userID + ",'" + post.getData() + "')";
			Statement stmt = con.createStatement();
			int rowsCreated = stmt.executeUpdate(query);
			if(rowsCreated!=0)
				return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Post updatePost(int id, Post post) throws ClassNotFoundException, SQLException {
		Post temp = getPostByID(id);
		if(temp!=null) {
			temp.setData(post.getData());
			try {
				Connection con = MyConnection.getConnection();
				String query = "update user SET data='"+temp.getData()+"' where ID="+temp.getId();
				Statement stmt = con.createStatement();
				stmt.executeUpdate(query);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return temp;
		}
		return null;
	}
	
	public Post deletePost(int id) throws ClassNotFoundException, SQLException {
		Post temp = getPostByID(id);
		if(temp == null)
			return null;
		try {
			Connection con = MyConnection.getConnection();
			String query = "delete from post where ID="+id;
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return temp;
	}
}
