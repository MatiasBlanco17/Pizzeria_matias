package Objetos;

public class Ingredientes {
    private int id;
    private String[] nombre={"Tocino","Extra queso","Champiñon","Salame","Albahaca"};
    private int[] precio={350,500,250,300,450};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getNombre() {
        return nombre;
    }

    public void setNombre(String[] nombre) {
        this.nombre = nombre;
    }

    public int[] getPrecio() {
        return precio;
    }

    public void setPrecio(int[] precio) {
        this.precio = precio;
    }

}
