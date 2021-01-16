package ar.edu.teclab.prueba.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.teclab.prueba.entity.Carrera;
import ar.edu.teclab.prueba.service.CarreraService;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
@RequestMapping(path = "api/v1/Carrera")
public class CarreraController extends BaseController<Carrera, CarreraService>{

}
