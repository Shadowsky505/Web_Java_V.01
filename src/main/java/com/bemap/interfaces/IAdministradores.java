package com.bemap.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bemap.modelos.Administradores;

@Repository
public interface IAdministradores extends CrudRepository<Administradores, Integer> {

}
