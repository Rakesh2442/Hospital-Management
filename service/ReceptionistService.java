package springboot.poject.service;

import java.util.List;

import springboot.poject.dto.ReceptionistDto;
import springboot.poject.entity.Receptionist;

public interface ReceptionistService {
	
	ReceptionistDto saveReceptionist(ReceptionistDto receptionistDto);

	ReceptionistDto updateReceptionist(Integer id, ReceptionistDto dto);
	
	void deleteReceptionist(Integer id);
	
	ReceptionistDto getReceptionistByid(Integer id);
	
	List<ReceptionistDto> getAllReceptionist();
}
