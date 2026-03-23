package springboot.poject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.poject.dto.DoctorDto;
import springboot.poject.dto.ResponseStructure;
import springboot.poject.entity.Doctor;
import springboot.poject.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService service;

	@PostMapping("/save")
	public ResponseStructure<DoctorDto> save(@RequestBody DoctorDto dto) {

		DoctorDto saved = service.saveDoctor(dto);

		ResponseStructure<DoctorDto> resp = new ResponseStructure<DoctorDto>();
		resp.setStatus(201);
		resp.setMsg("Doctor Created");
		resp.setData(saved);

		return resp;
	}

	@PutMapping("/update/{id}")
	public ResponseStructure<DoctorDto> update(@PathVariable Integer id, @RequestBody DoctorDto dto) {

		DoctorDto updated = service.updateDoctor(id, dto);

		ResponseStructure<DoctorDto> resp = new ResponseStructure<DoctorDto>();
		resp.setStatus(200);
		resp.setMsg("Doctor Updated");
		resp.setData(updated);

		return resp;
	}

	@GetMapping("/getById/{id}")
	public ResponseStructure<DoctorDto> getById(@PathVariable Integer id) {

		DoctorDto dto = service.getDoctorById(id);

		ResponseStructure<DoctorDto> resp = new ResponseStructure<>();
		resp.setStatus(200);
		resp.setMsg("Doctor found");
		resp.setData(dto);

		return resp;

	}

	@DeleteMapping("/delete/{id}")
	public ResponseStructure<DoctorDto> delete(@PathVariable Integer id) {

		service.deleteDoctor(id);

		ResponseStructure<DoctorDto> resp = new ResponseStructure<>();
		resp.setStatus(200);
		resp.setMsg("Doctor deleted");
		resp.setData(null);

		return resp;

	}

	@GetMapping("/getAllDoctor")
	public ResponseStructure<List<DoctorDto>> getAll() {

		List<DoctorDto> all = service.getAllDoctors();

		ResponseStructure<List<DoctorDto>> resp = new ResponseStructure<>();
		resp.setStatus(200);
		resp.setMsg("List of Doctor");
		resp.setData(all);

		return resp;

	}

	@GetMapping("/search/{name}")
	public ResponseStructure<List<DoctorDto>> searchByName(@PathVariable String name) {

		List<DoctorDto> doc = service.searchByName(name);

		ResponseStructure<List<DoctorDto>> resp = new ResponseStructure<>();
		resp.setStatus(200);
		resp.setMsg("Doctor found");
		resp.setData(doc);

		return resp;
	}

}
