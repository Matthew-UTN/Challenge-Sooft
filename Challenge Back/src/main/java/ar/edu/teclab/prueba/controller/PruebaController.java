package ar.edu.teclab.prueba.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ar.edu.teclab.prueba.dto.Ticket;
import ar.edu.teclab.prueba.dto.Ejemplo;
import ar.edu.teclab.prueba.service.PruebaService;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "*")
public class PruebaController {

	private static final Log LOG = LogFactory.getLog(PruebaController.class);
	
	final String uri = "https://teclab1593636133.zendesk.com/api/v2/tickets/9/comments";

	@Autowired
	protected PruebaService pruebaService;

	@GetMapping("/ejemplo")
	public ResponseEntity<Ejemplo> getMessageStatus(@RequestParam(value ="nombre") String nombre) {
		try {
			Ejemplo ejemplo = new Ejemplo();
			ejemplo.setNombre(nombre);
			return ResponseEntity.ok(ejemplo);
		}catch (Exception e){
			LOG.error("Error", e);
		}
		return null;
	}
	
	@GetMapping("/getComments")
    public ResponseEntity<Ticket> getComments(@RequestParam(value ="id")Long id) {
		
		try {

			return ResponseEntity.status(HttpStatus.OK).body(PruebaService.comment(id));
									
		}catch (Exception e){
			
			LOG.error("Error", e);
			
			return (ResponseEntity<Ticket>) ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Ticket());
			
		}
		
	}
	
	@PutMapping("/addComment")
	public ResponseEntity<String> updateTickets(@RequestParam(value="id")Long id, @RequestParam(value="body")String body){
		
		try {

			return ResponseEntity.status(HttpStatus.OK).body(PruebaService.addComment(id,body));
						
		}catch (Exception e){
			
			LOG.error("Error", e);
			
			return (ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error, could not make comment."));
			
		}
	}
	
	
}


