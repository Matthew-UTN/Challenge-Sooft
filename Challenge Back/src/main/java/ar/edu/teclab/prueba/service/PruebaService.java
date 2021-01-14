package ar.edu.teclab.prueba.service;

import java.nio.charset.Charset;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.api.client.util.Base64;

import org.springframework.http.MediaType;

import com.google.gson.Gson;

import ar.edu.teclab.prueba.dto.Ticket;

@Service
public class PruebaService {

	private static final Log LOG = LogFactory.getLog(PruebaService.class);
	
	final static String uri = "https://teclab1593636133.zendesk.com/api/v2/tickets/";

	@Transactional
	public static Ticket comment(Long id) throws Exception {
		
		try {			
			
	        RestTemplate restTemplate = new RestTemplate();
	        
	        String urlGetComments = uri + id + "/comments.json";
	        
	        HttpHeaders headers = createHeader();
	        
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        
	        HttpEntity<String> request = new HttpEntity<>(headers);
	        
	        ResponseEntity<String> response = restTemplate.exchange(urlGetComments, HttpMethod.GET, request, String.class);

	        String result = response.getBody();
	        
	        Gson g = new Gson();  
	        
	        Ticket s = g.fromJson(result, Ticket.class); 
	        
	        /*
		        String todosLosComentarios = "Los comentarios para el ticket #" + id + "\n";
		        for (int i = 0; i < s.getComments().size(); i++) {
					todosLosComentarios += (i+1) + ": " + s.getComments().get(i).getBody() + "\n";
				}
			*/
	        
	        return s;
		
		} catch (Exception e) {
			
			throw new Exception();
			
		}
		
	}
    
    
	
	
	
	public static String addComment(Long id, String body) {
		
		RestTemplate restTemplate = new RestTemplate();
				
        String urlGetComments = uri + id + ".json";
        
        HttpHeaders headers = createHeader();
        
        headers.setContentType(MediaType.APPLICATION_JSON);        
        
        String comment = "{\"ticket\": {\"comment\": { \"body\": \"" + body + "\", \"author_id\": 400041509731 }}}";
        
        HttpEntity<String> request = new HttpEntity<>(comment, headers);
        
        System.out.println(request.getBody());
        
        ResponseEntity<Ticket> response = restTemplate.exchange(urlGetComments, HttpMethod.PUT, request, Ticket.class);

        Ticket result = response.getBody();                
        
        return "comment has been uploaded.";
        
	}
	
	@SuppressWarnings("serial")
	private static HttpHeaders createHeader() {
        return new HttpHeaders() {{
            String auth = "jorge.danni@teclab.edu.ar:Abril2019";
            byte[] encodeAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("US-ASCII"))
            );
            String authHeader = "Basic " + new String(encodeAuth);
            set("Authorization", authHeader);
        }};
    }	

}
