package unspc.objects;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UNSPCSegment {
	String idSegmento;
	String descripcion;
	
	public UNSPCSegment(){
		
	}
	
	public UNSPCSegment(String id, String descripcion){
		this.idSegmento = id;
		this.descripcion = descripcion;
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
