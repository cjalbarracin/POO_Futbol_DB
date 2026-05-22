package model;

import java.sql.Timestamp;
import java.util.Date;

public class celular {

    private int id;
    private String marca;
    private string modelo;
    private int camara;
    private int bateria;
    private Timestamp creado;

    public celular (int id, String marca, String modelo, int camara, int bateria, Timestamp creado) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.camara = camara;
        this.bateria = bateria;
        this.creado = creado;
    }

    public celular(String marca, String modelo, int camara, int bateria) {
        this.marca = marca ;
        this.modelo = modelo ;
        this.camara = camara;
        this.bateria = bateria ;
    }


    //Getters para poder leer datos de un jugador en la ase3 de datos
    public int getId() {
        return id;
    }

    public String getmarca() {
        return marca;
    }

    public int getmodelo() {
        return modelo;
    }

    public String getcamara() {
        return camara;
    }

    public Boolean getbateria() {
        return bateria;
    }

    public Timestamp getCreado() {
        return creado;
    }


    }
}
