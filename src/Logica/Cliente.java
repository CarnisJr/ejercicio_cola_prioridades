package Logica;

public class Cliente {

    private String nombre;

    /**
     * Para crear una instancia de la clase Cliente se necesita un solo parametro
     * @param nombre nombre del cliente en cadena de texto
     */
    public Cliente(String nombre) {

        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }
}
