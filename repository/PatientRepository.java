package springboot.poject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springboot.poject.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

	@Query("SELECT p from Patient p where p.name=:name")
	List<Patient> findByName(@Param("name") String name);
}
