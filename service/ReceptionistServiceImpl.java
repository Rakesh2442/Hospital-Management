package springboot.poject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import springboot.poject.dto.ReceptionistDto;
import springboot.poject.entity.Receptionist;
import springboot.poject.repository.ReceptionistRepository;

@Service
public class ReceptionistServiceImpl implements ReceptionistService {

	@Autowired
	private ReceptionistRepository repo;

	private ReceptionistDto convertToDto(Receptionist entity) {
		ReceptionistDto dto = new ReceptionistDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	private Receptionist convertToEntity(ReceptionistDto dto) {
		Receptionist entity = new Receptionist();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public ReceptionistDto saveReceptionist(ReceptionistDto dto) {
		Receptionist rec = repo.save(convertToEntity(dto));

		return convertToDto(rec);
	}

	@Override
	public ReceptionistDto updateReceptionist(Integer id, ReceptionistDto dto) {
		Receptionist rec = repo.findById(id).orElseThrow(() -> new RuntimeException("Receptionist not Found" + id));

		rec.setName(dto.getName());
		rec.setPhone(dto.getPhone());

		Receptionist updated = repo.save(rec);

		return convertToDto(updated);
	}

	@Override
	public void deleteReceptionist(Integer id) {
		Receptionist rec = repo.findById(id).orElseThrow(() -> new RuntimeException("Reception not found" + id));
		repo.delete(rec);

	}

	@Override
	public ReceptionistDto getReceptionistByid(Integer id) {
		Receptionist rec = repo.findById(id).orElseThrow(() -> new RuntimeException("Reception not found" + id));
		return convertToDto(rec);
	}

	@Override
	public List<ReceptionistDto> getAllReceptionist() {
		List<Receptionist> ReceptionistList = repo.findAll();
		List<ReceptionistDto> list = new ArrayList<>();

		for (Receptionist rec : ReceptionistList) {

			ReceptionistDto dto = new ReceptionistDto();
			dto.setId(rec.getId());
			dto.setName(rec.getName());
			dto.setPhone(rec.getPhone());

			list.add(dto);

		}

		return list;
	}

}
