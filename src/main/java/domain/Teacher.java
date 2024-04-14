package domain;
import java.util.List;

import javax.management.relation.Role;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String codes;
	private String names;
	@Enumerated(EnumType.STRING)
	private Qualification qualification;
	@Enumerated(EnumType.STRING)
	private Role role;
	@ManyToOne
	@JoinColumn(name = "courseid")
	private Course courses;
	
	
	public Teacher() {
		super();
	}
	
	public Teacher(int id, String codes, String names, Qualification qualification, Role role, Course courses) {
		super();
		this.id = id;
		this.codes = codes;
		this.names = names;
		this.qualification = qualification;
		this.role = role;
		this.courses = courses;
	}

	public Teacher(String codes, String names, Qualification qualification, Role role, Course courses) {
		super();
		this.codes = codes;
		this.names = names;
		this.qualification = qualification;
		this.role = role;
		this.courses = courses;
	}
	

	public Teacher(int id) {
		super();
		this.id = id;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodes() {
		return codes;
	}

	public void setCodes(String codes) {
		this.codes = codes;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public Qualification getQualification() {
		return qualification;
	}

	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Course getCourses() {
		return courses;
	}

	public void setCourses(Course courses) {
		this.courses = courses;
	}


	public enum Qualification {
		  Masters,
		    PHD,
		    PROFESSOR
	}
	public enum Role{
		Lecturer,
		Assistant
	}
}
