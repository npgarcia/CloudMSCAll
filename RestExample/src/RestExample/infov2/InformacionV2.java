package RestExample.infov2;

import java.util.HashMap;
import java.util.Map.Entry;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;

@Path("/ws/informacion/v2")
public class InformacionV2 {
	String version = "2";
	private HashMap<String, String> clientes = new HashMap<>();

	public void llenarLista() {
		clientes.put("1", "Juan Perez");
		clientes.put("2", "Pedro Paramo");
		clientes.put("3", "Lola La Trailera");
	}

	@GET
	@Path("/getClientes")
	@Produces(MediaType.TEXT_HTML)
	public String getClientes() {
		String result = "";
		llenarLista();

		for (Entry<String, String> entry : clientes.entrySet()) {
			result += entry.getValue() + "<br>";
		}

		return result;
	}

	@GET
	@Path("/getCliente")
	@Produces(MediaType.TEXT_HTML)
	public Response getCliente(@QueryParam("id") Integer id) {
		llenarLista();

		if (id != null) {

			if (clientes.containsKey(id.toString()))
				return Response.ok(clientes.get(id.toString())).build();
			else {
				return Response.status(500).entity("Cliente no encontrado").build();
			}
		}else{
			return Response.ok(getClientes()).build();
		}
	}
	
	@GET
	@Path("/getCliente/{id}")
	@Produces(MediaType.TEXT_HTML)
	public Response getClienteById(@PathParam("id") Integer id) {
		llenarLista();

		if (id != null) {

			if (clientes.containsKey(id.toString()))
				return Response.ok(new Cliente(id.toString(),clientes.get(id.toString()))).build();
			else {
				return Response.status(500).entity("Cliente no encontrado").build();
			}
		}else{
			return Response.ok(getClientes()).build();
		}
	}
	
	@GET
	@Path("/getCliente/json/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClienteByIdJson(@PathParam("id") Integer id) {
		llenarLista();

		if (id != null) {

			if (clientes.containsKey(id.toString()))
				return Response.ok(new Cliente(id.toString(),clientes.get(id.toString()))).build();
			else {
				return Response.status(500).entity("Cliente no encontrado").build();
			}
		}else{
			return Response.ok(getClientes()).build();
		}
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getInfo() {
		return "<p> mi getInfo de prueba</p>";
	}

	@GET
	@Path("/getVersion")
	@Produces(MediaType.TEXT_HTML)
	public String getVersion() {
		return "Version: " + version;
	}

}
