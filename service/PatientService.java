package springboot.poject.service;

import java.util.List;

import springboot.poject.dto.PatientDto;
import springboot.poject.entity.Patient;

public interface PatientService {

	PatientDto savePatient(PatientDto patientDto);

	PatientDto updatePatient(Integer id, PatientDto patientDto);

	void deletePatient(Integer id);

	PatientDto getPatientById(Integer id);
	
	List<PatientDto> getAllPatients();
	
	
	//custom method
	List<PatientDto> searchByName(String name);

}
