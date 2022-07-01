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
public class EmpleadoCrudImpl implements CrudSpec<EmpleadoModel>, RowMapper<EmpleadoModel> {

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
			while (rs.next()) {
				EmpleadoModel bean = mapRow(rs);
				lista.add(bean);
			}
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException("Error en el proceso, intentelo mas tarde.");
		} finally {
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
			if (rs.next()) {
				bean = mapRow(rs);
			}
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException("Error en el proceso, intentelo mas tarde.");
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return bean;
	}

	@Override
	public List<EmpleadoModel> read(EmpleadoModel bean) {
		// Variables
		List<EmpleadoModel> lista = new ArrayList<>();
		Connection cn = null;
		try {
			// Preparando los paramétros
			String dni = "%" + UtilService.ifnull(bean.getDni()) + "%";
			String apellido = "%" + UtilService.ifnull(bean.getApellido()) + "%";
			String nombre = "%" + UtilService.ifnull(bean.getNombre()) + "%";
			// Acceso a la base de datos
			cn = AccesoDB.getConnection();
			// Preparando ejecutando el objeto PreparedStatement
			String sql = SELECT_BASE + " WHERE DNI like ? AND APELLIDO LIKE ? AND NOMBRE LIKE ?";
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setString(1, dni);
			pstm.setString(2, apellido);
			pstm.setString(3, nombre);
			ResultSet rs = pstm.executeQuery();
			// Pasar el REsultSet a la lista
			while (rs.next()) {
				EmpleadoModel objeto = mapRow(rs);
				lista.add(objeto);
			}
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException("Error en el proceso, intentelo mas tarde.");
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return lista;
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

	@Override
	public EmpleadoModel mapRow(ResultSet rs) throws SQLException {
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
		return bean;
	}

}
