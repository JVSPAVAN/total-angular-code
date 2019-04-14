package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.CustomerBean;
import com.DAO.CustomerDao;


/**
 * Servlet implementation class FastrackServlet
 */
@WebServlet("/FastrackServlet")
public class FastrackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FastrackServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		 RequestDispatcher rd= null;
		 //PrintWriter out = response.getWriter();
		 boolean flag=false;
		// SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
/*		 response.setHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().append("Served at: ").append(request.getContextPath());
*/		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("action")){
			System.out.print("coming to servlet");
			 String First_Name = request.getParameter("userfirst");
			 String Middle_Name = request.getParameter("usermiddle");
			 String Last_Name = request.getParameter("userlast");
			String dob=  request.getParameter("userdob");
			 String Gender = request.getParameter("gender");
			 String Permanent_Address = request.getParameter("userpermaddr");
			 String Present_Address = request.getParameter("userpresentaddr");
			 String Occupation = request.getParameter("useroccupation");
			 float Annual_Salary =Integer.parseInt(request.getParameter("usersalary"));
			 String Married = request.getParameter("marital");
			 int Children = Integer.parseInt(request.getParameter("userchildren"));
			 String Email = request.getParameter("useremail");
			 String Phone = request.getParameter("userphone");
			 String PAN_card = request.getParameter("userpan");
			 
			 CustomerBean customer = new CustomerBean(First_Name,Middle_Name,Last_Name,dob,Gender,Permanent_Address,
					 								  Present_Address,Occupation,Annual_Salary,Married,Children,Email,Phone,PAN_card);
			 CustomerDao customerdao= new CustomerDao();
			 flag = customerdao.InsertCustomer(customer);
			 
			 if(flag){

					rd=request.getRequestDispatcher("Success.jsp");
					rd.forward(request, response);
				}else{
					rd=request.getRequestDispatcher("error.jsp");
					rd.forward(request, response);
				}
			 
			 
			 ///to write view policy certificate of the customer
			 
			 ///to write the update Nominee to the customer.
			
			 
			 
			
		}/*
		else if(action.equalsIgnoreCase("addagent")){
			String first = request.getParameter("agentfirst");
			String middle = request.getParameter("agentmiddle");
			String last = request.getParameter("agentlast");
			String dob = request.getParameter("agentdob");
			String address = request.getParameter("agentaddr");
			int exp = Integer.parseInt(request.getParameter("agentexp"));
			String email = request.getParameter("agentemail");
			String phone = request.getParameter("agentphone");
			String pan = request.getParameter("agentpan");
			String zone = request.getParameter("agentzone");
			int ref = Integer.parseInt(request.getParameter("agentref"));
			
			AgentBean agent = new AgentBean(first,middle,last,dob,address,email,phone,exp,zone,ref,pan);
			AgentDao agentdao = new AgentDao();
			agentdao.InsertAgent(agent);
		}
		else if(action.equalsIgnoreCase("addmanager")){
			String first = request.getParameter("mangfirst");
			String dob = request.getParameter("mangdob");
			String state = request.getParameter("mangstate");
			String zone = request.getParameter("mangzone");
			String desg = request.getParameter("mangdesg");
			String email = request.getParameter("mangemail");
			
			ManagerBean manager = new ManagerBean(first,dob,state,zone,desg,email);
			ManagerDao managerdao = new ManagerDao();
			managerdao.InsertManager(manager);
			
		}
		else if(action.equalsIgnoreCase("viewusers")){
			CustomerDao customerdao = new CustomerDao();
			ArrayList<CustomerBean> customers = new ArrayList<CustomerBean>();
			customers = customerdao.viewCustomerDetails();
			
			if(customers.size()>0){
				response.setContentType("application/json");
				Gson gson = new GsonBuilder().create();
				JsonArray jarray = gson.toJsonTree(customers).getAsJsonArray();
				JsonObject jsonObject = new JsonObject();
				jsonObject.add("customers",jarray);
				response.getOutputStream().print(jsonObject.toString());
			}else{
				System.out.println("list is empty");
				rd=request.getRequestDispatcher("error1.jsp");
				rd.forward(request, response);
				
			}
		}
*/		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
