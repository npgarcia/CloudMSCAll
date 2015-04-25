package RestExample.infov3;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ws/informacion/v3")
public class InformationV3 {
	String version = "3";
	private static HashMap<String, String> clientes = new HashMap<>();
	private static HashMap<String, Cliente> clientesRandom = new HashMap<>();

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
	@Path("/getClientesRandom")
	@Produces(MediaType.TEXT_HTML)
	public String getClientesRandom() {
		String result = "";
		llenarLista();

		for (Entry<String, Cliente> entry : clientesRandom.entrySet()) {
			result += entry.getValue().toString() + "<br>";
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

	@POST
	@Path("/crearCliente")
	@Produces(MediaType.TEXT_HTML)
	public String crearCliente(@FormParam("id") String id, @FormParam("name")String name){
		clientes.put(id, name);
		return "SUCCESS in "+id+ " name: "+name;
	}
	
	@POST
	@Path("/crearClienteRandom")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public Response crearClienteRandom(@FormParam("edad") String edad, @FormParam("nombre2")String nombre) throws URISyntaxException{
		clientesRandom.put(Integer.toString(clientesRandom.size()), new Cliente(edad, nombre));
		return Response.status(300).location(new URI("ws/informacion/v3/getClientesRandom")).build();
	}
}
