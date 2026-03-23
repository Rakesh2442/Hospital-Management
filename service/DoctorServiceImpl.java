package springboot.poject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.poject.dto.DoctorDto;
import springboot.poject.entity.Doctor;
import springboot.poject.exception.DoctorNotFoundException;
import springboot.poject.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepo;

	private DoctorDto convertToDto(Doctor doc) {
		DoctorDto dto = new DoctorDto();
		BeanUtils.copyProperties(doc, dto);
//		dto.setId(doc.getId());
//		dto.setName(doc.getName());
//		dto.setSpecification(doc.getSpecification());
		return dto;
	}

	private Doctor convertToEntity(DoctorDto dto) {
		Doctor doc = new Doctor();
		BeanUtils.copyProperties(dto, doc);
		return doc;
	}

	@Override
	public DoctorDto saveDoctor(DoctorDto dto) {
		Doctor entity = convertToEntity(dto);
		Doctor saved = doctorRepo.save(entity);
		return convertToDto(saved);

	}

	@Override
	public DoctorDto updateDoctor(Integer id, DoctorDto dto) {
		Doctor doc = doctorRepo.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found" + id));

		doc.setName(dto.getName());
		doc.setSpecification(dto.getSpecification());

		Doctor updated = doctorRepo.save(doc);

		return convertToDto(updated);

	}

	@Override
	public void deleteDoctor(Integer id) {
		Doctor doc = doctorRepo.findById(id).orElseThrow(() -> new RuntimeException("Doctor not Found" + id));

		doctorRepo.delete(doc);
	}

	@Override
	public DoctorDto getDoctorById(Integer id) {
		Doctor doc = doctorRepo.findById(id).orElseThrow(() -> new RuntimeException("Doctor not Found" + id));

		return convertToDto(doc);

	}

	@Override
	public List<DoctorDto> getAllDoctors() {
		List<Doctor> doctorList = doctorRepo.findAll();
		List<DoctorDto> list = new ArrayList<>();

		for (Doctor doc : doctorList) {
			DoctorDto dto = new DoctorDto();
			dto.setId(doc.getId());
			dto.setName(doc.getName());
			dto.setSpecification(doc.getSpecification());

			list.add(dto);

		}
		return list;
	}

	@Override
	public List<DoctorDto> searchByName(String name) {

		List<Doctor> doctorList = doctorRepo.findByName(name);
		List<DoctorDto> dtoList = new ArrayList<>();

		if (doctorList == null || doctorList.isEmpty()) {
			throw new DoctorNotFoundException("No doctor found with name:" + name);
		}

		for (Doctor doc : doctorList) {

			DoctorDto dto2 = new DoctorDto();
			dto2.setId(doc.getId());
			dto2.setName(doc.getName());
			dto2.setSpecification(doc.getSpecification());

			dtoList.add(dto2);
		}

		return dtoList;
	}

//	@Override
//	public List<Doctor> searchByName(String name) {
//		List<Doctor> doc = doctorRepo.findByName(name);
//
//		if (doc == null || doc.isEmpty()) {
//			throw new DoctorNotFoundException("Doctor with name" + name + "not found");
//		}
//
//		return doc;
//	}

}
