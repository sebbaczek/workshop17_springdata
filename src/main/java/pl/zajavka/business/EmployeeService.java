package pl.zajavka.business;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zajavka.infrastructure.database.jpaRepositories.EmployeeDataJpaRepository;
import pl.zajavka.infrastructure.database.model.EmployeeEntity;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    
    private final EmployeeDataJpaRepository employeeDataJpaRepository;
    
    @Transactional
    public void runSuccessful() {
        employeeDataJpaRepository.deleteAll();
        //trzeba dodać flush by delete się wykonało
        employeeDataJpaRepository.flush();
        
        EmployeeEntity employee1 = employeeDataJpaRepository.save(EmployeeData.someEmployee1());
        EmployeeEntity employee2 = employeeDataJpaRepository.save(EmployeeData.someEmployee2());
        EmployeeEntity employee3 = employeeDataJpaRepository.save(EmployeeData.someEmployee3());
//        EmployeeEntity employee1 = employeeDataJpaRepository.insertEmployee(EmployeeData.someEmployee1());
//        EmployeeEntity employee2 = employeeDataJpaRepository.insertEmployee(EmployeeData.someEmployee2());
//        EmployeeEntity employee3 = employeeDataJpaRepository.insertEmployee(EmployeeData.someEmployee3());
        System.out.println("###Employee 1: " + employeeDataJpaRepository.findById(employee1.getEmployeeId()));
        System.out.println("###Employee 2: " + employeeDataJpaRepository.findById(employee2.getEmployeeId()));
//        System.out.println("###Employee 1: " + employeeDataJpaRepository.getEmployee(employee1.getEmployeeId()));
//        System.out.println("###Employee 2: " + employeeDataJpaRepository.getEmployee(employee2.getEmployeeId()));

        EmployeeEntity employeeEntity = employeeDataJpaRepository.findById(employee3.getEmployeeId()).orElseThrow();
        employeeEntity.setSalary(new BigDecimal("10348.91"));
        employeeDataJpaRepository.saveAndFlush(employeeEntity);
        System.out.println("###Employee updated: "
                                   + employeeDataJpaRepository.findById(employee3.getEmployeeId()));
//        employeeDataJpaRepository.updateEmployee(employee3.getEmployeeId(), new BigDecimal("10348.91"));
//        System.out.println("###Employee updated: "
//            + employeeDataJpaRepository.getEmployee(employee3.getEmployeeId()));

        employeeDataJpaRepository.findAll()
                .forEach(employee -> System.out.println("###Employee: " + employee));
//        employeeDataJpaRepository.listEmployees()
//            .forEach(employee -> System.out.println("###Employee: " + employee));

        employeeDataJpaRepository.deleteById(employee2.getEmployeeId());
//      employeeDataJpaRepository.deleteEmployee(employee2.getEmployeeId());

        employeeDataJpaRepository.findAll()
                .forEach(employee -> System.out.println("###Employee: " + employee));
    }
    
    @Transactional
    public void testTransactional() {
        employeeDataJpaRepository.deleteAll();
        employeeDataJpaRepository.flush();
        
        employeeDataJpaRepository.saveAll(
                List.of(
                        EmployeeData.someEmployee1(),
                        EmployeeData.someEmployee2(),
                        EmployeeData.someEmployee3()
                )
        );
//           employeeDataJpaRepository.save(EmployeeData.someEmployee1());
//        employeeDataJpaRepository.save(EmployeeData.someEmployee2());
//        employeeDataJpaRepository.save(EmployeeData.someEmployee3());
//    }
    }
}
