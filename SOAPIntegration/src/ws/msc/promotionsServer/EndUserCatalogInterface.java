package ws.msc.promotionsServer;

import java.awt.Image;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import ws.msc.promotionsBusiness.EndUser;
import ws.msc.promotionsBusiness.Wish;

@WebService(name="EndUserCatalog")
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT)
public interface EndUserCatalogInterface {

	@WebMethod(operationName="InsertNewUser")
	public void insertNewUser(@WebParam(name="user")EndUser user);
	
	@WebMethod(operationName="AddUserWish")
	@WebResult(partName="WishAdded")
	public boolean insertWish(@WebParam(name="userId")double userId, @WebParam(name="userWish")Wish theWish);
	
	@WebMethod(operationName="signInUser")
	@WebResult(partName="signedUser")
	public EndUser signIn(@WebParam(name="userName")String name, @WebParam(name="userPassword")String pass);
	
	@WebMethod(operationName="getUserWishList")
	@WebResult(partName="wishList")
	public List<Wish> getUserWishList(@WebParam(name="userId")double userId);
	
	@WebMethod(operationName="signOutUser")
	public void signOut(@WebParam(name="userId")double userId);
	
	@WebMethod(operationName="getImage")
	public Image getImage(String name);
	
}
