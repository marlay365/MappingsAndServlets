package com.java.practice2;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import lombok.Data;
import lombok.NoArgsConstructor;

public class ManytoMany {

static SessionFactory sf= null;
	
	static {
		Configuration cfg= new Configuration();
		cfg.configure("hibernate-properties.xml");
		sf= cfg.buildSessionFactory();
	}
	
	public static void main(String[] args) {
		
		Project p1 = new Project(101, "Titan");
		Project p2 = new Project(102, "Scorpio");
		Project p3 = new Project(103, "Apollo");
		
		Employee e1 = new Employee(101, "IT");
		Employee e2 = new Employee(102, "Media");
		Employee e3 = new Employee(103, "Mathematics");
		
		List<Employee> empList = Arrays.asList(e1, e2, e3);
		p1.setEmp(empList);
		List<Project> projList = Arrays.asList(p1, p2, p3);
		e1.setProj(projList);
		
		try {
			Session s = sf.openSession();
			s.beginTransaction();

			s.persist(p1);
			s.persist(e1);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}


@Entity
@Data
@NoArgsConstructor
class Employee{
	
	@Id
	int id;
	String name;
	String department;
	@ManyToMany(cascade = CascadeType.PERSIST)
	List<Project> proj;
	
	public Employee(int id, String name) {
		this.id = id;
		this.department = name;
	}	
	
}

@Entity
@Data
@NoArgsConstructor
class Project{
	
	@Id
	int id;
	String codename;
	@ManyToMany(cascade = CascadeType.PERSIST)
	List<Employee> emp;
	
	public Project(int id, String codename) {
		this.id = id;
		this.codename = codename;
	}
	
}



