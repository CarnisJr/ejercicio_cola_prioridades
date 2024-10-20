package Logica;

import javax.swing.*;

public class Cola {

    private Nodo inicio;
    private Nodo fin;
    private int tamanio;

    public Cola() {

        this.inicio = null;
        this.fin = null;
        this.tamanio = 0;
    }

    public boolean isEmpty(){

        return this.inicio == null && this.fin == null;
    }

    public void enqeue(Cliente cliente){

        Nodo nuevoCliente = new Nodo(cliente, null);

        if(isEmpty()){

            this.inicio = this.fin = nuevoCliente;
        }else{

            this.fin.setProximo(nuevoCliente);
            this.fin = nuevoCliente;
        }
    }
    public void deqeue(){

        if(isEmpty()){

            JOptionPane.showMessageDialog(null, "Vacio");
        }else{

            this.inicio = this.inicio.getProximo();
        }
    }


}
