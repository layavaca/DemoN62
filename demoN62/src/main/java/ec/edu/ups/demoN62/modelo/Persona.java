package ec.edu.ups.demoN62.modelo;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Persona implements Serializable {

	
	@Id
//	@GeneratedValue
	//private int idPer;
	private String cedulaPer;
	private String nombrePer;	
	private String direccionPer;
	
	
	
	/*public int getIdPer() {
		return idPer;
	}
	public void setIdPer(int idPer) {
		this.idPer = idPer;
	}*/
	public String getNombrePer() {
		return nombrePer;
	}
	public void setNombrePer(String nombrePer) {
		this.nombrePer = nombrePer;
	}
	public String getCedulaPer() {
		return cedulaPer;
	}
	public void setCedulaPer(String cedulaPer) {
		this.cedulaPer = cedulaPer;
	}
	public String getDireccionPer() {
		return direccionPer;
	}
	public void setDireccionPer(String direccionPer) {
		this.direccionPer = direccionPer;
	}
	@Override
	public String toString() {
		return "Persona [nombrePer=" + nombrePer + ", cedulaPer=" + cedulaPer + ", direccionPer=" + direccionPer + "]";
	}
	
	
	
}
