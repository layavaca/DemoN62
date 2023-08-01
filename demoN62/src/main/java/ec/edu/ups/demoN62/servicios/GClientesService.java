package ec.edu.ups.demoN62.servicios;

import java.util.List;

import ec.edu.ups.demoN62.datos.PersonaDao;
import ec.edu.ups.demoN62.datos.TickecCabDao;
import ec.edu.ups.demoN62.modelo.Persona;
import ec.edu.ups.demoN62.modelo.TickecCab;
import ec.edu.ups.demoN62.negocio.GestionClientes;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("clientes")
public class GClientesService {
	@Inject
	private PersonaDao daoPersona;
	@Inject
	private GestionClientes gClientes;
	@Inject
	private TickecCabDao daoTickecCab;

	@GET
	@Path("Saludo")
	public String saludo() {
		return "hola mundo";
	}

	@GET
	@Path("Suma")
	public String suma(@QueryParam("a") int a, @QueryParam("b") int b) {

		return "R =" + (a + b);
	}

	@GET
	@Path("multipiclacion/{a}/{b}")
	public String multipiclacion(@PathParam("a") int a, @PathParam("b") int b) {
		return "R =" + (a * b);
	}

	@GET
	@Path("misdatos")
	@Produces("application/json")
	public Persona misdatos() {
		Persona p = new Persona();
		p.setNombrePer("Noe Ayavaca");
		p.setCedulaPer("0107083511");
		p.setDireccionPer("San Joaquin");
		return p;
	}

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarCliente(Persona persona) {
		try {
			gClientes.guardarCliente(persona);
			return Response.status(Response.Status.OK).entity(persona).build();
		} catch (Exception e) {
			// TODO: handle exception
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("error al guardar:" + e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}

	@DELETE
	@Path("eliminar")
	public String eliminar(@QueryParam("cedulaPer") String cedulaPer) {
		try {
			gClientes.eliminarCliente(cedulaPer);
			return"elimina";
		} catch (Exception e) {

			// TODO: handle exception
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("error al guardar:" + e.getMessage());
			return "no";
		}
	}
	
	  @DELETE
	    @Path("id{cedulaPer}")
	    public Response eliminarEntidad(@PathParam("cedulaPer") String cedulaPer) {
		  try {
			  gClientes.eliminarCliente(cedulaPer); 
			  return Response.status(Response.Status.OK).entity(cedulaPer).build();			  
		  }catch (Exception e) {
				// TODO: handle exception
				Error error = new Error();
				error.setCodigo(99);
				error.setMensaje("error al eliminar:" + e.getMessage());
				return Response.status(Response.Status.OK).entity(error).build();
			}  
	    }

	@GET
	@Path("lista")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Persona> getListadoPersona() {
		return daoPersona.getAll();

	}

	@GET
	@Path("lista1")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPersona() {
		List<Persona> listado = gClientes.getClientes();
		return Response.status(Response.Status.OK).entity(listado).build();
	}

}
