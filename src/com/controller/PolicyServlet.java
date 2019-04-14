package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.Policy;
import com.DAO.PolicyDAO;

/**
 * Servlet implementation class PolicyServlet
 */
@WebServlet("/PolicyServlet")
public class PolicyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PolicyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		 RequestDispatcher rd= null;
		 
		 boolean flag=false;
		/* response.setHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().append("Served at: ").append(request.getContextPath());*/
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("addpolicy")){
			System.out.print("coming to servlet");
			 String Policy_Name = request.getParameter("Policy_Name");
			 int Num_of_nominees =Integer.parseInt(request.getParameter("Num_of_nominees"));
			 int Tenure = Integer.parseInt(request.getParameter("Tenure"));
			 int Sum_assured= Integer.parseInt(request.getParameter("Sum_assured"));
			 int age =Integer.parseInt(request.getParameter("age"));
			 String relation = request.getParameter("relation");
			
			 Policy policy = new Policy(Policy_Name,Num_of_nominees,Tenure,Sum_assured,age,relation);
			 PolicyDAO dao= new PolicyDAO();
			 flag = dao.InsertPolicy(policy);
			 
			 if(flag){

					rd=request.getRequestDispatcher("SuccessPolicy.jsp");
					rd.forward(request, response);
				}else{
					rd=request.getRequestDispatcher("errorPolicy.jsp");
					rd.forward(request, response);
				} 
			
			 
	}}
}

