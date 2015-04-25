package unspc.objects;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UNSPCProducts {

	String idProduct;
    String idClass;
    String descripcion;
    
    public UNSPCProducts(){
    	
    }
    
	public UNSPCProducts(String idFamilia, String idSegmento, String descripcion) {
		super();
		this.idProduct = idFamilia;
		this.idClass = idSegmento;
		this.descripcion = descripcion;
	}

	public String getIdFamilia() {
		return idProduct;
	}
	public void setIdFamilia(String idFamilia) {
		this.idProduct = idFamilia;
	}
	public String getIdSegmento() {
		return idClass;
	}
	public void setIdSegmento(String idSegmento) {
		this.idClass = idSegmento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
