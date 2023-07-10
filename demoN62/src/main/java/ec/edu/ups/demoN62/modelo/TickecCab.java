package ec.edu.ups.demoN62.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class TickecCab implements Serializable{
	
	@Id
	@GeneratedValue
	private int idTiCab;
	private String nombreTiCab;
	private String fechaTiCab;
	@OneToOne
	@JoinColumn(name="id_veh")
	private Vehiculo vehiculo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_tiCab")
	private List<TickecDet> tickecDet;
	
	public int getIdTiCab() {
		return idTiCab;
	}
	public void setIdTiCab(int idTiCab) {
		this.idTiCab = idTiCab;
	}
	public String getNombreTiCab() {
		return nombreTiCab;
	}
	public void setNombreTiCab(String nombreTiCab) {
		this.nombreTiCab = nombreTiCab;
	}
	public String getFechaTiCab() {
		return fechaTiCab;
	}
	public void setFechaTiCab(String fechaTiCab) {
		this.fechaTiCab = fechaTiCab;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public List<TickecDet> getTickecDet() {
		return tickecDet;
	}
	public void setTickecDet(List<TickecDet> tickecDet) {
		this.tickecDet = tickecDet;
	}
	
	public void addTickecDet(TickecDet tickecDe) {
		if(tickecDet == null) {
			tickecDet = new ArrayList<TickecDet>();
		}
		tickecDet.add(tickecDe);
		
	}
	@Override
	public String toString() {
		return "TickecCab [idTiCab=" + idTiCab + ", nombreTiCab=" + nombreTiCab + ", fechaTiCab=" + fechaTiCab
				+ ", vehiculo=" + vehiculo + ", tickecDet=" + tickecDet + "]";
	}
	
	
	

}
