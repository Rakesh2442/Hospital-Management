package springboot.poject.service;

import java.util.List;

import springboot.poject.dto.DoctorDto;
import springboot.poject.entity.Doctor;

public interface DoctorService {

	DoctorDto saveDoctor(DoctorDto dto);

	DoctorDto updateDoctor(Integer id, DoctorDto dto);

	void deleteDoctor(Integer id);

	DoctorDto getDoctorById(Integer id);

	List<DoctorDto> getAllDoctors();

	// custom method
	List<DoctorDto> searchByName(String name);

}
