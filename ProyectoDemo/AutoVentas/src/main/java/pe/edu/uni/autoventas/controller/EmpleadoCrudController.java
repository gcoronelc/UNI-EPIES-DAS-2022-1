package pe.edu.uni.autoventas.controller;

import java.util.List;
import pe.edu.uni.autoventas.model.EmpleadoModel;
import pe.edu.uni.autoventas.service.CrudSpec;
import pe.edu.uni.autoventas.service.EmpleadoCrudImpl;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class EmpleadoCrudController {
	
	private CrudSpec<EmpleadoModel> service;

	public EmpleadoCrudController() {
		service = new EmpleadoCrudImpl();
	}
	
	public List<EmpleadoModel> read(EmpleadoModel bean) {
		return service.read(bean);
	}
	
	public void insert(EmpleadoModel bean){
		service.insert(bean);
	}
	
}
