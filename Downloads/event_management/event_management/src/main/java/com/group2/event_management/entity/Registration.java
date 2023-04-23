package com.group2.event_management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="Registration")
public class Registration {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Integer regId;
		@Column(name="First_Name")
		private String firstName;
		@Column(name="Last_Name")
		private String lastName;
		@Column(name="Organization_Name")
		private String orgName;
		@Column(name="Designation")
		private String designation;
		@Column(name="Email_Id")
		private String emailId;
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getOrgName() {
			return orgName;
		}
		public void setOrgName(String orgName) {
			this.orgName = orgName;
		}
		public String getDesignation() {
			return designation;
		}
		public void setDesignation(String designation) {
			this.designation = designation;
		}
		@Override
		public String toString() {
			return "Registration [id=" + regId + ", firstName=" + firstName + ", lastName=" + lastName+", Organization Name=" + orgName + ", Designation=" + designation+ ", emailId=" + emailId
					+ "]";
		}
		
		
		
}
