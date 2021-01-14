package ar.edu.teclab.prueba.service;

import java.util.List;

public interface IBaseService <E>{
	
	public E findById(Long id) throws Exception;
	
	public E save(E entityForm) throws Exception;
	
	public E update(Long id, E entityForm) throws Exception;
	
	public int countPages(int size) throws Exception;
	
	public List<E> findAll(int page, int size) throws Exception;
	
	public boolean delete(Long id) throws Exception;



}
