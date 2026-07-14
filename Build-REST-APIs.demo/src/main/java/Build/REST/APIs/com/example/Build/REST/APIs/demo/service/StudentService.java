package Build.REST.APIs.com.example.Build.REST.APIs.demo.service;

import Build.REST.APIs.com.example.Build.REST.APIs.demo.dto.AddStudentRequestDto;
import Build.REST.APIs.com.example.Build.REST.APIs.demo.dto.StudentDto;
import java.util.List;
import java.util.Map;

public interface StudentService {
    //all these methods are used in controller to get post ...
    List<StudentDto> getAllStudents(); //useful for getallstudent from Entity → DTO

    StudentDto getStudentbyId(long id);//get student by id

    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);//post student //input AddStudentRequestDto take in iput
    void deletestudentbyid(long id);//for delete

    StudentDto updateStudent(long id,AddStudentRequestDto addStudentRequestDto);//for Put

    StudentDto updatePartialInfo(long id, Map<String,Object> update);
}
