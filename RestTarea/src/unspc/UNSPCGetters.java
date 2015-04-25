package unspc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import unspc.objects.UNSPCClass;
import unspc.objects.UNSPCFamilies;
import unspc.objects.UNSPCProducts;
import unspc.objects.UNSPCSegment;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

import cassandra.CassandraConnector;

@Path("/unspc")
public class UNSPCGetters {
	private static CassandraConnector cassandra = new CassandraConnector();

	public ResultSet execute(String query) {
		if (cassandra.getSession() == null) {
			cassandra.connect("unspciteso2015");
		}
		return cassandra.execute(query);
	}

	@GET
	@Path("/getSegments")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSegments() {
		List<UNSPCSegment> segmentList = new ArrayList<>();
		String query = "SELECT * FROM segmentos;";
		ResultSet segments = execute(query);

		Iterator<Row> results = segments.iterator();

		while (results.hasNext()) {
			Row r = results.next();
			segmentList.add(new UNSPCSegment(r.getString("idsegmento"), r
					.getString("descripcion")));
		}

		GenericEntity<List<UNSPCSegment>> generic = new GenericEntity<List<UNSPCSegment>>(
				segmentList) {
		};
		return Response.ok(generic).build();
		// return segmentList;
	}

	@GET
	@Path("/getFamiliesBySegment")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFamiliesBySegment(@QueryParam("id") int id) {

		List<UNSPCFamilies> familiesList = new ArrayList<>();
		String query = "SELECT * FROM familias WHERE idSegmento='"+id+"' ALLOW FILTERING;";
		
		ResultSet families = execute(query);
		Iterator<Row> results = families.iterator();
		
		while(results.hasNext()){
			Row r = results.next();
			familiesList.add(new UNSPCFamilies(r.getString("idfamilia"), r
					.getString("idsegmento"),r.getString("descripcion")));
		}
		
		GenericEntity<List<UNSPCFamilies>> generic = new GenericEntity<List<UNSPCFamilies>>(familiesList){};
		return Response.ok(generic).build();
	}
	
	@GET
	@Path("/getClassesByFamily")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClasesByFamily(@QueryParam("id") int id) {

		List<UNSPCClass> familiesList = new ArrayList<>();
		String query = "SELECT * FROM clases WHERE idFamilia='"+id+"' ALLOW FILTERING;";
		
		ResultSet families = execute(query);
		Iterator<Row> results = families.iterator();
		
		while(results.hasNext()){
			Row r = results.next();
			familiesList.add(new UNSPCClass(r.getString("idClase"), r
					.getString("idfamilia"),r.getString("descripcion")));
		}
		
		GenericEntity<List<UNSPCClass>> generic = new GenericEntity<List<UNSPCClass>>(familiesList){};
		return Response.ok(generic).build();
	}
	
	@GET
	@Path("/getProductsByClass")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductsByClass(@QueryParam("id") int id) {

		List<UNSPCProducts> familiesList = new ArrayList<>();
		String query = "SELECT * FROM productos WHERE idClase='"+id+"' ALLOW FILTERING;";
		
		ResultSet families = execute(query);
		Iterator<Row> results = families.iterator();
		
		while(results.hasNext()){
			Row r = results.next();
			familiesList.add(new UNSPCProducts(r.getString("idProducto"), r
					.getString("idClase"),r.getString("description")));
		}
		
		GenericEntity<List<UNSPCProducts>> generic = new GenericEntity<List<UNSPCProducts>>(familiesList){};
		return Response.ok(generic).build();
	}

}
