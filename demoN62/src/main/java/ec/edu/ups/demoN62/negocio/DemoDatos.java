package ec.edu.ups.demoN62.negocio;

import java.util.List;

import ec.edu.ups.demoN62.datos.PersonaDao;
import ec.edu.ups.demoN62.datos.TickecCabDao;
import ec.edu.ups.demoN62.datos.TickecDetDao;
import ec.edu.ups.demoN62.datos.VehiculoDao;
import ec.edu.ups.demoN62.modelo.Persona;
import ec.edu.ups.demoN62.modelo.TickecCab;
import ec.edu.ups.demoN62.modelo.TickecDet;
import ec.edu.ups.demoN62.modelo.Vehiculo;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;


@Singleton
@Startup
public class DemoDatos {

	@Inject
	private PersonaDao daoPersona;
	@Inject
	private VehiculoDao daoVehiculo;
	@Inject
	private TickecCabDao daoTickecCab;
	@Inject
	private TickecDetDao daoTickecDet;
	
	@PostConstruct
	public void init() {
		System.out.println("Hola UPS");
		
		Persona p = new Persona();
		p.setCedulaPer("0103709911");
		p.setDireccionPer("Monay");
		p.setNombrePer("Cristian Timbi");
		
		daoPersona.insert(p);
		
		Persona p1 = new Persona();
		p1.setCedulaPer("0107083511");
		p1.setDireccionPer("san joaquin");
		p1.setNombrePer("noe ayavaca ");
		
		daoPersona.insert(p1);
		
		
		
		Vehiculo veh = new Vehiculo();
		veh.setPlacaVeh("ABC0102");
		veh.setModeloVeh("Toyota");
		
		
		daoVehiculo.insert(veh);
		
		TickecCab cab = new TickecCab();
		cab.setNombreTiCab("Topsy");
		cab.setFechaTiCab("22/01/2023");
		cab.setVehiculo(veh);
		
		
		TickecDet det = new TickecDet();
		det.setDisponibleTiDet("SI");
		det.setLugarTiDet("B22");
		det.setEntradaTiDet("13:00:44");
		det.setSalidaTiDet("17:15:11");
		
		
		cab.addTickecDet(det);
		
		daoTickecCab.insert(cab);
		
		

		System.out.print("todas la personas mundo -----");
		
		List<Persona> personas = daoPersona.getAll();
		for(Persona per: personas) {
			System.out.println(per);
		}
		
		System.out.print("todas la personas Fin -----");
		System.out.print("------------todas las tickes del mundo -----");
		List<TickecCab> tickecCabs = daoTickecCab.getAll();
		for(TickecCab tCab: tickecCabs) {
			System.out.println(tCab.getIdTiCab() + ": " + tCab.getNombreTiCab() + "- " + tCab.getVehiculo().getModeloVeh() + "- "+
					tCab.getFechaTiCab() + "- " +
					" total productos: " + tCab.getTickecDet().size());
		}
		
		System.out.print("------------Gracias :) -----");
		
		
	}
	
	
}
