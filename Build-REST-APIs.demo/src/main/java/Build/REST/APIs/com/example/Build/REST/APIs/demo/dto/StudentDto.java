package Build.REST.APIs.com.example.Build.REST.APIs.demo.dto;
//“DTO is a class used to transfer only required data between client and server
// without exposing the full entity.”
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class StudentDto {
    private long id;
    private String name;
    private String email;

    //No need to make gettes setters and construotor justtt use @Data annotaion

//    public StudentDto(String name, String email,long id) {
//        this.id=id;
//        this.name = name;
//        this.email = email;        //@AllArgsConstructor annotaion used
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
}
