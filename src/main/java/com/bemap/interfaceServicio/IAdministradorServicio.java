package com.bemap.interfaceServicio;
import java.util.List;
import java.util.Optional;

import com.bemap.modelos.Administradores;

public interface IAdministradorServicio {
	public List<Administradores> listar();
	public Optional<Administradores> listarID(int id);
	public int guardar(Administradores p);
	public void borrar(int id);
}
