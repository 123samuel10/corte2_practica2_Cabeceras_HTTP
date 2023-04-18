package model;

public class Estudiante {
    private String nombre;
    private String contraseña;

    public Estudiante(String nombre,String contraseña) {
        this.nombre = nombre;
        this.contraseña=contraseña;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
