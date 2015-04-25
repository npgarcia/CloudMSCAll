package RestExample.infov2;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cliente {
	public String id;
	public String name;

	public Cliente(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public Cliente() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
