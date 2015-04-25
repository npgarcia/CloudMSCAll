package unspc.objects;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UNSPCFamilies {
	String idFamilia;
    String idSegmento;
    String descripcion;
    
    public UNSPCFamilies(){
    	
    }
    
	public UNSPCFamilies(String idFamilia, String idSegmento, String descripcion) {
		super();
		this.idFamilia = idFamilia;
		this.idSegmento = idSegmento;
		this.descripcion = descripcion;
	}

	public String getIdFamilia() {
		return idFamilia;
	}
	public void setIdFamilia(String idFamilia) {
		this.idFamilia = idFamilia;
	}
	public String getIdSegmento() {
		return idSegmento;
	}
	public void setIdSegmento(String idSegmento) {
		this.idSegmento = idSegmento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
    
    

}
