package Build.REST.APIs.com.example.Build.REST.APIs.demo.repository;

import Build.REST.APIs.com.example.Build.REST.APIs.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long> {
    //declair here to which entity we should connect student entity long id

}
