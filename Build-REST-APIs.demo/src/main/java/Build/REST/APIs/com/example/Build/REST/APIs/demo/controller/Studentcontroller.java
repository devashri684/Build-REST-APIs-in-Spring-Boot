package Build.REST.APIs.com.example.Build.REST.APIs.demo.controller;


//IN controller layer only use DTO and Service layer
import Build.REST.APIs.com.example.Build.REST.APIs.demo.dto.AddStudentRequestDto;
import Build.REST.APIs.com.example.Build.REST.APIs.demo.dto.StudentDto;
//import Build.REST.APIs.com.example.Build.REST.APIs.demo.entity.Student;
//import Build.REST.APIs.com.example.Build.REST.APIs.demo.repository.StudentRepository;
import Build.REST.APIs.com.example.Build.REST.APIs.demo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController //studentcontrolller bean is mange by spring boot now
@RequestMapping("/api/student")// so that no need @GetMapping("/student"),@GetMapping("/student/{id}/")
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

    public Studentcontroller(StudentService studentService) {
        this.studentService = studentService;
    }

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
     @GetMapping("/{id}/")
     public ResponseEntity<StudentDto> getStudentbyId(@PathVariable long id) {
//        public StudentDto getStudentbyId(@PathVariable("id") long Studentid){
      return ResponseEntity.ok(studentService.getStudentbyId(id));
     }


    @PostMapping
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody @Valid AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDto));
    }
    //@Valid use to check validation that we have given in AddStudentRequestDto for taking input info for addStudent
    //write first if valid input then enter into controller


//    (studentService.createNewStudent(addStudentRequestDto) in studentService, createNewStudent is method that take input addStudentRequestDto


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletestudentbyid(@PathVariable long id){
        studentService.deletestudentbyid(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable long id,
                                                    @RequestBody AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.ok(studentService.updateStudent(id,addStudentRequestDto));
    }



    //used to update partial info
    //we can different endpoints like to update mail endpoint, to update email endpoint to update different field or
    //we can make only one
    @PatchMapping("/{id}")
    public ResponseEntity<StudentDto> updatePartialInfo(@PathVariable long id,@RequestBody Map<String, Object> update){
        return  ResponseEntity.ok(studentService.updatePartialInfo(id, update));
    }
}