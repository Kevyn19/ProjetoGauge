package br.com.gaugeWeb;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
 
@ManagedBean
public class ChartView implements Serializable {
 
    private BarChartModel barModel;
    
    private String option = "";
	private Map<String,String> hash;
	private resultChart[] chart;
    
 
    @PostConstruct
    public void init() {
    	
    	
    	hash = new  HashMap<String, String>();
    	
    	hash.put("Ambev", "Ambev");
    	hash.put("Nike", "Nike");
    	hash.put("Honda", "Honda");
    	hash.put("Oi", "Oi");
    	hash.put("Itaú", "Itaú");
    	hash.put("Full", "Full");
	
    	filter();
        createBarModels();
    }
 
    public BarChartModel getBarModel() {
        return barModel;
    }
     
    public String filter() {
    	
    	System.out.println("opção"+ option);
    	
    	
		if(option.equals("Full") || option.equals("")){
			
			Client c = Client.create();
	        WebResource webResource = c.resource("http://localhost:8888/GaugeService/rest/interactions/buildChart/full/");
	        c.addFilter(new HTTPBasicAuthFilter("kevyn", "kevyn"));
			System.out.println("JSON=&gt;&gt; " + webResource.get(String.class));
			String teste = webResource.get(String.class);
	
			Gson gson = new Gson();
		    chart = gson.fromJson(teste, resultChart[].class);
			
		}else{
			
			Client c = Client.create();
	        WebResource webResource = c.resource("http://localhost:8888/GaugeService/rest/interactions/buildChart/"+option+"/");
	        c.addFilter(new HTTPBasicAuthFilter("kevyn", "kevyn"));
			System.out.println("JSON=&gt;&gt; " + webResource.get(String.class));
			String teste = webResource.get(String.class);
			

			Gson gson = new Gson();
		    chart = gson.fromJson(teste, resultChart[].class);
			
		}
		
		return "index";
	}
 
 
    private BarChartModel initBarModel() {
    	
        BarChartModel model = new BarChartModel();
        
        ChartSeries lab = new ChartSeries();
        lab.setLabel("interactions");
        

	    
	    for(int i = 0; i < chart.length; i++ ){
	    	
 		   lab.set(chart[i].getName(), chart[i].getAmount());
 		   
		  }
 
 
        model.addSeries(lab);
      
         
        return model;
    }
     
    private void createBarModels() {
        createBarModel();
    }
     
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("interactions x users");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("users");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("interactions");
        yAxis.setMin(0);
        yAxis.setMax(50);
    }

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public Map<String, String> getHash() {
		return hash;
	}

	public void setHash(Map<String, String> hash) {
		this.hash = hash;
	}
     

 
}