package com.bemap.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.bemap.interfaceServicio.ISensoresServicio;
import com.bemap.interfaces.ISensores;
import com.bemap.modelos.Sensores;

public class SensoresServicio implements ISensoresServicio{

	@Autowired
	private ISensores repo;
	
	@Override
	public List<Sensores> listar() {
		return (List<Sensores>)repo.findAll();
	}

	@Override
	public Optional<Sensores> listarID(int id) {
		return repo.findById(id);
	}

	@Override
	public int guardar(Sensores p) {
		Sensores em = repo.save(p);
		if (!em.equals(null)) {
			return 1;
		}
		return 0;
	}

	@Override
	public void borrar(int id) {
		

	}
	
}
