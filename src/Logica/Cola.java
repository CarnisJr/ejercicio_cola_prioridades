package Logica;

import javax.swing.*;

public class Cola {

    private Nodo inicio;
    private Nodo fin;
    private int tamanio;
    private String atendidosString = "";

    public Cola() {

        this.inicio = null;
        this.fin = null;
        this.tamanio = 0;
    }

    public boolean isEmpty(){

        return this.inicio == null && this.fin == null;
    }

    public void enqeue(Cliente cliente, int prioridad, JTextArea textArea){

        Nodo nuevoCliente = new Nodo(cliente, prioridad, null);

        if(isEmpty() || nuevoCliente.getPrioridad() < this.inicio.getPrioridad()){

            nuevoCliente.setProximo(this.inicio);
            this.inicio = nuevoCliente;
        }else{

            Nodo aux = this.inicio;
            while(aux.getProximo() != null && aux.getProximo().getPrioridad() <= nuevoCliente.getPrioridad()) {

                aux = aux.getProximo();
            }

            nuevoCliente.setProximo(aux.getProximo());
            aux.setProximo(nuevoCliente);
        }
        tamanio++;
        refresh(textArea);
    }
    public void deqeue(JTextArea textArea, JTextArea textArea2){

        if(!isEmpty()){

            atendidosString += this.inicio.getCliente().getNombre() + " Ha sido atendida, prioridad:  " + this.inicio.getPrioridad() + "\n";
            textArea2.setText(atendidosString);
            if(this.inicio == this.fin){

                this.inicio = this.fin = null;
            }else{

                this.inicio = this.inicio.getProximo();
            }
            tamanio--;
        }else{

            JOptionPane.showMessageDialog(null, "Vacio");
        }
        refresh(textArea);
    }

    public String showClientes(){

        StringBuilder clientesEnCola = new StringBuilder();
        Nodo aux = inicio;
        if(!isEmpty()){

            while(aux != null){

                clientesEnCola.append("Nombre: ").append(aux.getCliente().getNombre()).append(" Prioridad: ").append(aux.getPrioridad()).append("\n");
                aux = aux.getProximo();
            }
        }

        return clientesEnCola.toString();
    }

    public void refresh(JTextArea textArea){
        textArea.setText("Clientes en cola: " + this.tamanio + "\n" + showClientes());
    }
}
