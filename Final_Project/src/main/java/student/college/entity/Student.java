package student.college.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentID;
	private String firstName;
	private String lastName;
	private Integer phoneNumber;
	private String email;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "student_class",
			joinColumns = @JoinColumn(name = "student_id"),
			inverseJoinColumns = @JoinColumn(name = "class_id"))
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<Class> classes = new HashSet<>();
	
	public Student() {
		
	}
}
