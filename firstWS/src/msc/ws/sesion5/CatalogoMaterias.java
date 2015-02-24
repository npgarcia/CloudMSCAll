package msc.ws.sesion5;

import java.util.List;

import javax.jws.WebService;

import msc.ws.business.MateriasServiceImpl;

@WebService
public class CatalogoMaterias {
	

	MateriasServiceImpl materiasService = new MateriasServiceImpl();

	public List<String> obtenerCategoriasMaterias(){
		return materiasService.obtenerCategoriasMaterias();
	}
	
	public List<String> obtenerMaterias(String categoria){
		return materiasService.obtenerMaterias(categoria);
	}
	
	public boolean agregarMaterias(String categoria, String materia){
		return materiasService.agregarMateria(categoria, materia);
	}
	
}
