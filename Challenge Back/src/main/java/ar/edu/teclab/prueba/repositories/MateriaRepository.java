package ar.edu.teclab.prueba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.teclab.prueba.entity.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Long> {

}
