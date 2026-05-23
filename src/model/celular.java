package model;

import java.sql.Timestamp;

public class celular {

    private int id;
    private String marca;
    private String modelo;
    private int camara;
    private int bateria;
    private Timestamp creado;


    public celular(int id, String marca, String modelo, int camara, int bateria, Timestamp creado) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.camara = camara;
        this.bateria = bateria;
        this.creado = creado;
    }


    public celular(String marca, String modelo, int camara, int bateria) {
        this.marca = marca;
        this.modelo = modelo;
        this.camara = camara;
        this.bateria = bateria;
    }


    public int getId() {
        return id;
    }

    public String getmarca() {
        return marca;
    }

    public String getmodelo() {
        return modelo;
    }

    public int getcamara() {
        return camara;
    }

    public int getbateria() {
        return bateria;
    }

    public Timestamp getCreado() {
        return creado;
    }
}