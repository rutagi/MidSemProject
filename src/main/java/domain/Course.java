package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
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
@Table
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseid;
    private String CourseName; // Updated attribute name to follow Java naming conventions
    @OneToOne
    @JoinColumn(name="id")
    private CourseDefinition coursd;
    @OneToMany(mappedBy = "courses")
    private List<Teacher> teacher;
    @ManyToOne
    @JoinColumn(name="semid")
    private Semester sems;
    @ManyToOne
    @JoinColumn(name="acaid")
    private AcademicUnit academic;
    @ManyToMany(mappedBy = "courses")
    private List<StudentRegistration> students = new ArrayList<StudentRegistration>();

    public Course() {

    }

    public Course(int courseid) {
        super();
        this.courseid = courseid;
    }

    public Course(int courseid, String CourseName, CourseDefinition coursd, List<Teacher> teacher, Semester sems, AcademicUnit academic) {
        super();
        this.courseid = courseid;
        this.CourseName = CourseName;
        this.coursd = coursd;
        this.teacher = teacher;
        this.sems = sems;
        this.academic = academic;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public CourseDefinition getCoursd() {
        return coursd;
    }

    public void setCoursd(CourseDefinition coursd) {
        this.coursd = coursd;
    }

    public List<Teacher> getTeacher() {
        return teacher;
    }

    public void setTeacher(List<Teacher> teacher) {
        this.teacher = teacher;
    }

    public Semester getSems() {
        return sems;
    }

    public void setSems(Semester sems) {
        this.sems = sems;
    }

    public AcademicUnit getAcademic() {
        return academic;
    }

    public void setAcademic(AcademicUnit academic) {
        this.academic = academic;
    }

    public List<StudentRegistration> getStudents() {
        return students;
    }

    public void setStudents(List<StudentRegistration> students) {
        this.students = students;
    }
}
