package domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="courseDefinition")
public class CourseDefinition {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	private String name;
	private String descriptions;
	@OneToOne(mappedBy = "coursd")
	private Course cours;
	public CourseDefinition() {
		super();
	}
	public CourseDefinition(int id, String code, String name, String descriptions, Course cours) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.descriptions = descriptions;
		this.cours = cours;
	}
	public CourseDefinition(int id, String code, String name, String descriptions) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.descriptions = descriptions;
	}
	public CourseDefinition(int id) {
		super();
		this.id = id;
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
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public Course getCours() {
		return cours;
	}
	public void setCours(Course cours) {
		this.cours = cours;
	}
	
}
