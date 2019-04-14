package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Bean.Policy;
import com.DBUtil.DBUtil;


public class PolicyDAO {
	Connection con=null;
	PreparedStatement ps1=null;
	ResultSet rs=null;

	Policy b=new Policy();
	//inserting policy to db
	
	public boolean InsertPolicy(Policy policy)
	{
		boolean flag=false;
		con=DBUtil.getConnection();
		try{
		ps1=con.prepareStatement("insert into Policy_grp6 values(?,?,?,?,?,?,?)");
		System.out.println(policy.getPolicyId());
		ps1.setInt(1, policy.getPolicyId());
		ps1.setString(2, policy.getPolicy_Name());
		ps1.setInt(3, policy.getNum_of_nominees());
		ps1.setInt(4, policy.getTenure());
		ps1.setInt(5, policy.getSum_assured());
		ps1.setInt(6, policy.getAge());
		ps1.setString(7, policy.getRelation());
		ps1.executeUpdate();
		flag = true;
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally
	{

	DBUtil.closeStatement(ps1);
	DBUtil.closeConnection(con);
	}
	return flag;
		
	}

}
