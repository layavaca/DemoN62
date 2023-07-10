package ec.edu.ups.demoN62.modelo;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class TickecDet implements Serializable{

	@Id
	@GeneratedValue
	private int idTiDet;
	private String entradaTiDet;
	private String salidaTiDet;
	private String lugarTiDet;
	private String disponibleTiDet;
	
	public int getIdTiDet() {
		return idTiDet;
	}
	public void setIdTiDet(int idTiDet) {
		this.idTiDet = idTiDet;
	}
	public String getEntradaTiDet() {
		return entradaTiDet;
	}
	public void setEntradaTiDet(String entradaTiDet) {
		this.entradaTiDet = entradaTiDet;
	}
	public String getSalidaTiDet() {
		return salidaTiDet;
	}
	public void setSalidaTiDet(String salidaTiDet) {
		this.salidaTiDet = salidaTiDet;
	}
	public String getLugarTiDet() {
		return lugarTiDet;
	}
	public void setLugarTiDet(String lugarTiDet) {
		this.lugarTiDet = lugarTiDet;
	}
	public String getDisponibleTiDet() {
		return disponibleTiDet;
	}
	public void setDisponibleTiDet(String disponibleTiDet) {
		this.disponibleTiDet = disponibleTiDet;
	}
	
	@Override
	public String toString() {
		return "TickecDet [idTiDet=" + idTiDet + ", entradaTiDet=" + entradaTiDet + ", salidaTiDet=" + salidaTiDet
				+ ", lugarTiDet=" + lugarTiDet + ", disponibleTiDet=" + disponibleTiDet + "]";
	}	
}
