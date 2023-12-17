package com.bemap.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bemap.modelos.Sensores;


@Repository
public interface ISensores extends CrudRepository<Sensores, Integer> {

}
