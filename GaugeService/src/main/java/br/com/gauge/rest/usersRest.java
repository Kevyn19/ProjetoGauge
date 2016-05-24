package br.com.gauge.rest;

import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.gauge.entities.users;
import br.com.gauge.service.usersService;

@Path("users")
public class usersRest {
	
	@Path("/save/")
	@POST
	@Produces("application/json")
	public long save(@FormParam("action") String action,@FormParam("id") long id, @FormParam("gender") String gender, @FormParam("title") String title,
					 @FormParam("first") String first,@FormParam("last") String last,@FormParam("street") String street,@FormParam("city") String city,
					 @FormParam("state") String state,@FormParam("postcode") int postcode,@FormParam("email") String email,@FormParam("username") String username,
					 @FormParam("password") String password,@FormParam("salt") String salt,@FormParam("md5") String md5,@FormParam("sha1") String sha1,
					 @FormParam("sha256") String sha256,@FormParam("registered") int registered,@FormParam("dob") int dob,@FormParam("phone") String phone,
					 @FormParam("cell") String cell,@FormParam("pictureLarge") String pictureLarge,@FormParam("pictureMedium") String pictureMedium,@FormParam("pictureThumbnail") String pictureThumbnail,
					 @FormParam("nat") String nat) throws URISyntaxException{
		
		
		users result = new users();
		
		if(action.equals("create")){
			
			users user = new users();
			
			user.setCell(cell);
			user.setCity(city);
			user.setDob(dob);
			user.setEmail(email);
			user.setFirst(first);
			user.setGender(gender);
			user.setLast(last);
			user.setMd5(md5);
			user.setNat(nat);
			user.setPassword(password);
			user.setPhone(phone);
			user.setPictureLarge(pictureLarge);
			user.setPictureMedium(pictureMedium);
			user.setPictureThumbnail(pictureThumbnail);
			user.setPostcode(postcode);
			user.setRegistered(registered);
			user.setSalt(salt);
			user.setSha1(sha1);
			user.setSha256(sha256);
			user.setState(state);
			user.setStreet(street);
			user.setTitle(title);
			user.setUsername(username);
			
			
			result = new usersService().save(user);
			
		}else if(action.equals("update")){
			users user = new usersService().listarkey(id).get(0);
			
			user.setCell(cell);
			user.setCity(city);
			user.setDob(dob);
			user.setEmail(email);
			user.setFirst(first);
			user.setGender(gender);
			user.setLast(last);
			user.setMd5(md5);
			user.setNat(nat);
			user.setPassword(password);
			user.setPhone(phone);
			user.setPictureLarge(pictureLarge);
			user.setPictureMedium(pictureMedium);
			user.setPictureThumbnail(pictureThumbnail);
			user.setPostcode(postcode);
			user.setRegistered(registered);
			user.setSalt(salt);
			user.setSha1(sha1);
			user.setSha256(sha256);
			user.setState(state);
			user.setStreet(street);
			user.setTitle(title);
			user.setUsername(username);
			
			result = new usersService().update(user);
			
		}
		
		return result.getIdusers();
	}
	
	
	@GET
	@Produces("application/json")
	public List<users> getusers() {
		List<users> result;
		result = new usersService().listAll();
		return result;
	}
	
	
	@Path("/delete/")
	@DELETE
	@Produces("application/json")
	public users deleteusers(@FormParam("id") long id) {
		
		users user = new usersService().listarkey(id).get(0);
		return new usersService().delete(user);
		
	}
	
	

}
