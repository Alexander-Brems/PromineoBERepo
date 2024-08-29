package student.college.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Class {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer classID;
	private String classTitle;
	private String department;
	private String weekdays;
	private String startTime;
	private String endTime;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "professor_id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Professor teacher;
	
	@ManyToMany(mappedBy = "classes", cascade = CascadeType.PERSIST)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<Student> students = new HashSet<>();
	
	public Class() {
		
	}
}
