package Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Reglas extends JFrame implements ActionListener {
  public JLabel portada = new JLabel();
  ImageIcon imaPor = new ImageIcon("Ventana de Reglas.JPG");
  private JButton botonreg;

  public Reglas() {
    this.setLayout((LayoutManager)null);
    this.botonreg = new JButton("Regresar al menú principal");
    this.botonreg.setBounds(735, 600, 200, 40);
    this.add(this.botonreg);
    this.botonreg.addActionListener(this);
    this.botonreg.setBackground(Color.white);
    this.setTitle("Reglas Del Juego");
    this.setResizable(true);
    this.setSize(965, 745);
    this.setLocation(100, 10);
    this.setVisible(true);
    Container var1 = this.getContentPane();
    var1.setLayout((LayoutManager)null);
    this.portada.setIcon(this.imaPor);
    this.portada.setBounds(0, 0, 960, 700);
    var1.add(this.portada);
  }

  public void actionPerformed(ActionEvent var1) {
    if (var1.getSource() == this.botonreg) {
      System.out.println("Regresar al menu principal");
      new Portada();
      this.setVisible(true);
      this.dispose();
    }

  }

  public static void main(String[] var0) {
    new Reglas();
    System.out.println("Reglas del juego");
  }
}