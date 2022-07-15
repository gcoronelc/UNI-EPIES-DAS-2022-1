package pe.edu.uni.autoventas.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	
	public static java.sql.Date utilDateToSqlDate(java.util.Date utilDate){
		long timeInMilliSeconds = utilDate.getTime();
      java.sql.Date sqlDate = new java.sql.Date(timeInMilliSeconds);
		return sqlDate;
	}
	
	public static java.util.Date stringToUtilDate(String sDate){
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {
			date = formatter.parse(sDate);
		} catch (ParseException ex) {
			Logger.getLogger(UtilService.class.getName()).log(Level.SEVERE, null, ex);
		}
		return date;
	}
}
