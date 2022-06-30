package pe.edu.uni.autoventas.prueba;

import java.util.List;
import pe.edu.uni.autoventas.model.EmpleadoModel;
import pe.edu.uni.autoventas.service.EmpleadoCrudImpl;
import pe.edu.uni.autoventas.service.LogueoService;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class Prueba03 {

    public static void main(String[] args) {
		 try {
			 // Proceso
			 EmpleadoCrudImpl crud = new EmpleadoCrudImpl();
			 List<EmpleadoModel> lista = crud.readAll();
			 // Reporte
			 for (EmpleadoModel bean : lista) {
				 System.out.println(bean.getNombre() + " - " + bean.getApellido());
			 }
		 } catch (Exception e) {
			 System.err.println(e.getMessage());
		 }
    }

}
