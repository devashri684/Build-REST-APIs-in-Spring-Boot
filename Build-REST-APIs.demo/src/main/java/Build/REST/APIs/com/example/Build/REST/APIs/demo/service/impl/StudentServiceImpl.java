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
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudents() {
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
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with id" + id));
//        StudentDto studentDto = modelMapper.map(student,StudentDto.class);
//        return studentDto;                      //second way to convert studeo into studnetDTO by modelmapper dependency
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto, Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deletestudentbyid(long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("Student does not exit with id" + id);  //if not exist
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(long id, AddStudentRequestDto addStudentRequestDto) {
        Student student = studentRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Student not found with id" + id));//check if studnet is there
        modelMapper.map(addStudentRequestDto,student); //change student info
        student.setName(addStudentRequestDto.getName());
        student.setEmail(addStudentRequestDto.getEmail());
        student=studentRepository.save(student);//save new student

        return modelMapper.map(student, StudentDto.class);//replace and return new student
    }

    @Override
    public StudentDto updatePartialInfo(long id, Map<String, Object> update) {
        Student student = studentRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Student not found with id" + id));
        update.forEach((field,value) ->{
            switch (field){
                case "name":
                        student.setName((String) value);
                        break;
                case "email":
                       student.setEmail((String) value);
                       break;
                default:
                    throw new IllegalArgumentException("Field is not Supported");
            }
        });
        Student savedstudent=studentRepository.save(student);
        return modelMapper.map(savedstudent,StudentDto.class);
    }


}
//👉 .map() → converts Entity → DTO
//👉 .toList() → collects result into list
//this code converts Entity to DTO using Java Streams map() function,
// where each Student entity is transformed into a StudentDto object.”