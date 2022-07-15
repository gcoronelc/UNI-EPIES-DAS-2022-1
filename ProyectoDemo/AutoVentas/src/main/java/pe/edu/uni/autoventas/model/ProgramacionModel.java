package pe.edu.uni.autoventas.model;

import java.util.Date;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class ProgramacionModel {

	private Integer idprogramacion;
	private Integer idruta;
	private Integer idbus;
	private Integer idempleado;
	private Date fechasalida;
	private String horasalida;
	private Date fechallegada;
	private String horallegada;
	private Double piso1precio1;
	private Double piso1precio2;
	private Double piso2precio1;
	private Double piso2precio2;
	private Integer piso1asientosprecio1;
	private Integer piso1asientosprecio2;
	private Integer piso2asientosprecio1;
	private Integer piso2asientosprecio2;

	public ProgramacionModel() {
	}

	public Integer getIdprogramacion() {
		return idprogramacion;
	}

	public void setIdprogramacion(Integer idprogramacion) {
		this.idprogramacion = idprogramacion;
	}

	public Integer getIdruta() {
		return idruta;
	}

	public void setIdruta(Integer idruta) {
		this.idruta = idruta;
	}

	public Integer getIdbus() {
		return idbus;
	}

	public void setIdbus(Integer idbus) {
		this.idbus = idbus;
	}

	public Integer getIdempleado() {
		return idempleado;
	}

	public void setIdempleado(Integer idempleado) {
		this.idempleado = idempleado;
	}

	public Date getFechasalida() {
		return fechasalida;
	}

	public void setFechasalida(Date fechasalida) {
		this.fechasalida = fechasalida;
	}

	public String getHorasalida() {
		return horasalida;
	}

	public void setHorasalida(String horasalida) {
		this.horasalida = horasalida;
	}

	public Date getFechallegada() {
		return fechallegada;
	}

	public void setFechallegada(Date fechallegada) {
		this.fechallegada = fechallegada;
	}

	public String getHorallegada() {
		return horallegada;
	}

	public void setHorallegada(String horallegada) {
		this.horallegada = horallegada;
	}

	public Double getPiso1precio1() {
		return piso1precio1;
	}

	public void setPiso1precio1(Double piso1precio1) {
		this.piso1precio1 = piso1precio1;
	}

	public Double getPiso1precio2() {
		return piso1precio2;
	}

	public void setPiso1precio2(Double piso1precio2) {
		this.piso1precio2 = piso1precio2;
	}

	public Double getPiso2precio1() {
		return piso2precio1;
	}

	public void setPiso2precio1(Double piso2precio1) {
		this.piso2precio1 = piso2precio1;
	}

	public Double getPiso2precio2() {
		return piso2precio2;
	}

	public void setPiso2precio2(Double piso2precio2) {
		this.piso2precio2 = piso2precio2;
	}

	public Integer getPiso1asientosprecio1() {
		return piso1asientosprecio1;
	}

	public void setPiso1asientosprecio1(Integer piso1asientosprecio1) {
		this.piso1asientosprecio1 = piso1asientosprecio1;
	}

	public Integer getPiso1asientosprecio2() {
		return piso1asientosprecio2;
	}

	public void setPiso1asientosprecio2(Integer piso1asientosprecio2) {
		this.piso1asientosprecio2 = piso1asientosprecio2;
	}



	public Integer getPiso2asientosprecio1() {
		return piso2asientosprecio1;
	}

	public void setPiso2asientosprecio1(Integer piso2asientosprecio1) {
		this.piso2asientosprecio1 = piso2asientosprecio1;
	}

	public Integer getPiso2asientosprecio2() {
		return piso2asientosprecio2;
	}

	public void setPiso2asientosprecio2(Integer piso2asientosprecio2) {
		this.piso2asientosprecio2 = piso2asientosprecio2;
	}


}
