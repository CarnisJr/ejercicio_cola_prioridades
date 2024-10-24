package Logica;

public class Nodo {

    private Cliente cliente;
    private Nodo proximo;
    private int prioridad;

    /**
     * Para crear un Nodo se debe introducir su valor y reservar la memoria para el siguiente nodo
     * @param cliente valor del nodo
     * @param proximo reserva de memoria para el siguiente nodo, siempre se debe ser null
     * @param prioridad la prioridad que tiene el nodo
     */
    //Siempre en null proximo
    public Nodo(Cliente cliente, int prioridad, Nodo proximo) {

        this.cliente = cliente;
        this.prioridad = prioridad;
        this.proximo = proximo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Nodo getProximo() {
        return proximo;
    }

    public void setProximo(Nodo proximo) {
        this.proximo = proximo;
    }

    public int getPrioridad() {
        return this.prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
}
