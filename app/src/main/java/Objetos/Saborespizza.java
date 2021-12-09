package Objetos;

public class Saborespizza {
    private int id;
    private String[] nombre={"Pizza Napolitana","Pizza Predilecta","Pizza Vegana","Pizza Selecta"};
    private int[] precio={12500,13800,15600,18600};

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
