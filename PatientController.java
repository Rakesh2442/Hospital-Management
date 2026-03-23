package springboot.poject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.poject.dto.PatientDto;
import springboot.poject.dto.ResponseStructure;
import springboot.poject.entity.Patient;
import springboot.poject.service.PatientService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService service;

	@PostMapping("/savePatient")
	public ResponseStructure<PatientDto> savePatient(@RequestBody PatientDto dto) {
		PatientDto saved = service.savePatient(dto);

		ResponseStructure<PatientDto> resp = new ResponseStructure<PatientDto>();
		resp.setStatus(201);
		resp.setMsg("Patient Created");
		resp.setData(saved);

		return resp;
	}

	@DeleteMapping("deletePatient/{id}")
	public ResponseStructure<PatientDto> deletePatient(@PathVariable Integer id) {
		service.deletePatient(id);

		ResponseStructure<PatientDto> resp = new ResponseStructure<PatientDto>();
		resp.setStatus(200);
		resp.setMsg("Patient deleted");
		resp.setData(null);

		return resp;
	}

	@PutMapping("/updatePatient/{id}")
	public ResponseStructure<PatientDto> updatePatient(@PathVariable Integer id, @RequestBody PatientDto dto) {
		PatientDto updated = service.updatePatient(id, dto);

		ResponseStructure<PatientDto> resp = new ResponseStructure<PatientDto>();
		resp.setStatus(200);
		resp.setMsg("Patient updated");
		resp.setData(updated);

		return resp;
	}

	@GetMapping("/patientGetById/{id}")
	public ResponseStructure<PatientDto> getById(@PathVariable Integer id) {
		PatientDto dto = service.getPatientById(id);

		ResponseStructure<PatientDto> resp = new ResponseStructure<PatientDto>();
		resp.setStatus(200);
		resp.setMsg("Patient Found");
		resp.setData(dto);
		return resp;
	}

	@GetMapping("/getAllPatient")
	public ResponseStructure<List<PatientDto>> getAllPatient() {

		List<PatientDto> list = service.getAllPatients();

		ResponseStructure<List<PatientDto>> resp = new ResponseStructure<List<PatientDto>>();
		resp.setStatus(200);
		resp.setMsg("All Patients");
		resp.setData(list);

		return resp;
	}

	@GetMapping("/searchPatient/{name}")
	public ResponseStructure<List<PatientDto>> searchPatient(@PathVariable String name) {

		List<PatientDto> list = service.searchByName(name);

		ResponseStructure<List<PatientDto>> resp = new ResponseStructure<>();
		resp.setStatus(200);
		resp.setMsg("Patient found");
		resp.setData(list);

		return resp;
	}
	
	

}
