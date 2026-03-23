package springboot.poject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.poject.entity.Receptionist;

@Repository
public interface ReceptionistRepository extends JpaRepository<Receptionist, Integer>{

}
