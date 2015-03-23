package msc.ws.sesion5;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import msc.ws.business.Materia;

@WebService(name="CatalogoITESO")
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT)
public interface CatalogoMateriasInterface {

	@WebMethod(exclude=true)
	public abstract List<String> obtenerCategoriasMaterias();
	
	@WebResult(partName="listaDeMaterias")
	public abstract List<String> obtenerMateriasPorCategoria(String categoria);
	
	@WebResult(partName="listaDeMaterias")
	public abstract List<Materia> obtenerListaMateriasPorCategoria(String categoria) throws EntradaInvalida;

	@WebResult(partName="materiaAgregada")
	public abstract boolean agregarMaterias(@WebParam(partName="categoria") String categoria, @WebParam(partName="materia")String materia);

}