package pe.edu.uni.autoventas.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.edu.uni.autoventas.db.AccesoDB;
import pe.edu.uni.autoventas.model.ProgramacionModel;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class ProgramacionService {

	public void programar(ProgramacionModel bean) {
		// Variables
		Connection cn = null;
		String sql;
		PreparedStatement pstm;
		ResultSet rs;
		// Proceso principal
		try {
			// La conexión
			cn = AccesoDB.getConnection();
			cn.setAutoCommit(false);
			// Obtener precios
			sql = "select piso1precio1, piso1precio2, piso2precio1, piso2precio2 "
					  + "from RUTA where idruta=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, bean.getIdruta());
			rs = pstm.executeQuery();
			if (!rs.next()) {
				throw new SQLException("No se encontro la ruta.");
			}
			bean.setPiso1precio1(rs.getDouble("piso1precio1"));
			bean.setPiso1precio2(rs.getDouble("piso1precio2"));
			bean.setPiso2precio1(rs.getDouble("piso2precio1"));
			bean.setPiso2precio2(rs.getDouble("piso2precio2"));
			rs.close();
			pstm.close();
			// Obtener capacidad
			sql = "select piso1asientosprecio1,piso1asientosprecio2,piso2asientosprecio1, "
					  + "piso2asientosprecio2 from bus where idbus=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, bean.getIdbus());
			rs = pstm.executeQuery();
			if (!rs.next()) {
				throw new SQLException("No se encontro el bus.");
			}
			bean.setPiso1asientosprecio1(rs.getInt("piso1asientosprecio1"));
			bean.setPiso1asientosprecio2(rs.getInt("piso1asientosprecio2"));
			bean.setPiso2asientosprecio1(rs.getInt("piso2asientosprecio1"));
			bean.setPiso2asientosprecio2(rs.getInt("piso2asientosprecio2"));
			rs.close();
			pstm.close();
			// Insertar registro
			sql = "insert into programacion(idruta,idbus,idempleado,fechasalida,horasalida,"
					  + "fechallegada,horallegada,piso1precio1,piso1precio2,piso2precio1,piso2precio2,"
					  + "piso1asientosprecio1,piso1asientosprecio2,piso2asientosprecio1,piso2asientosprecio2) "
					  + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, bean.getIdruta());
			pstm.setInt(2, bean.getIdbus());
			pstm.setInt(3, bean.getIdempleado());
			pstm.setDate(4, UtilService.utilDateToSqlDate(bean.getFechasalida()));
			pstm.setString(5, bean.getHorasalida());
			pstm.setDate(6, UtilService.utilDateToSqlDate(bean.getFechallegada()));
			pstm.setString(7, bean.getHorallegada());
			pstm.setDouble(8, bean.getPiso1precio1());
			pstm.setDouble(9, bean.getPiso1precio2());
			pstm.setDouble(10, bean.getPiso2precio2());
			pstm.setDouble(11, bean.getPiso2precio2());
			pstm.setInt(12, bean.getPiso1asientosprecio1());
			pstm.setInt(13, bean.getPiso1asientosprecio2());
			pstm.setInt(14, bean.getPiso2asientosprecio1());
			pstm.setInt(15, bean.getPiso2asientosprecio2());
			pstm.executeUpdate();
			// Terminar TX
			cn.commit();
		} catch (SQLException e) {
			try {
				cn.close();
			} catch (Exception e1) {
			}
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			try {
				cn.close();
			} catch (Exception e1) {
			}
			e.printStackTrace();
			throw new RuntimeException("Error en el proceso.");
		} finally {
			try {
				cn.rollback();
			} catch (Exception e) {
			}
		}
	}
}
