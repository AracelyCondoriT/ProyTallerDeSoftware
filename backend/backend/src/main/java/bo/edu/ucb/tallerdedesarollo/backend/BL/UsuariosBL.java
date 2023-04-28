package bo.edu.ucb.tallerdedesarollo.backend.BL;

import java.util.List;
import java.util.stream.Collectors;

import bo.edu.ucb.tallerdedesarollo.backend.DAO.InteresesUsuarioDAO;
import bo.edu.ucb.tallerdedesarollo.backend.DTO.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.edu.ucb.tallerdedesarollo.backend.DAO.UsuarioDAO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
public class UsuariosBL {
    
    Logger LOOGER = LoggerFactory.getLogger(InteresesBL.class);
    private UsuarioDAO usuarioDAO;
    private InteresesUsuarioDAO interesesUsuarioDAO;

    @Autowired
    public UsuariosBL(UsuarioDAO usuarioDAO,InteresesUsuarioDAO interesesUsuarioDAO) {
        this.usuarioDAO = usuarioDAO;
        this.interesesUsuarioDAO = interesesUsuarioDAO;
    }

    public List<UsuariosDTO> getUsuarios() {
        return this.usuarioDAO.findAll();
    }

    public InteresesUsuarioDTO saveInteresesUsuario(Integer usuario_id, Integer subInteres_id) {
        return this.usuarioDAO.saveInteresesUsuario(usuario_id, subInteres_id);
    }

    public UsuariosSignInDTO saveUsuario(UsuariosSignInDTO usuario) {
        this.usuarioDAO.saveUsuario(usuario.getGoogleid(), 1, usuario.getFamily_name(), usuario.getGiven_name(), usuario.getHd(), usuario.getEmail());
        return usuario;
    }

    public void asignarInteresUsuario(AsignarInteresUsuarioDTO asignarInteresUsuarioDTO) {
        Integer usuarioId = asignarInteresUsuarioDTO.getUsuarioId();
        List<Integer> subInteresIds = asignarInteresUsuarioDTO.getSubInteresId();
        for (Integer subInteresId : subInteresIds) {
            InteresesUsuarioDTO interesesUsuarioDTO = new InteresesUsuarioDTO();
            interesesUsuarioDTO.setUsuarios_userId(usuarioId);
            interesesUsuarioDTO.setSub_intereses_id_subinteres(subInteresId);
            this.interesesUsuarioDAO.asignarInteresUsuario(interesesUsuarioDTO.getUsuarios_userId(), interesesUsuarioDTO.getSub_intereses_id_subinteres());
        }
    }

    public List<SubInteres> obtenerSubInteresesPorUsuarioId(Integer usuarioId) {
        return interesesUsuarioDAO.obtenerSubInteresesPorUsuarioId(usuarioId);
    }




}
