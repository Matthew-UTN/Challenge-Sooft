package ar.edu.teclab.prueba.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.teclab.prueba.entity.Materia;
import ar.edu.teclab.prueba.service.MateriaService;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
@RequestMapping(path = "api/v1/Materia")
public class MateriaController extends BaseController<Materia, MateriaService>{

}
