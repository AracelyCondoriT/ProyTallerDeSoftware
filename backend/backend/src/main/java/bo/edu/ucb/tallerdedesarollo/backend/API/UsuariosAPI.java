package bo.edu.ucb.tallerdedesarollo.backend.API;

import bo.edu.ucb.tallerdedesarollo.backend.DTO.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Arrays;
import java.util.List;

import bo.edu.ucb.tallerdedesarollo.backend.BL.UsuariosBL;

@RestController()
@CrossOrigin(origins = "*")
@RequestMapping("/v1/usuarios")
public class UsuariosAPI {

    Logger LOGGER = LoggerFactory.getLogger(InteresesAPI.class);
    private UsuariosBL usuariosBL;

    @Autowired
    public UsuariosAPI(UsuariosBL usuariosBL) {
        this.usuariosBL = usuariosBL;
    }

    @GetMapping(path = "", produces = APPLICATION_JSON_VALUE)
    public List<UsuariosDTO> getUsuarios() {
        return usuariosBL.getUsuarios();
    }

    @PostMapping(path = "/create", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public UsuariosSignInDTO create(@RequestBody UsuariosSignInDTO usuario) {
       usuariosBL.saveUsuario(usuario);
       return usuario;
    }

    @PostMapping(path = "/asignar-interes", consumes = APPLICATION_JSON_VALUE)
    public void asignarInteresUsuario(@RequestBody AsignarInteresUsuarioDTO asignarInteresUsuarioDTO) {
        usuariosBL.asignarInteresUsuario(asignarInteresUsuarioDTO);
    }

    @GetMapping("/subintereses/{usuarioId}")
    public ResponseEntity<List<SubInteres>> obtenerSubInteresesPorUsuarioId(@PathVariable Integer usuarioId) {
        List<SubInteres> subIntereses = usuariosBL.obtenerSubInteresesPorUsuarioId(usuarioId);
        return new ResponseEntity<List<SubInteres>>(subIntereses, HttpStatus.OK);
    }

    @PostMapping(path = "/profile", consumes = APPLICATION_JSON_VALUE)
    public void userporfile(@RequestBody UserProfileDTO userProfileDTO) {
        //usuariosBL.asignarInteresUsuario(asignarInteresUsuarioDTO);
    }




}
