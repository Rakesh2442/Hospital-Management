package springboot.poject.dto;

import java.util.List;

public class DoctorDto {

	private Integer id;
	private String name;
	private String specification;

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

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public DoctorDto() {
	
	}

	public DoctorDto(Integer id, String name, String specification) {
		
		this.id = id;
		this.name = name;
		this.specification = specification;

	}

}
