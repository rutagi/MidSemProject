package domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;



@Entity
@Table(name = "Academic_unit")
public class AcademicUnit {
	  @Id
	    @Column(name = "id")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @Column(name = "code")
	    private String code;

	    @Column(name = "name")
	    private String name;

	    @Enumerated(EnumType.STRING)
	    @Column(name = "unity_type")
	    private UnityType unityType;

	    @ManyToOne(cascade = CascadeType.REMOVE)
	    @JoinColumn(name = "parent_id", referencedColumnName = "id",nullable = true)
	    private AcademicUnit parentUnit;
	    @OneToMany(mappedBy = "unit")
	    private List<StudentRegistration> students;
	    @OneToMany(mappedBy="academic")
	    private List<Course> courses;
	    
	   public AcademicUnit() {
			
		}
       

	public AcademicUnit(int id, String code, String name, UnityType unityType, AcademicUnit parentUnit) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.unityType = unityType;
		this.parentUnit = parentUnit;
	}






	public AcademicUnit(int id) {
		super();
		this.id = id;
	}


	public AcademicUnit(int id, String code, String name, UnityType unityType, AcademicUnit parentUnit,
			List<StudentRegistration> students, List<Course> courses) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.unityType = unityType;
		this.parentUnit = parentUnit;
		this.students = students;
		this.courses = courses;
	}
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public UnityType getUnityType() {
		return unityType;
	}


	public void setUnityType(UnityType unityType) {
		this.unityType = unityType;
	}


	public AcademicUnit getParentUnit() {
		return parentUnit;
	}


	public void setParentUnit(AcademicUnit parentUnit) {
	    this.parentUnit = parentUnit;
	}


	public List<StudentRegistration> getStudents() {
		return students;
	}


	public void setStudents(List<StudentRegistration> students) {
		this.students = students;
	}


	public List<Course> getCourses() {
		return courses;
	}


	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

    public enum UnityType {
        PROGRAMME,
        FACULTY,
        DEPARTMENT
    }
}
