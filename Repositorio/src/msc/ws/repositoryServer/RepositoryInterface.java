package msc.ws.repositoryServer;

import java.awt.Image;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface RepositoryInterface {
	
	@WebMethod(operationName="getImage")
	public Image getImage(String name);
	

}
