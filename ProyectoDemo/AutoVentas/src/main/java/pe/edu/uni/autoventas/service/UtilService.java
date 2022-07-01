package pe.edu.uni.autoventas.service;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public final class UtilService {

	private UtilService() {
	}

	public static String ifnull(String dato){
		if(dato==null){
			dato = "";
		}
		return dato.trim();
	}
	
	public static String ifnull(String dato, String nuevoDato){
		if(dato==null){
			dato = nuevoDato;
		}
		return dato.trim();
	}
	
}
