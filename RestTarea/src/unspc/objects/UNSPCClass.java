package unspc.objects;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UNSPCClass {
	
	String idClass;
    String idFamily;
    String descripcion;
    
    public UNSPCClass(){
    	
    }
    
	public UNSPCClass(String idFamilia, String idSegmento, String descripcion) {
		this.idClass = idFamilia;
		this.idFamily = idSegmento;
		this.descripcion = descripcion;
	}

	public String getIdFamilia() {
		return idClass;
	}
	public void setIdFamilia(String idFamilia) {
		this.idClass = idFamilia;
	}
	public String getIdSegmento() {
		return idFamily;
	}
	public void setIdSegmento(String idSegmento) {
		this.idFamily = idSegmento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
