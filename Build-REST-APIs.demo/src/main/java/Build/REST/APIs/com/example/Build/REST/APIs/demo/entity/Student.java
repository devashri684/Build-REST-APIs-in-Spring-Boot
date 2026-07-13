package Build.REST.APIs.com.example.Build.REST.APIs.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

//@Entity comes from Spring data jpa dependency
@Entity // it Createe table in mysqldatabase with the name Student
@Getter    //getter and setter so that name and email can update
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

}
