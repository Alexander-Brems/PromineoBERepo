package student.college.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer professorID;
	private String firstName;
	private String lastName;
	private String department;
	private Boolean hasTenure;
	private String phoneNumber;
	private String email;
	
	@OneToMany(mappedBy = "teacher", cascade = CascadeType.PERSIST, orphanRemoval = true)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<Class> classes = new HashSet<>();
	
	public Professor() {
		
	}
}
