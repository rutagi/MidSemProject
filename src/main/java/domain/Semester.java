package domain;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="semester")
public class Semester {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int semid;
	@Column(name="Sem_name")
	private String name;
	@Column(name="Sem_startdate")
	private LocalDate startdate;
	@Column(name="Sem_enddate")
	private LocalDate enddate;
	@OneToMany(mappedBy = "sem")
	private List<StudentRegistration> reg;
    @OneToMany(mappedBy = "sems")
	private List<Course> course;
	public Semester() {
		super();
	}
	public Semester(int semid) {
		super();
		this.semid = semid;
	}
	public Semester(int semid, String name, LocalDate startdate, LocalDate enddate) {
		super();
		this.semid = semid;
		this.name = name;
		this.startdate = startdate;
		this.enddate = enddate;
	}
	public int getSemid() {
		return semid;
	}
	public void setSemid(int semid) {
		this.semid = semid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getStartdate() {
		return startdate;
	}
	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}
	public LocalDate getEnddate() {
		return enddate;
	}
	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}
	public List<StudentRegistration> getReg() {
		return reg;
	}
	public void setReg(List<StudentRegistration> reg) {
		this.reg = reg;
	}
	public List<Course> getCourse() {
		return course;
	}
	public void setCourse(List<Course> course) {
		this.course = course;
	}
    
}