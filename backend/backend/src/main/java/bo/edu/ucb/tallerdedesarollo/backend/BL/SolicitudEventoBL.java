package bo.edu.ucb.tallerdedesarollo.backend.BL;

import bo.edu.ucb.tallerdedesarollo.backend.DAO.SolicitudEventoDAO;
import bo.edu.ucb.tallerdedesarollo.backend.DTO.SolicitudEventoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudEventoBL {
    private SolicitudEventoDAO solicitudEventoDAO;

    @Autowired

    public SolicitudEventoBL(SolicitudEventoDAO solicitudEventoDAO) {
        this.solicitudEventoDAO = solicitudEventoDAO;
    }

    public List<SolicitudEventoDTO> getAll(){
        return solicitudEventoDAO.findAll();
    }

    public void nuevaSol(SolicitudEventoDTO solicitudEventoDTO){
        Integer test = (int) (Math.random()*100);
        solicitudEventoDAO.newSol(test,(int)solicitudEventoDTO.getUsuarios_userid(),solicitudEventoDTO.getDescripcion(),(int)solicitudEventoDTO.getEstado(),(int)solicitudEventoDTO.getEvento_publicacion_ep_id());
    }
}
