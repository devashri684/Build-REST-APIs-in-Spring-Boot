package Build.REST.APIs.com.example.Build.REST.APIs.demo.controller;


//IN controller layer only use DTO and Service layer
import Build.REST.APIs.com.example.Build.REST.APIs.demo.dto.AddStudentRequestDto;
import Build.REST.APIs.com.example.Build.REST.APIs.demo.dto.StudentDto;
//import Build.REST.APIs.com.example.Build.REST.APIs.demo.entity.Student;
//import Build.REST.APIs.com.example.Build.REST.APIs.demo.repository.StudentRepository;
import Build.REST.APIs.com.example.Build.REST.APIs.demo.service.StudentService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //studentcontrolller bean is mange by spring boot now
@RequestMapping("/student")// so that no need @GetMapping("/student"),@GetMapping("/student/{id}/")
public class Studentcontroller {

    //get api using repository layer
// private StudentRepository
//    // bean of studentrepository studentRepository;
//    public Studentcontroller(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }
//    @GetMapping("/student")
//    public List<Student> getStudent(){
//        return studentRepository.findAll();//jpareposotiry having findall() method which is implents by studentrepostory
//        //soo we are getting all student by findall() beacause of repository layer
//    }
    //------get api repositiry layer finish-----

    //**** must prefer use DTO and service instead of repository and entity in controller layer**
    //so
    //below I use dto and service
    private StudentService studentService;

    @GetMapping()
    public List<StudentDto> getStudent(){
        return studentService.getAllStudents();
    }

//
//    @GetMapping("/student/{id}")
//    public StudentDto getStudentbyId(){
//        return new StudentDto(1,"Devashri","Abc@gaim.com"); //@AllArgsConstructor from Studentdto
//    }


    @GetMapping("/{id}/{name}")
    public String getStudentbyId(@PathVariable long id,@PathVariable String name){
//        public StudentDto getStudentbyId(@PathVariable("id") long Studentid){
        return "Path variable" +id + "name is "+name;
    }
//    @GetMapping("/student/{id}/")
//    public StudentDto getStudentbyId(@PathVariable long id){
////        public StudentDto getStudentbyId(@PathVariable("id") long Studentid){
//        return studentService.getStudentbyId(id);
//    }
     @GetMapping("/student/{id}/")
     public ResponseEntity<StudentDto> getStudentbyId(@PathVariable long id) {
//        public StudentDto getStudentbyId(@PathVariable("id") long Studentid){
      return ResponseEntity.ok(studentService.getStudentbyId(id));
     }


    @PostMapping()
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDto));
    }


//    (studentService.createNewStudent(addStudentRequestDto) in studentService, createNewStudent is method that take input addStudentRequestDto
}
