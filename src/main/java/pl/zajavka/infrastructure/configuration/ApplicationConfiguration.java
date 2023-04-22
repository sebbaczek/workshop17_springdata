package pl.zajavka.infrastructure.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.zajavka.EmployeeRunner;

@Configuration
@ComponentScan(basePackageClasses = EmployeeRunner.class)
@Import(PersistenceJPAConfiguration.class)
public class ApplicationConfiguration {
}
