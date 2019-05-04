package Juego;

import java.awt.Color;
import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Portada extends JFrame implements ActionListener {



    public JLabel portada = new JLabel();
    ImageIcon imaPor = new ImageIcon("MenuPrincipal.jpg");
    private JButton boton2;
    private JButton boton1;
    private JButton boton3;
    private JButton botonF;

    public Portada() {
      this.setLayout(null);
      this.boton2 = new JButton("Score");
      this.boton2.setBounds(600, 330, 200, 40);
      this.add(this.boton2);
      this.boton2.addActionListener(this);
      this.boton2.setBackground(Color.white);
      this.boton3 = new JButton("Salir");
      this.boton3.setBounds(600, 380, 200, 40);
      this.add(this.boton3);
      this.boton3.addActionListener(this);
      this.boton3.setBackground(Color.white);
      this.boton1 = new JButton("Reglas");
      this.boton1.setBounds(600, 280, 200, 40);
      this.add(this.boton1);
      this.boton1.addActionListener(this);
      this.boton1.setBackground(Color.white);
      this.botonF = new JButton("Comenzar juego");
      this.botonF.setBounds(600, 230, 200, 40);
      this.add(this.botonF);
      this.botonF.addActionListener(this);
      this.botonF.setBackground(Color.white);
      this.setTitle("Captura La Bandera");
      this.setResizable(false);
      this.setSize(965, 738);
      this.setLocation(100, 10);
      this.setVisible(true);
      Container var1 = this.getContentPane();
      this.portada.setIcon(this.imaPor);
      this.portada.setBounds(0, 0, 960, 700);
      var1.add(this.portada);
    }

    public void actionPerformed(ActionEvent var1) {
      if (var1.getSource() == this.botonF) {
        System.out.println("BIENVENIDO AL JUEGO");
        this.setVisible(false);
        new Proyecto();
      }

      if (var1.getSource() == this.boton2) {
        System.out.println("Puntaje");
        this.setVisible(false);
        new Score();
      }

      if (var1.getSource() == this.boton3) {
        System.out.println("HASTA LUEGO");
        System.exit(0);
      }

      if (var1.getSource() == this.boton1) {
        System.out.println("Reglas");
        new Reglas();
        this.setVisible(true);
        this.dispose();
      }

    }

    public static void main(String[] var0) {
      new Portada();

      try {
        Clip var1 = AudioSystem.getClip();
        var1.open(AudioSystem.getAudioInputStream(new File("My Plague.wav")));
        var1.start();

        while(true) {
          if (!var1.isRunning()) {
            Thread.sleep(8500L);
            var1.close();
            break;


          }
        }
      } catch (Exception var2) {
        System.out.println("" + var2);
      }

      System.out.println("Bienvenido al menu de inicio");
    }
  }


