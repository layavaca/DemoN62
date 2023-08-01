package ec.edu.ups.demoN62.modelo;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Vehiculo implements Serializable  {
	
	@Id
	@GeneratedValue
	private int idVeh;
	private String placaVeh;
	private String modeloVeh;
	/*@OneToOne
	@JoinColumn(name="idCedula")
	private Persona persona;
	*/
	public int getIdVeh() {
		return idVeh;
	}
	public void setIdVeh(int idVeh) {
		this.idVeh = idVeh;
	}
	public String getPlacaVeh() {
		return placaVeh;
	}
	public void setPlacaVeh(String placaVeh) {
		this.placaVeh = placaVeh;
	}
	public String getModeloVeh() {
		return modeloVeh;
	}
	public void setModeloVeh(String modeloVeh) {
		this.modeloVeh = modeloVeh;
	}
	
	@Override
	public String toString() {
		return "Vehiculo [idVeh=" + idVeh + ", placaVeh=" + placaVeh + ", modeloVeh=" + modeloVeh +  "]";
	}
	
	
}
