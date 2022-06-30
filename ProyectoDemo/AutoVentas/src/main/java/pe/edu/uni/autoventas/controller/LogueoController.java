package pe.edu.uni.autoventas.controller;

import pe.edu.uni.autoventas.model.EmpleadoModel;
import pe.edu.uni.autoventas.service.LogueoService;
import pe.edu.uni.autoventas.util.Session;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class LogueoController {

	public void validar(String usuario, String clave) {
		LogueoService service = new LogueoService();
		EmpleadoModel empleado = service.validar(usuario, clave);
		Session.put("USUARIO", empleado);
	}

}
