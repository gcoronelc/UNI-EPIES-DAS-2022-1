package pe.edu.uni.autoventas.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.edu.uni.autoventas.db.AccesoDB;
import pe.edu.uni.autoventas.model.EmpleadoModel;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class LogueoService {
	
	public EmpleadoModel validar(String usuario, String clave){
		EmpleadoModel empleadoModel = null;
		String query = "select IDEMPLEADO, NOMBRE, APELLIDO, DNI, "
				  + "TELEFONO, CORREO, IDROL, USUARIO, '******' CLAVE "
				  + "from empleado "
				  + "where usuario=? and clave=?";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Connection cn = null;
		try {
			cn = AccesoDB.getConnection();
			pstm = cn.prepareStatement(query);
			pstm.setString(1, usuario);
			pstm.setString(2, clave);
			rs = pstm.executeQuery();
			if (rs.next()) {
				empleadoModel = new EmpleadoModel();
				empleadoModel.setId(rs.getInt("IDEMPLEADO"));
				empleadoModel.setNombre(rs.getString("NOMBRE"));
				empleadoModel.setApellido(rs.getString("APELLIDO"));
				empleadoModel.setDni(rs.getString("DNI"));
				empleadoModel.setTelefono(rs.getString("TELEFONO"));
				empleadoModel.setCorreo(rs.getString("CORREO"));
				empleadoModel.setRol(rs.getInt("IDROL"));
				empleadoModel.setUsuario(rs.getString("USUARIO"));
				empleadoModel.setClave(rs.getString("CLAVE"));
			}
			rs.close();
			pstm.close();
			if (empleadoModel == null) {
				throw new SQLException("Datos incorrectos.");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException("Error en el proceso, intenteo de nuevo.");
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return empleadoModel;
	}

}
