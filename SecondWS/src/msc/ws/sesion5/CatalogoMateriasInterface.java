package msc.ws.sesion5;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name="CatalogoITESO")
@SOAPBinding(style=SOAPBinding.Style.RPC)
public interface CatalogoMateriasInterface {

	@WebMethod(exclude=true)
	public abstract List<String> obtenerCategoriasMaterias();
	
	@WebMethod(exclude=true)
	public abstract List<String> obtenerMaterias(String categoria);

	@WebResult(partName="materiaAgregada")
	public abstract boolean agregarMaterias(@WebParam(partName="categoria") String categoria, @WebParam(partName="materia")String materia);

}