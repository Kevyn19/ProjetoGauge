package br.com.gauge.rest;

import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.gauge.entities.brands;
import br.com.gauge.service.brandsService;

@Path("brands")
public class brandsRest {
	
	@Path("/save/")
	@POST
	@Produces("application/json")
	public long save(@FormParam("action") String action,@FormParam("id") long id, @FormParam("name") String name, @FormParam("image") String image) throws URISyntaxException{
		
		
		brands result = new brands();
		
		if(action.equals("create")){
			brands brand = new brands();
			brand.setName(name);
			brand.setImage(image);
			
			result = new brandsService().save(brand);
			
		}else if(action.equals("update")){
			brands brand = new brandsService().listarkey(id).get(0);
			
			brand.setName(name);
			brand.setImage(image);
			
			result = new brandsService().update(brand);
			
		}
		
		return result.getIdbrands();
	}
	

	@GET
	@Produces("application/json")
	public List<brands> getbrands() {
		List<brands> result;
		result = new brandsService().listAll();
		return result;
	}
	
	
	@Path("/delete/")
	@DELETE
	@Produces("application/json")
	public brands deletebrands(@FormParam("id") long id) {
		
		brands brand = new brandsService().listarkey(id).get(0);
		return new brandsService().delete(brand);
		
	}
	

}
