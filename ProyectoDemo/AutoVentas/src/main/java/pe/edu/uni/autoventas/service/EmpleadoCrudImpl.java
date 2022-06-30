package pe.edu.uni.autoventas.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class EmpleadoCrudImpl implements CrudSpec<EmpleadoModel> {
	
	private final String SELECT_BASE = "SELECT IDEMPLEADO, NOMBRE, APELLIDO, DNI,"
			  + " TELEFONO, CORREO, IDROL, USUARIO, '*****' CLAVE " 
			  + "FROM EMPLEADO ";

	@Override
	public List<EmpleadoModel> readAll() {
		// Variables
		List<EmpleadoModel> lista = new ArrayList<>();
		Connection cn = null;
		try {
			// Acceso a la base de datos
			cn = AccesoDB.getConnection();
			// Preparando ejecutando el objeto PreparedStatement
			PreparedStatement pstm = cn.prepareStatement(SELECT_BASE);
			ResultSet rs = pstm.executeQuery();
			// Pasar el REsultSet a la lista
			while(rs.next()){
				EmpleadoModel bean = new EmpleadoModel();
				bean.setId(rs.getInt("IDEMPLEADO"));
				bean.setNombre(rs.getString("NOMBRE"));
				bean.setApellido(rs.getString("APELLIDO"));
				bean.setDni(rs.getString("DNI"));
				bean.setTelefono(rs.getString("TELEFONO"));
				bean.setCorreo(rs.getString("CORREO"));
				bean.setRol(rs.getInt("IDROL"));
				bean.setUsuario(rs.getString("USUARIO"));
				bean.setClave(rs.getString("CLAVE"));
				lista.add(bean);
			}
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			throw  new RuntimeException("Error en el proceso, intentelo mas tarde.");
		} finally{
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return lista;
	}

	@Override
	public EmpleadoModel readForId(int id) {
		// Variables
		EmpleadoModel bean = null;
		Connection cn = null;
		try {
			// Acceso a la base de datos
			cn = AccesoDB.getConnection();
			// Preparando ejecutando el objeto PreparedStatement
			String sql = SELECT_BASE + " WHERE IDEMPLEADO=?";
			PreparedStatement pstm = cn.prepareStatement(SELECT_BASE);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			// Pasar el REsultSet a la lista
			if(rs.next()){
				bean = new EmpleadoModel();
				bean.setId(rs.getInt("IDEMPLEADO"));
				bean.setNombre(rs.getString("NOMBRE"));
				bean.setApellido(rs.getString("APELLIDO"));
				bean.setDni(rs.getString("DNI"));
				bean.setTelefono(rs.getString("TELEFONO"));
				bean.setCorreo(rs.getString("CORREO"));
				bean.setRol(rs.getInt("IDROL"));
				bean.setUsuario(rs.getString("USUARIO"));
				bean.setClave(rs.getString("CLAVE"));
			}
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			throw  new RuntimeException("Error en el proceso, intentelo mas tarde.");
		} finally{
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return bean;
	}

	@Override
	public List<EmpleadoModel> read(EmpleadoModel bean) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void insert(EmpleadoModel bean) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void update(EmpleadoModel bean) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void delete(int id) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
