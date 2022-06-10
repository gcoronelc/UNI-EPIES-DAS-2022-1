package pe.edu.uni.autoventas.prueba;

import java.sql.Connection;
import pe.edu.uni.autoventas.db.AccesoDB;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class Prueba01 {
	
	public static void main(String[] args) {
		try {
			Connection cn = AccesoDB.getConnection();
			System.out.println("Bien.");
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
