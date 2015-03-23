package msc.ws.tareaws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name="ColisionDetection", portName="ColisionDetectionPort")
@SOAPBinding(style=SOAPBinding.Style.RPC)
public class ColisionDetection {

	@WebMethod(operationName="circleCircleIntersectionTest")
	@WebResult(partName="collide")
	public boolean circleCircleIntersectionTest(
			@WebParam(partName="center1X") double centerX1,
			@WebParam(partName="center1Y") double centerY1,
			@WebParam(partName="radius1") double radius1,
			@WebParam(partName="center2X") double centerX2,
			@WebParam(partName="center2Y") double centerY2,
			@WebParam(partName="radius2") double radius2){
		
		return false;
	}
}
