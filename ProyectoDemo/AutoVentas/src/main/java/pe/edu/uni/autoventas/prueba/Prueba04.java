package pe.edu.uni.autoventas.prueba;

import java.util.List;
import pe.edu.uni.autoventas.model.EmpleadoModel;
import pe.edu.uni.autoventas.service.EmpleadoCrudImpl;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class Prueba04 {

    public static void main(String[] args) {
		 try {
			 // Datos
			 EmpleadoModel model = new EmpleadoModel();
			 model.setApellido("t");
			 model.setDni("82");
			 // Proceso
			 EmpleadoCrudImpl crud = new EmpleadoCrudImpl();
			 List<EmpleadoModel> lista = crud.read(model);
			 // Reporte
			 for (EmpleadoModel bean : lista) {
				 System.out.println(bean.getNombre() + " - " + bean.getApellido());
			 }
		 } catch (Exception e) {
			 System.err.println(e.getMessage());
		 }
    }

}
