package Build.REST.APIs.com.example.Build.REST.APIs.demo.service.impl;

import Build.REST.APIs.com.example.Build.REST.APIs.demo.dto.AddStudentRequestDto;
import Build.REST.APIs.com.example.Build.REST.APIs.demo.dto.StudentDto;
import Build.REST.APIs.com.example.Build.REST.APIs.demo.entity.Student;
import Build.REST.APIs.com.example.Build.REST.APIs.demo.repository.StudentRepository;
import Build.REST.APIs.com.example.Build.REST.APIs.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private  StudentService studentService;
    private StudentRepository studentRepository;
    private ModelMapper modelMapper;

    public StudentServiceImpl(StudentService studentService) {   //use @RequiredArgsConstructor @RequiredArgsConstructor is a Lombok annotation
        // that automatically creates a constructor for required fields.
        //Used for constructor-based dependency injection (best practice)
        this.studentService = studentService;
    }

    @Override
    public  List<StudentDto> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(student -> new StudentDto(
                        student.getId(),
                        student.getName(),          //first way to convert student into stidentDTO
                        student.getEmail()))
                .toList();
    }

    @Override
    public StudentDto getStudentbyId(long id) {   //implimentede getStudentbyId othervise show eroor
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with id"+id));
//        StudentDto studentDto = modelMapper.map(student,StudentDto.class);
//        return studentDto;                      //second way to convert studeo into studnetDTO by modelmapper dependency
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent =modelMapper.map(addStudentRequestDto,Student.class);
        Student student= studentRepository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }

}
//👉 .map() → converts Entity → DTO
//👉 .toList() → collects result into list
//this code converts Entity to DTO using Java Streams map() function,
// where each Student entity is transformed into a StudentDto object.”