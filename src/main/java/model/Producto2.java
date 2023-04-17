package model;

public class Producto2 {
    private String producto;
    private String id;
    private String producto2;
    private String id2;

    public Producto2(String producto,String id) {
        this.producto = producto;
        this.id=id;

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getId() {
        return id;
    }

    public String getProducto() {
        return producto;
    }
}
