package msc.ws.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import msc.ws.sesion5.EntradaInvalida;

public class MateriasServiceImpl {

	List<String> cienciaBasica;
	
	public MateriasServiceImpl(){
		String materias[] = {"materia 1", "materia 2", "materia 3"};
		cienciaBasica = new ArrayList<String>(Arrays.asList(materias));
	}
	
	public List<String> obtenerCategoriasMaterias(){
		List<String> categorias = new ArrayList<String>();
		categorias.add("Ciencia basica");
		categorias.add("CU");
		categorias.add("Optativas");
		categorias.add("Otra categoria");
		
		return categorias;
	}
	
	public List<String> obtenerMaterias(String categoria){
		List<String> materias = null;
		
		switch(categoria){
		case "Ciencia basica":
			materias = cienciaBasica; 
			break;
		}
		
		return materias;
		
	}
	
	public List<Materia> obtenerListaMaterias(String categoria) throws EntradaInvalida{
		List<Materia> materias = null;
		
		switch(categoria){
		case "Ciencia basica":
			materias = new ArrayList<Materia>();
			for(String materia : cienciaBasica){
				materias.add(new Materia(1234,materia, new Carrera("carrera 1",0,0)));
			}
			break;
			
		default:
			throw new EntradaInvalida("Entrada no valida",categoria+" no valida");
		}
		
		return materias;
		
	}
	
	public boolean agregarMateria(String categoria, String materia){
		boolean success = false;
		switch(categoria){
		case "Ciencia basica":
			cienciaBasica.add(materia);
			success = true;
			break;
		}
		
		return success;
	}
	
}
