package pl.zajavka.infrastructure.database.jpaRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zajavka.infrastructure.database.model.EmployeeEntity;

// Integer w generyku bierze się z klucza głównego w EmployeeEntity
@Repository
public interface EmployeeDataJpaRepository extends JpaRepository<EmployeeEntity, Integer> {
}
