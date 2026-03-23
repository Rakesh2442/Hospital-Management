package springboot.poject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springboot.poject.dto.DoctorDto;
import springboot.poject.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	
	@Query("SELECT d from Doctor d where d.name=:name")
	List<Doctor> findByName(@Param("name") String name);

	

}
