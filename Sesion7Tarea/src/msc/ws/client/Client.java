package msc.ws.client;

import java.util.Iterator;
import java.util.List;

import msc.ws.sesion5.CatalogoITESO;
import msc.ws.sesion5.CatalogoITESOService;
import msc.ws.sesion5.EntradaInvalida_Exception;
import msc.ws.sesion5.Materia;


public class Client {

	public static void main(String[] args) {
		CatalogoITESOService catalogoService = new CatalogoITESOService();
		
		CatalogoITESO catalogo = catalogoService.getCatalogoITESOPort();
		
		try {
			List<Materia> materias =catalogo.obtenerListaMateriasPorCategoria("Ciencia basica");
			Iterator<Materia> i = materias.iterator();
			while(i.hasNext()){
				System.out.println(i.next().getNombre());
			}
		} catch (EntradaInvalida_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
