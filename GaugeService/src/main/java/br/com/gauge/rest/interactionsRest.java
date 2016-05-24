package br.com.gauge.rest;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.gauge.entities.interactions;
import br.com.gauge.entities.resultChart;
import br.com.gauge.entities.users;
import br.com.gauge.service.brandsService;
import br.com.gauge.service.interactionsService;
import br.com.gauge.service.usersService;

@Path("interactions")
public class interactionsRest {
	
	@Path("/save/")
	@POST
	@Produces("application/json")
	public long save(@FormParam("action") String action,@FormParam("id") long id, @FormParam("type") String type, @FormParam("text") String text,
					 @FormParam("user_id") long user_id, @FormParam("brand_id") long brand_id) throws URISyntaxException{
		
			interactions result = new interactions();
			
			interactions interaction = new interactions();
			
			interaction.setBrand(new brandsService().listarkey(brand_id).get(0));
			interaction.setUser(new usersService().listarkey(user_id).get(0));
			interaction.setText(text);
			interaction.setType(type);
			
			result = new interactionsService().save(interaction);

		
		return result.getBrand().getIdbrands();
		
	}
	
	@GET
	@Produces("application/json")
	public List<interactions> getinteractions() {
		List<interactions> result;
		result = new interactionsService().listAll();
		return result;
	}
	
	@Path("/buildChart/{action}")
	@GET
	@Produces("application/json")
	public List<resultChart> getbuildChart(@PathParam("action") String action) {
		
		long amount = 0;
		List<resultChart> result = new ArrayList<resultChart>();
		
		if(action.equals("full")){
			
			List<users> listUsers = new usersService().listAll();
			
			
			for (users user : listUsers) {
				 amount = new interactionsService().Count(user.getIdusers());
				 resultChart ch = new resultChart();
				 
				 ch.setAmount(amount);
				 ch.setBrand("All");
				 ch.setIdUser(user.getIdusers());
				 ch.setName(user.getFirst());
				 
				 result.add(ch);
				 amount = 0;
			}
			
			
		}else{
			
			List<users> listUsers = new usersService().listAll();

			
			for (users user : listUsers) {
				 amount = new interactionsService().CountOthers(user.getIdusers(), action);
				 resultChart ch = new resultChart();
				 
				 ch.setAmount(amount);
				 ch.setBrand("All");
				 ch.setIdUser(user.getIdusers());
				 ch.setName(user.getFirst());
				 
				 result.add(ch);
				 amount = 0;
			}
			
		}
		
		
		return result;
	}
	
	

}
