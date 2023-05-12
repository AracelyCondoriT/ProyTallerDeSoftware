package bo.edu.ucb.tallerdedesarollo.backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileDTO {
    private Integer userId;
    private Integer googleId;
    private Integer usertype;
    private String family_name;
    private String given_name;
    private String hd;
    private String email;
    private String picture;
    private String nickname;
    private Timestamp birthdate;
    private String career;
}
