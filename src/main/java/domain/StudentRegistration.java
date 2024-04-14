package domain;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Registration")
public class StudentRegistration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int regid;
	@Column(name="registration_date")
	private LocalDate regDate;
	@ManyToOne
	@JoinColumn(name = "id")
	private Student student;
	@ManyToOne
	@JoinColumn(name="semid")
	private Semester sem;
	@ManyToOne
	@JoinColumn(name="acaid")
	private AcademicUnit unit;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "student_course",joinColumns = @JoinColumn(name="id")
	,inverseJoinColumns =@JoinColumn(name="courseid"))
	private List<Course>courses=new ArrayList<Course>();
	public StudentRegistration() {
		super();
	}
	
	public StudentRegistration(int regid, LocalDate regDate, Student student, Semester sem, AcademicUnit unit,
			List<Course> courses) {
		super();
		this.regid = regid;
		this.regDate = regDate;
		this.student = student;
		this.sem = sem;
		this.unit = unit;
		this.courses = courses;
	}

	public StudentRegistration(LocalDate regDate, Student student, Semester sem, AcademicUnit unit,
			List<Course> courses) {
		super();
		this.regDate = regDate;
		this.student = student;
		this.sem = sem;
		this.unit = unit;
		this.courses = courses;
	}

	public StudentRegistration(int regid) {
		super();
		this.regid = regid;
	}

	public int getRegid() {
		return regid;
	}

	public void setRegid(int regid) {
		this.regid = regid;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Semester getSem() {
		return sem;
	}

	public void setSem(Semester sem) {
		this.sem = sem;
	}

	public AcademicUnit getUnit() {
		return unit;
	}

	public void setUnit(AcademicUnit unit) {
		this.unit = unit;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
}
