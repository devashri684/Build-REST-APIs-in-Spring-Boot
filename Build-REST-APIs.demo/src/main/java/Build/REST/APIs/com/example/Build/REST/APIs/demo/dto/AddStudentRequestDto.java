package Build.REST.APIs.com.example.Build.REST.APIs.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;


@Data
@NoArgsConstructor
public class AddStudentRequestDto {
        @NotBlank(message = "name required")
        @Size(min=3, max = 30, message = "name should be in between 3-30")
        private String name;

        //Request Validation //for that we use validation dependency
        @Email //email should be in email format only
        @NotBlank(message = "Email is required")//if we want to make it compalsary
        private String email;
}
