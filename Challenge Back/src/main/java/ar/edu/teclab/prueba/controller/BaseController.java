package ar.edu.teclab.prueba.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.teclab.prueba.service.IBaseService;

public class BaseController <E, S extends IBaseService<E>> {
	
	@Autowired	
	protected S service;
	
	@GetMapping("")
	@Transactional
	public ResponseEntity<?> getAll(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value =  "size", defaultValue = "10") int size){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findAll(page, size));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"Mi mensaje get todos\": \"" + e.getMessage() + "\"}");
		}
	}


	@GetMapping("/{id}")
	@CrossOrigin(origins = "*")
	@Transactional
	public ResponseEntity<?> getOne(@PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \""+e.getMessage()+"\"}");
		}
	}
	

	@PostMapping("/")
	@Transactional
	public ResponseEntity<?> post(@RequestBody E entidadForm) {		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entidadForm));			
		} catch (Exception e) {			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \""+e.getMessage()+"\"}");						
		}		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> put(@PathVariable Long id, @RequestBody E entidadForm) {		
		try {			
			return ResponseEntity.status(HttpStatus.OK).body(service.update(id, entidadForm));			
		} catch (Exception e) {			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \""+e.getMessage()+"\"}");
		}		
	}


	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{\"Mi mensaje put\": \"" + e.getMessage() + "\"}");		}

	}
}
