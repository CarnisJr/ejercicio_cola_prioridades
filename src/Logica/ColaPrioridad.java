package Logica;

import javax.swing.*;

/**
 * Pila es una clase que define una estructura de datos que sigue el principio FIFO. Para su implementacion se va
 * a hacer uso del concepto de listas enlazadas.
 * @author Christopher Miranda
 */

public class ColaPrioridad {

    private Nodo inicio;
    private Nodo fin;
    private int tamanio;
    private String atendidosString = "";

    /**
     * Se crea una cola de prioridad sin recibir parámetros
     */
    public ColaPrioridad() {

        this.inicio = null;
        this.fin = null;
        this.tamanio = 0;
    }

    /**
     * Devuelve un booleano si la cola está vacía o no
     * @return devuelve el estado de la pila
     */
    public boolean isEmpty(){

        return this.inicio == null && this.fin == null;
    }

    /**
     * Agrega un elemento a la cola
     * @param cliente una instacia de la clase Cliente
     * @param prioridad valor entero que denota del cliente prioridad
     * @param textArea area de texto de Swing UI
     */
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

    /**
     * Se encarga de sacar a un cliente de la cola
     * @param textArea es un area de texto donde se visualizan los clientes en la cola
     * @param textArea2 es un area de texto donde se visualizan los clientes atendidos
     */
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

    /**
     * Devuelve los nombres de los clientes y la prioridad de cada uno de ellos
     * @return devuelve un string donde se ha concatenado la informacion de los clientes
     */
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

    /**
     * Refresca el área de texto donde se visualiza los clientes a la cola
     * @param textArea un area de texto
     */
    public void refresh(JTextArea textArea){
        textArea.setText("Clientes en cola: " + this.tamanio + "\n" + showClientes());
    }
}
