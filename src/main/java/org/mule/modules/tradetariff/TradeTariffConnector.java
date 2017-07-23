package org.mule.modules.tradetariff;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;

import org.mule.modules.tradetariff.config.ConnectorConfig;

@Connector(name="trade-tariff", friendlyName="TradeTariff")
public class TradeTariffConnector {

    @Config
    ConnectorConfig config;

    private final String API_KEY = "gUXbu9HO8dehT0TdKdZEPzgq";
    String queryURL="https://api.trade.gov/v1/tariff_rates/search?api_key=";
    String sourcesURL="https://api.trade.gov/v1/tariff_rates/search?api_key=";
    String finalyearsURL="https://api.trade.gov/v1/tariff_rates/search?api_key=";
    String reporterNamesURL="https://api.trade.gov/v1/tariff_rates/search?api_key=";
    
    	

    /**
     * Custom processor
     *
     * @param friend Name to be used to generate a greeting message.
     * @return A greeting message
     */
    @Processor
    public String greet(String friend) {
        /*
         * MESSAGE PROCESSOR CODE GOES HERE
         */
        return config.getGreeting() + " " + friend + ". " + config.getReply();
    }

    @Processor
    public String query(String query) {
        /*
         * MESSAGE PROCESSOR CODE GOES HERE
         */
        return getInfo(queryURL+this.API_KEY+"&q="+query);
    }
    
    @Processor
    public String sources(String sources) {
        /*
         * MESSAGE PROCESSOR CODE GOES HERE
         */
        return  getInfo(sourcesURL+this.API_KEY+"&sources="+sources);
    }
    
    @Processor
    public String finalyears(String finalyears) {
        /*
         * MESSAGE PROCESSOR CODE GOES HERE
         */
    	return  getInfo(finalyearsURL+this.API_KEY+"&final_years="+finalyears);
    }
    
    @Processor
    public String reporterNames(String reporterNames) {
        /*
         * MESSAGE PROCESSOR CODE GOES HERE
         */
    	return  getInfo(reporterNamesURL+this.API_KEY+"&reporter_names="+reporterNames);
    }
    
    
    private String getInfo(String url){
       		StringBuffer response = new StringBuffer();
       		String resp;
       		try {
       			URL obj = new URL(url);
       			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

       			// optional default is GET
       			con.setRequestMethod("GET");

       			// add request header
       			int responseCode = con.getResponseCode();
       			System.out.println("\nSending 'GET' request to URL : " + url);
       			System.out.println("Response Code : " + responseCode);

       			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
       			String inputLine;
       			

       			while ((inputLine = in.readLine()) != null) {
       				response.append(inputLine);
       			}
       			in.close();

       			// print result
       			resp=response.toString();
       		} catch (Exception e) {
       			resp="Error getting the timezone";
       			e.printStackTrace();
       		}
       		
       		return resp;
        
    }


    

    public ConnectorConfig getConfig() {
        return config;
    }

    public void setConfig(ConnectorConfig config) {
        this.config = config;
    }

}