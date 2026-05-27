package model;

public class inventario {

    private int celular_id;
    private int almacenamiento;
    private double precio;
    private int ram;

    // Constructor vacío
    public inventario() {
    }

    // Constructor completo
    public inventario(int celular_id, int almacenamiento, double precio, int ram) {
        this.celular_id = celular_id;
        this.almacenamiento = almacenamiento;
        this.precio = precio;
        this.ram = ram;
    }

    // Getters y Setters

    public int getCelular_id() {
        return celular_id;
    }

    public void setCelular_id(int celular_id) {
        this.celular_id = celular_id;
    }

    public int getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(int almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }
}
