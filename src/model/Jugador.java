package model;

import java.sql.Timestamp;
import java.util.Date;

public class Jugador {

    private int id;
    private String nombre;
    private int dorsal;
    private String posicion;
    private Boolean activo;
    private Timestamp creado;

    public Jugador(int id, String nombre, int dorsal, String posicion, Boolean activo, Timestamp creado) {
        this.id = id;
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.activo = activo;
        this.creado = creado;
    }

    public Jugador(String nombre, int dorsal, String posicion, Boolean activo) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.activo = activo;
    }


    //Getters para poder leer datos de un jugador en la ase3 de datos
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDorsal() {
        return dorsal;
    }

    public String getPosicion() {
        return posicion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public Timestamp getCreado() {
        return creado;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", dorsal=" + dorsal +
                ", posicion='" + posicion + '\'' +
                ", activo=" + activo +
                ", creado=" + creado +
                '}';
    }
}
