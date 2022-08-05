package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bean.Subscribe;
import com.util.ProjectUtil;

public class SubscirbeDao {
	public static void addSubscriber(Subscribe s)
	{
		try {
			Connection conn=ProjectUtil.createConnection();
			String sql="insert into subscriber(email) values(?)";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, s.getEmail());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
