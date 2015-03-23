package msc.ws.sesion5;

import java.util.List;

import javax.jws.WebService;

import msc.ws.business.MateriasServiceImpl;

@WebService(endpointInterface="msc.ws.sesion5.CatalogoMateriasInterface", portName="CatalogoITESOPort", serviceName="CatalogoITESOService")
public class CatalogoMaterias implements CatalogoMateriasInterface {
	

	MateriasServiceImpl materiasService = new MateriasServiceImpl();

	/* (non-Javadoc)
	 * @see msc.ws.sesion5.CatalogoMateriasInterface#obtenerCategoriasMaterias()
	 */
	@Override
	public List<String> obtenerCategoriasMaterias(){
		return materiasService.obtenerCategoriasMaterias();
	}
	
	/* (non-Javadoc)
	 * @see msc.ws.sesion5.CatalogoMateriasInterface#obtenerMaterias(java.lang.String)
	 */
	@Override
	public List<String> obtenerMaterias(String categoria){
		return materiasService.obtenerMaterias(categoria);
	}
	
	/* (non-Javadoc)
	 * @see msc.ws.sesion5.CatalogoMateriasInterface#agregarMaterias(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean agregarMaterias(String categoria, String materia){
		return materiasService.agregarMateria(categoria, materia);
	}
	
}
