package springboot.poject.entity;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Receptionist {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Long phone;

	@OneToMany(mappedBy = "receptionist", cascade = CascadeType.ALL)
	private List<Patient> patient;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public List<Patient> getPatient() {
		return patient;
	}

	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}

	public Receptionist() {
	}

	public Receptionist(Integer id, String name, Long phone) {
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

}
