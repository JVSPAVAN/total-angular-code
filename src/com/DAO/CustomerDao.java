package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Bean.CustomerBean;
import com.DBUtil.DBUtil;

public class CustomerDao {

	Connection con=null;
	PreparedStatement ps,ps1,ps2=null;
	ResultSet rs=null;
	int valId=0;

	CustomerBean b=new CustomerBean();
	//inserting customer to db
	
	public boolean InsertCustomer(CustomerBean customerBean)
	{
		boolean flag=false;
		con=DBUtil.getConnection();
		try{
			/*ps2 = con.prepareStatement("select * from Customer_grp6 where CustId = ?");
			ps2.setInt(1, customerBean.getCustId());
			rs = ps.executeQuery();
			while(rs.next()){
				valId++;
			}*/
		
		
		ps1=con.prepareStatement("insert into Customer_grp6 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	
	ps1.setInt(1, customerBean.getCustId());
		ps1.setString(2, customerBean.getFirst_Name());
		ps1.setString(3, customerBean.getMiddle_Name());
		ps1.setString(4, customerBean.getLast_Name());
		ps1.setString(5, customerBean.getDate_of_Birth());
		ps1.setString(6, customerBean.getGender());
		ps1.setString(7, customerBean.getPermanent_Address());
		ps1.setString(8, customerBean.getPresent_Address());
		ps1.setString(9, customerBean.getOccupation());
		ps1.setFloat(10, customerBean.getAnnual_Salary());
		ps1.setString(11, customerBean.getMarried());
		ps1.setInt(12, customerBean.getChildren());
		ps1.setString(13, customerBean.getEmail());
		ps1.setString(14, customerBean.getPhone());
		ps1.setString(15, customerBean.getPAN_card());
	
	
		
		ps1.executeUpdate();
		flag = true;
			
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally
	{

	DBUtil.closeStatement(ps1);
	//DBUtil.closeStatement(ps2);
	DBUtil.closeConnection(con);
	}
	return flag;
		
	}
	
	//viewing customer details
	
	public ArrayList<CustomerBean> viewCustomerDetails()
	{
		ArrayList<CustomerBean> alist=new ArrayList<CustomerBean>();
		con=DBUtil.getConnection();
		try {
			ps=con.prepareStatement("select * from Customer_grp6");
			rs=ps.executeQuery();
			while(rs.next())
			{
				CustomerBean c=new CustomerBean();
				c.setCustId(rs.getInt("CustId"));
				c.setFirst_Name(rs.getString("First_Name"));
				c.setMiddle_Name(rs.getString("Middle_Name"));
				c.setLast_Name(rs.getString("Last_Name"));
				c.setDate_of_Birth(rs.getString("Date_of_Birth"));
				c.setGender(rs.getString("Gender"));
				c.setPermanent_Address(rs.getString("Permanent_Address"));
				c.setPresent_Address(rs.getString("Present_Address"));
				c.setOccupation(rs.getString("Occupation"));
				c.setAnnual_Salary(rs.getFloat("Annual_Salary"));
				c.setMarried(rs.getString("Married"));
				c.setChildren(rs.getInt("Children"));
				c.setEmail(rs.getString("Email"));
				c.setPhone(rs.getString("Phone"));
				c.setPAN_card(rs.getString("PAN_card"));
			
				alist.add(c);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			
		DBUtil.closeStatement(ps);
		DBUtil.closeConnection(con);
		}
		return alist;
	}
	
	
	//deleting customer details
	
	public int deleteCustDetails(int custId )
	{
		con=DBUtil.getConnection();
		try {
			ps=con.prepareStatement("delete from Customer_grp6 where CustId=?");
			ps.setInt(1, custId);
			ps.executeUpdate();
			int y=ps.executeUpdate();
			if(y>0)
			{
				return 1;
			}
		}

          catch (SQLException e) {
	         // TODO Auto-generated catch block
	           e.printStackTrace();
               }

             finally
             {
	
          DBUtil.closeStatement(ps);
          DBUtil.closeConnection(con);
               }
		return 0;
	}
	
	
	//updating customer details
	
	public int updateCustDetails(int CustId)
	{
		ArrayList<CustomerBean> alist=new ArrayList<CustomerBean>();
		for(CustomerBean c:alist){
			if(alist.contains(CustId)){
				b=c;
			}
		}
		int y=0;
		con=DBUtil.getConnection();
		try {
			   
			ps1=con.prepareStatement("update Customer_grp6 set Permanent_Address=?,Present_Address=?,Occupation=?,Annual_Salary=?,Married=?,Children=?,Email=?,Phone=?,PAN_card=? where CustId=?");
			ps1.setString(1,b.getPermanent_Address());
			ps1.setString(2,b.getPresent_Address());
			ps1.setString(3,b.getOccupation());
			ps1.setFloat(4,b.getAnnual_Salary());
			ps1.setString(5,b.getMarried());
			ps1.setInt(6,b.getChildren());
			ps1.setString(7,b.getEmail());
			ps1.setString(8,b.getPhone());
			ps1.setString(9,b.getPAN_card());
			y=ps1.executeUpdate();
			
		}
		
          catch (SQLException e) {
	         // TODO Auto-generated catch block
	           e.printStackTrace();
               }

             finally
             {
	
          DBUtil.closeStatement(ps1);
          DBUtil.closeConnection(con);
               }
		
		
			return y;
		
	}

}

