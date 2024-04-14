package domain;

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
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="students")
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(name = "regNo")
private String regNo;
@Column(name = "fname")
private String firstName;
@Column(name="lname")
private String lastName;
@Column(name="email")
private  String email;
@Column(name = "phone")
private String phone;
@Column(name="birth_date")
private String dob;
@Column(name="password")
private String password;
@OneToMany(mappedBy = "student")
private List<StudentRegistration>students;
public Student() {
	super();
}
public Student(int id) {
	super();
	this.id = id;
}
public Student(int id, String regNo, String firstName, String lastName, String email, String phone, String dob,
		String password, List<StudentRegistration> students) {
	super();
	this.id = id;
	this.regNo = regNo;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.phone = phone;
	this.dob = dob;
	this.password = password;
	this.students = students;
}
public Student(String regNo, String firstName, String lastName, String email, String phone, String dob, String password,
		List<StudentRegistration> students) {
	super();
	this.regNo = regNo;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.phone = phone;
	this.dob = dob;
	this.password = password;
	this.students = students;
}
public Student(String regNo, String firstName, String lastName, String email, String phone, String dob,
		String password) {
	super();
	this.regNo = regNo;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.phone = phone;
	this.dob = dob;
	this.password = password;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getRegNo() {
	return regNo;
}
public void setRegNo(String regNo) {
	this.regNo = regNo;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public List<StudentRegistration> getStudents() {
	return students;
}
public void setStudents(List<StudentRegistration> students) {
	this.students = students;
}


}
