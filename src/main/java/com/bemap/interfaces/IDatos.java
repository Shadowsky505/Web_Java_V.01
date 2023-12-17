package com.bemap.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bemap.modelos.Datos;

@Repository
public interface IDatos extends CrudRepository<Datos, Integer> {

}
