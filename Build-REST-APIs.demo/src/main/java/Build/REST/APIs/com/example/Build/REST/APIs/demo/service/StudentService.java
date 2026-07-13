package Build.REST.APIs.com.example.Build.REST.APIs.demo.service;

import Build.REST.APIs.com.example.Build.REST.APIs.demo.dto.StudentDto;
import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents(); //useful for getallstudent from Entity → DTO

    StudentDto getStudentbyId(long id);
}
