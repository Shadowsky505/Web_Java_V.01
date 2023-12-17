package com.bemap.interfaceServicio;

import java.util.List;
import java.util.Optional;

import com.bemap.modelos.Sensores;

public interface ISensoresServicio {
	public List<Sensores> listar();
	public Optional<Sensores> listarID(int id);
	public int guardar(Sensores p);
	public void borrar(int id);
}