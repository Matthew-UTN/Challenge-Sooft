package ar.edu.teclab.prueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseService <E, R extends JpaRepository<E, Long>> implements IBaseService<E> {

	
	protected R repository;	

	@Override
	public E findById(Long id) throws Exception {
		try {
			// se usa para atrapar un null
			Optional<E> varOptional = (Optional<E>) repository.findOne(id);
			E entity = varOptional.get();
			return entity;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}

	@Override
	public E save(E entityForm) throws Exception {
		try {
			entityForm = repository.save(entityForm);
			return entityForm;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public E update(Long id, E entityForm) throws Exception {
		try {
			Optional<E> entityOptional = (Optional<E>) repository.findOne(id);
			E entity = entityOptional.get();
			entity = repository.save(entityForm);
			return entity;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public int countPages(int size) throws Exception {
		try {
			Pageable pageable = new PageRequest(0, size);
			return repository.findAll(pageable).getTotalPages();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<E> findAll(int page, int size) throws Exception {
		
		try {
			Pageable pageable = new PageRequest(page, size);
			return repository.findAll(pageable).getContent();			

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	@Override
	public boolean delete(Long id) throws Exception{
		try {
			if(repository.exists(id)) {
				repository.delete(id);
			}			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
		return !repository.exists(id);
	}
	
}
