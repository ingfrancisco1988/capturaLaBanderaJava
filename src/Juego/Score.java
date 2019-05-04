package Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

class Score extends JFrame implements ActionListener {
  public JButton botonreg;
  TextArea comoJugar = new TextArea("");
  FileInputStream fin;
  DataInputStream archl;
  String aux = "";

  public Score() {
    Container var1 = this.getContentPane();
    var1.setLayout((LayoutManager)null);
    this.comoJugar.setBounds(10, 10, 800, 400);
    this.comoJugar.setEditable(false);
    var1.add(this.comoJugar);
    this.setLayout((LayoutManager)null);
    this.botonreg = new JButton("Regresar al menú principal");
    this.botonreg.setBounds(300, 420, 200, 40);
    this.add(this.botonreg);
    this.botonreg.addActionListener(this);
    this.botonreg.setBackground(Color.white);

    try {
      this.fin = new FileInputStream("Puntaje.txt");
      this.archl = new DataInputStream(this.fin);

      do {
        this.aux = this.archl.readLine();
        if (this.aux == null) {
          break;
        }

        this.comoJugar.setText(this.comoJugar.getText() + "\n" + this.aux);
      } while(this.aux != null || this.aux != "");
    } catch (IOException var3) {
      System.out.println(var3.getMessage());
    }

    this.setTitle("Captura la bandera / Puntaje del juego ");
    this.setResizable(false);
    this.setSize(850, 500);
    this.setLocation(100, 10);
    this.setVisible(true);
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
    new Score();
  }
}
