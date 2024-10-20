package Logica;

public class Nodo {

    private Cliente cliente;
    private Nodo proximo;
    private int prioridad;

    //Siempre en null proximo
    public Nodo(Cliente cliente, Nodo proximo) {

        this.cliente = cliente;
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
}
