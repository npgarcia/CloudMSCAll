package RestExample.info;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ws/informacion/v1")
public class Informacion {
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getInfo(){
		return "<p> mi getInfo de prueba</p>";
	}
	
}
