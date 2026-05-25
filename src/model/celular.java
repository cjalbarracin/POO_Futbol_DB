package model;

public class celular {
    private String marca;
    private String modelo;
    private int camara;
    private int bateria;

    
    public celular(String marca, String modelo, int camara, int bateria) {
        this.marca = marca;
        this.modelo = modelo;
        this.camara = camara;
        this.bateria = bateria;
    }

    
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCamara() {
        return camara;
    }

    public int getBateria() {
        return bateria;
    }
}