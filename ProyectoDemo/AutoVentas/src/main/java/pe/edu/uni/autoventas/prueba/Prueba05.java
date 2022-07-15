package pe.edu.uni.autoventas.prueba;

import java.util.List;
import pe.edu.uni.autoventas.model.EmpleadoModel;
import pe.edu.uni.autoventas.model.ProgramacionModel;
import pe.edu.uni.autoventas.service.EmpleadoCrudImpl;
import pe.edu.uni.autoventas.service.ProgramacionService;
import pe.edu.uni.autoventas.service.UtilService;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class Prueba05 {

    public static void main(String[] args) {
		 try {
			 // Dat;os
			 ProgramacionModel bean = new ProgramacionModel();
			 bean.setIdruta(1);
			 bean.setIdbus(1);
			 bean.setIdempleado(1);
			 bean.setFechasalida(UtilService.stringToUtilDate("18/07/2022"));
			 bean.setHorasalida("17:30");
			 bean.setFechallegada(UtilService.stringToUtilDate("19/07/2022"));
			 bean.setHorallegada("06:30");
			 // Proceso
			 ProgramacionService service = new ProgramacionService();
			 service.programar(bean);
			 // Reporte
			 System.out.println("Proceso ok.");
		 } catch (Exception e) {
			 System.err.println(e.getMessage());
		 }
    }

}
