package com.bemap.modelos;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Administradores")
public class Administradores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "correo")
    private String correo;

    @OneToMany
    private List<Sensores> sensores;

    public Administradores() {
    }

    public Administradores(int id, String nombre, String correo, List<Sensores> sensores) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.sensores = sensores;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Sensores> getSensores() {
        return sensores;
    }

    public void setSensores(List<Sensores> sensores) {
        this.sensores = sensores;
    }
}
