package Build.REST.APIs.com.example.Build.REST.APIs.demo.controller;


//IN controller layer only use DTO and Service layer
import Build.REST.APIs.com.example.Build.REST.APIs.demo.dto.StudentDto;
//import Build.REST.APIs.com.example.Build.REST.APIs.demo.entity.Student;
//import Build.REST.APIs.com.example.Build.REST.APIs.demo.repository.StudentRepository;
import Build.REST.APIs.com.example.Build.REST.APIs.demo.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //studentcontrolller bean is mange by spring boot now
public class Studentcontroller {

    //get api using repository layer
// private StudentRepository
//    // bean of studentrepository studentRepository
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
    @GetMapping("/student")
    public List<StudentDto> getStudent(){
        return studentService.getAllStudents();
    }

//
//    @GetMapping("/student/{id}")
//    public StudentDto getStudentbyId(){
//        return new StudentDto(1,"Devashri","Abc@gaim.com"); //@AllArgsConstructor from Studentdto
//    }


    @GetMapping("/student/{id}/{name}")
    public String getStudentbyId(@PathVariable long id,@PathVariable String name){
//        public StudentDto getStudentbyId(@PathVariable("id") long Studentid){
        return "Path variable" +id + "name is "+name;
    }
    @GetMapping("/student/{id}/")
    public StudentDto getStudentbyId(@PathVariable long id){
//        public StudentDto getStudentbyId(@PathVariable("id") long Studentid){
        return studentService.getStudentbyId(id);
    }

}
