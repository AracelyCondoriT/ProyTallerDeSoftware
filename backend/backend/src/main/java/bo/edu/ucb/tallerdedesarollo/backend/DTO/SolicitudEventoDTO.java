package bo.edu.ucb.tallerdedesarollo.backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SolicitudEventoDTO {
    private long solicitudid;
    private long usuarios_userid;
    private String descripcion;
    private long estado;
    private long evento_publicacion_ep_id;


}
