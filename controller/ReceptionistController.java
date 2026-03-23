package springboot.poject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.poject.dto.ReceptionistDto;
import springboot.poject.dto.ResponseStructure;
import springboot.poject.entity.Receptionist;
import springboot.poject.service.ReceptionistService;

@RestController
@RequestMapping("/receptionist")
public class ReceptionistController {

	@Autowired
	private ReceptionistService service;

	@PostMapping("/saveReceptionist")
	public ResponseStructure<ReceptionistDto> saveReceptionist(@RequestBody ReceptionistDto dto) {
		ReceptionistDto saved = service.saveReceptionist(dto);

		ResponseStructure<ReceptionistDto> resp = new ResponseStructure<ReceptionistDto>();
		resp.setStatus(201);
		resp.setMsg("Receptionist Created");
		resp.setData(saved);

		return resp;

	}

	@DeleteMapping("/deleteReceptionist/{id}")
	public ResponseStructure<ReceptionistDto> delete(@PathVariable Integer id) {
		service.deleteReceptionist(id);

		ResponseStructure<ReceptionistDto> resp = new ResponseStructure<>();
		resp.setStatus(200);
		resp.setMsg("Receptionist Deleted");
		resp.setData(null);

		return resp;

	}

	@PutMapping("/updateReceptionist/{id}")
	public ResponseStructure<ReceptionistDto> update(@PathVariable Integer id, @RequestBody ReceptionistDto dto) {
		ReceptionistDto updated = service.updateReceptionist(id, dto);

		ResponseStructure<ReceptionistDto> resp = new ResponseStructure<ReceptionistDto>();
		resp.setStatus(200);
		resp.setMsg("Receptionist Updated");
		resp.setData(updated);
		return resp;
	}

	@GetMapping("/receptionistGetById/{id}")
	public ResponseStructure<ReceptionistDto> getById(@PathVariable Integer id) {
		ReceptionistDto dto = service.getReceptionistByid(id);

		ResponseStructure<ReceptionistDto> resp = new ResponseStructure<ReceptionistDto>();
		resp.setStatus(200);
		resp.setMsg("Receptionist Found");
		resp.setData(dto);
		return resp;
	}

	@GetMapping("/getAllReceptionist")
	public ResponseStructure<List<ReceptionistDto>> getAll() {

		List<ReceptionistDto> list = service.getAllReceptionist();

		ResponseStructure<List<ReceptionistDto>> resp = new ResponseStructure<>();
		resp.setStatus(200);
		resp.setMsg("All Receptionist");
		resp.setData(list);

		return resp;

	}

}
