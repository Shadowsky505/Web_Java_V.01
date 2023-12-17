package com.bemap.interfaceServicio;

import java.util.List;
import java.util.Optional;
import com.bemap.modelos.Datos;

public interface IDatosServicio {
	public List<Datos> listar();
	public Optional<Datos> listarId(int id);
	public int guardar(Datos p);
	public void borrar(int id);	
}
