package bo.edu.ucb.tallerdedesarollo.backend.DAO;

import bo.edu.ucb.tallerdedesarollo.backend.DTO.SubInteres;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InteresesUsuarioDAO {

    @Insert("INSERT INTO interesesusuario(usuarios_userid, sub_intereses_id_subinteres) VALUES (#{usuarioId}, #{subInteresId})")
    public void asignarInteresUsuario(@Param("usuarioId") Integer usuarioId, @Param("subInteresId") Integer subInteresId);

    @Select("SELECT s.id_subinteres, s.nombre FROM sub_intereses s JOIN interesesusuario i ON s.id_subinteres = i.sub_intereses_id_subinteres WHERE i.usuarios_userid = #{usuarioId}")
    List<SubInteres> obtenerSubInteresesPorUsuarioId(Integer usuarioId);





}