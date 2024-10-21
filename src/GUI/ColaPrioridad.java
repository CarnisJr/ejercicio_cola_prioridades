package GUI;

import Logica.Cliente;
import Logica.Cola;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColaPrioridad {
    private JPanel ColaPrioridad;
    private JTextField textField1;
    private JTextField textField2;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton nuevoClienteButton;
    private JButton atenderClienteButton;
    private Cola cola = new Cola();

    public ColaPrioridad() {
        nuevoClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Cliente nuevoCliente = new Cliente(textField1.getText());
                cola.enqeue(nuevoCliente, Integer.parseInt(textField2.getText()), textArea1);
            }
        });

        atenderClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cola.deqeue(textArea1, textArea2);

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ColaPrioridad");
        frame.setContentPane(new ColaPrioridad().ColaPrioridad);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
