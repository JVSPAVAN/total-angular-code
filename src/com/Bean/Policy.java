package com.Bean;

public class Policy {
		private int policyId;
		private static int Policy_Id=1000;
		private String Policy_Name ;
		private int Num_of_nominees;
		private int Tenure;
		private int Sum_assured ;
		private int age;
		private String relation;
		
		public int getPolicyId() {
			return policyId;
		}
		public void setPolicyId(int policyId) {
			this.policyId = policyId;
		}
		public String getPolicy_Name() {
			return Policy_Name;
		}
		public void setPolicy_Name(String policy_Name) {
			Policy_Name = policy_Name;
		}
		public int getNum_of_nominees() {
			return Num_of_nominees;
		}
		public void setNum_of_nominees(int num_of_nominees) {
			Num_of_nominees = num_of_nominees;
		}
		public int getTenure() {
			return Tenure;
		}
		public void setTenure(int tenure) {
			Tenure = tenure;
		}
		public int getSum_assured() {
			return Sum_assured;
		}
		public void setSum_assured(int sum_assured) {
			Sum_assured = sum_assured;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getRelation() {
			return relation;
		}
		public void setRelation(String relation) {
			this.relation = relation;
		}
		public Policy( String policy_Name, int num_of_nominees, int tenure, int sum_assured, int age,
				String relation) {
			super();
			policyId  = Policy_Id++;
			Policy_Name = policy_Name;
			Num_of_nominees = num_of_nominees;
			Tenure = tenure;
			Sum_assured = sum_assured;
			this.age = age;
			this.relation = relation;
		}
		public Policy() {
			// TODO Auto-generated constructor stub
		}
		
		
		
	}

