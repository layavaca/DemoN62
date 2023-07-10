package ec.edu.ups.demoN62.negocio;

import ec.edu.ups.demoN62.datos.PersonaDao;
import ec.edu.ups.demoN62.modelo.Persona;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionClientes {

	@Inject
	private PersonaDao daoPersona;
	
	public void guardarCliente(Persona persona) throws Exception {
		if(!this.isCedulaValida(persona.getCedulaPer()))
			throw new Exception("cedula incorrecta");
		if(daoPersona.read(persona.getCedulaPer())== null) {
			try {
				daoPersona.insert(persona);
			
			} catch (Exception e) {
				throw new Exception("Error al insertar:" + e.getMessage());
				// TODO: handle exception
			}
			}else {				
				try {
					daoPersona.update(persona);
				} catch (Exception e) {
					throw new Exception("Error al actualizar:" + e.getMessage());
					// TODO: handle exception
			}
		}
	}
	
	public boolean isCedulaValida(String cedula ) {
		return cedula.length()== 10;
	}
	
	public void guardarClientes(String cedulaPer, String nombrePer, String direccionPer) {}
	
}
