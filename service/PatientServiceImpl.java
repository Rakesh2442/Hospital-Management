package springboot.poject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import springboot.poject.dto.DoctorDto;
import springboot.poject.dto.PatientDto;
import springboot.poject.dto.ReceptionistDto;
import springboot.poject.entity.Doctor;
import springboot.poject.entity.Patient;
import springboot.poject.entity.Receptionist;
import springboot.poject.repository.DoctorRepository;
import springboot.poject.repository.PatientRepository;
import springboot.poject.repository.ReceptionistRepository;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepo;

	@Autowired
	private DoctorRepository doctorRepo;

	@Autowired
	private ReceptionistRepository receptionistRepo;

	private PatientDto convertToDto(Patient entity) {
		PatientDto dto = new PatientDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setGender(entity.getGender());
		dto.setAge(entity.getAge());

		if (entity.getDoctor() != null) {
			dto.setDoctorId(entity.getDoctor().getId());
		}
		if (entity.getReceptionist() != null) {
			dto.setReceptionistId(entity.getReceptionist().getId());
		}
		return dto;
	}

	private Patient convertToEntity(PatientDto dto) {
		Patient entity = new Patient();
		BeanUtils.copyProperties(dto, entity, "doctorId", "receptionistId");
		return entity;
	}

	@Override
	public PatientDto savePatient(PatientDto dto) {
		Doctor doc = doctorRepo.findById(dto.getDoctorId())
				.orElseThrow(() -> new RuntimeException("Doctor not Found" + dto.getDoctorId()));

		Receptionist rec = receptionistRepo.findById(dto.getReceptionistId())
				.orElseThrow(() -> new RuntimeException("Receptionist not found" + dto.getReceptionistId()));

		Patient entity = convertToEntity(dto);
		entity.setDoctor(doc);
		entity.setReceptionist(rec);

		Patient saved = patientRepo.save(entity);

		return convertToDto(saved);
	}

	@Override
	public PatientDto updatePatient(Integer id, PatientDto dto) {

		Patient updated = patientRepo.findById(id).orElseThrow(() -> new RuntimeException("Patient not Found" + id));

		updated.setName(dto.getName());
		updated.setGender(dto.getGender());
		updated.setAge(dto.getAge());

		if (dto.getDoctorId() != null) {
			Doctor doc = doctorRepo.findById(dto.getDoctorId())
					.orElseThrow(() -> new RuntimeException("Doctor Not Found" + dto.getDoctorId()));

			updated.setDoctor(doc);
		}

		if (dto.getReceptionistId() != null) {
			Receptionist rec = receptionistRepo.findById(dto.getReceptionistId())
					.orElseThrow(() -> new RuntimeException("Reception not Found" + dto.getReceptionistId()));
			updated.setReceptionist(rec);
		}

		Patient pat = patientRepo.save(updated);

		return convertToDto(pat);
	}

	@Override
	public void deletePatient(Integer id) {
		Patient deleted = patientRepo.findById(id).orElseThrow(() -> new RuntimeException("Patient not found" + id));
		patientRepo.delete(deleted);

	}

	@Override
	public PatientDto getPatientById(Integer id) {
		Patient pat = patientRepo.findById(id).orElseThrow(() -> new RuntimeException("Patient not Found" + id));
		return convertToDto(pat);
	}

	@Override
	public List<PatientDto> getAllPatients() {

		List<Patient> patientList = patientRepo.findAll();
		List<PatientDto> list = new ArrayList<>();

		for (Patient pat : patientList) {
			PatientDto dto = new PatientDto();
			dto.setId(pat.getId());
			dto.setName(pat.getName());
			dto.setGender(pat.getGender());
			dto.setAge(pat.getAge());

			if (pat.getDoctor() != null) {
				dto.setDoctorId(pat.getDoctor().getId());
			}

			if (pat.getReceptionist() != null) {
				dto.setReceptionistId(pat.getReceptionist().getId());
			}
			list.add(dto);
		}

		return list;
	}

	@Override
	public List<PatientDto> searchByName(String name) {

		List<Patient> patientList = patientRepo.findByName(name);
		List<PatientDto> dtoList = new ArrayList<>();

		if (patientList == null || patientList.isEmpty()) {
			throw new RuntimeException("No Patient found with name: " + name);
		}

		for (Patient pat : patientList) {

			PatientDto dto = new PatientDto();
			dto.setId(pat.getId());
			dto.setName(pat.getName());
			dto.setGender(pat.getGender());
			dto.setAge(pat.getAge());

			if (pat.getDoctor() != null) {
				dto.setDoctorId(pat.getDoctor().getId());
			}

			if (pat.getReceptionist() != null) {
				dto.setReceptionistId(pat.getReceptionist().getId());
			}

			dtoList.add(dto);
		}

		return dtoList;
	}

}
