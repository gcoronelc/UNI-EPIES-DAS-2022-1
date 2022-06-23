package pe.edu.uni.autoventas.prueba;

import pe.edu.uni.autoventas.model.EmpleadoModel;
import pe.edu.uni.autoventas.service.LogueoService;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class Prueba02 {

    public static void main(String[] args) {
		 try {
			 // Datos
			 String usuario = "pcastro";
			 String clave = "cazador";
			 // Proceso
			 LogueoService service = new LogueoService();
			 EmpleadoModel model = service.validar(usuario, clave);			 
			 // Reporte
			 System.out.println("Hola " + model.getNombre());
		 } catch (Exception e) {
			 System.err.println(e.getMessage());
		 }
    }

}
