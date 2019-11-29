package com.m4.jee.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



	@Entity
	@Table(name="user")
	@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
	public class User implements Serializable {
		
		
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		
		@Column (name="id")
		private Long id;
		
		@Column (name="name")
		private String name;
		
		@Column (name="surname")
		private String surname;
		
		@Column (name="email")
		private String email;
		
		@Column (name="password")
		private String password;
		
		@Column (name="age")
		private String age;
		
		
		
		public User(Long id, String name, String surname, String email, String password, String age) {
			super();
			this.id = id;
			this.name = name;
			this.surname = surname;
			this.email = email;
			this.password = password;
			this.age = age;
		}


		public User() {
			super();
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getSurname() {
			return surname;
		}


		public void setSurname(String surname) {
			this.surname = surname;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getAge() {
			return age;
		}


		public void setAge(String age ) {
			this.age = age ;
		}


		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		
		
}
	


