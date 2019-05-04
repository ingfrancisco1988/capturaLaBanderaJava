package Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Proyecto extends JFrame implements ActionListener {
  private int xPos;
  private int yPos;
  Proyecto.MiPanel mipanel = new Proyecto.MiPanel();
  JPanel state = new JPanel();
  JMenuBar barra = new JMenuBar();
  JMenu archivo = new JMenu("Archivo");
  JMenuItem nova = new JMenuItem("Nuevo");
  JMenuItem exit = new JMenuItem("Salir");
  JMenuItem reg = new JMenuItem("Regresar");
  JLabel lblQTurno;
  JLabel lblShowTurno;
  JLabel BTurno1 = new JLabel("");
  JLabel BTurno2 = new JLabel("");
  JLabel puntaje1 = new JLabel("");
  JLabel movi1 = new JLabel("");
  JLabel puntaje2 = new JLabel("");
  JLabel movi2 = new JLabel("");
  JLabel l1;
  JLabel l2;
  JLabel jugador;
  JTextField lanz;
  JTextArea msgturn;
  JTextField txtQTurno;
  JTextField txtShowTurno;
  ImageIcon imag = new ImageIcon("tablero.JPG");
  ImageIcon imag1 = new ImageIcon("Player1.PNG");
  ImageIcon imag2 = new ImageIcon("Player2.PNG");
  ImageIcon imag3 = new ImageIcon("BanderaD.PNG");
  Icon Imageno = new ImageIcon("dados-04.GIF");
  Icon Imaganador = new ImageIcon("Ganador.GIF");
  Icon Imapunto = new ImageIcon("Punto.GIF");
  Icon Imatrampa = new ImageIcon("retrocede.GIF");
  Icon Imapturno = new ImageIcon("pturno.GIF");
  Icon Imatajo = new ImageIcon("atajo.GIF");
  Icon Imaopcin = new ImageIcon("opcin.GIF");
  Icon Imaperdban = new ImageIcon("pedbandera.GIF");
  Icon Imaganaban = new ImageIcon("BanderaD.PNG");
  JButton tiro = new JButton("Lanzar");
  String cap;
  String h;
  int n = 0;
  int k = 0;
  int f = 1;
  int contador1 = 0;
  int contador2 = 0;
  int e;
  int acumulador1 = 0;
  int acumulador2 = 0;
  public String[] Nombres = new String[2];
  int[] movx = new int[3];
  int[] movy = new int[3];
  int[] camino = new int[2];
  int[] pos = new int[2];
  int[] r = new int[2];
  int[] r_ant = new int[2];
  int[] pos_ant = new int[2];
  int[] j = new int[2];
  boolean movimiento = false;
  boolean pierd = false;
  boolean inicio = true;
  boolean patras = false;
  boolean medio = false;
  boolean atrapa = false;
  boolean[] regreso = new boolean[]{false, false};
  private java.util.Timer timer;
  int[] ji1x = new int[]{205, 226, 252, 278, 308, 338, 368, 394, 418, 448, 480};
  int[] ji1y = new int[]{270, 248, 232, 220, 212, 212, 223, 243, 258, 268, 296};
  int[] ji2x = new int[]{184, 212, 240, 268, 297, 325, 353, 384, 412, 442, 480};
  int[] ji2y = new int[]{296, 296, 296, 296, 296, 296, 296, 296, 296, 296, 296};
  int[] ji3x = new int[]{205, 224, 250, 278, 306, 336, 364, 388, 410, 448, 480};
  int[] ji3y = new int[]{325, 342, 358, 368, 383, 384, 371, 354, 330, 325, 296};
  int[] jd1x = new int[]{752, 730, 705, 678, 650, 622, 590, 567, 542, 512, 480};
  int[] jd1y = new int[]{265, 245, 230, 215, 210, 210, 220, 240, 257, 265, 296};
  int[] jd2x = new int[]{772, 744, 717, 690, 662, 633, 605, 577, 548, 520, 480};
  int[] jd2y = new int[]{296, 296, 296, 296, 296, 296, 296, 296, 296, 296, 296};
  int[] jd3x = new int[]{750, 733, 705, 679, 652, 624, 595, 571, 550, 513, 480};
  int[] jd3y = new int[]{320, 340, 355, 370, 380, 385, 370, 355, 330, 320, 296};
  int hora;
  int minutos;
  int dia;
  int mes;
  public Label HoraIni = new Label("Hora  ");
  Calendar calendario;

  public Proyecto() {
    super("Jugando");
    Container var1 = this.getContentPane();
    var1.setLayout((LayoutManager)null);
    new ImageIcon("d.GIF");
    Calendar var3 = Calendar.getInstance();
    this.hora = var3.get(10);
    this.minutos = var3.get(12);
    this.mes = 8;
    this.dia = var3.get(5);
    this.HoraIni.setText("Fecha: " + this.dia + "/" + this.mes + " -  Hora " + this.hora + " : " + this.minutos);
    this.HoraIni.setBounds(650, 10, 300, 20);
    this.HoraIni.setFont(new Font("ARIAL", 1, 18));
    var1.add(this.HoraIni);
    this.nova.addActionListener(this);
    this.archivo.add(this.nova);
    this.reg.addActionListener(this);
    this.archivo.add(this.reg);
    this.exit.addActionListener(this);
    this.archivo.add(this.exit);
    this.barra.add(this.archivo);
    this.setJMenuBar(this.barra);
    this.BTurno1 = new JLabel("Jugador1");
    this.BTurno1.setBounds(52, 127, 100, 100);
    this.BTurno1.setFont(new Font("ARIAL", 1, 18));
    this.add(this.BTurno1);
    this.BTurno2 = new JLabel("Jugador2");
    this.BTurno2.setBounds(860, 128, 100, 100);
    this.BTurno2.setFont(new Font("ARIAL", 1, 18));
    this.add(this.BTurno2);
    this.puntaje1 = new JLabel("0");
    this.puntaje1.setBounds(48, 160, 100, 100);
    this.puntaje1.setFont(new Font("ARIAL", 1, 18));
    this.add(this.puntaje1);
    this.movi1 = new JLabel("0");
    this.movi1.setBounds(43, 190, 100, 100);
    this.movi1.setFont(new Font("ARIAL", 1, 18));
    this.add(this.movi1);
    this.puntaje2 = new JLabel("0");
    this.puntaje2.setBounds(943, 162, 100, 100);
    this.puntaje2.setFont(new Font("ARIAL", 1, 18));
    this.add(this.puntaje2);
    this.movi2 = new JLabel("0");
    this.movi2.setBounds(935, 193, 100, 100);
    this.movi2.setFont(new Font("ARIAL", 1, 18));
    this.add(this.movi2);
    this.lblQTurno = new JLabel("Turno de:");
    this.lblQTurno.setBounds(280, 5, 220, 20);
    this.lblQTurno.setFont(new Font("Calibri", 1, 18));
    this.state.add(this.lblQTurno);
    this.lblShowTurno = new JLabel("");
    this.lblShowTurno.setBounds(280, 5, 220, 20);
    this.lblShowTurno.setFont(new Font("Calibri", 1, 18));
    this.state.add(this.lblShowTurno);
    this.l1 = new JLabel("", new ImageIcon("dados-04.GIF"), 0);
    this.l1.setBounds(0, 0, 100, 100);
    this.state.add(this.l1);
    this.tiro.setBounds(120, 40, 80, 35);
    this.tiro.addActionListener(this);
    this.state.add(this.tiro);
    this.tiro.setBackground(Color.yellow);
    this.tiro.setForeground(Color.black);
    this.lanz = new JTextField();
    this.lanz.setEditable(false);
    this.lanz.setBackground(Color.blue);
    this.lanz.setForeground(Color.red);
    this.lanz.setBounds(140, 10, 40, 20);
    this.lanz.setFont(new Font("Calibri", 1, 18));
    this.state.add(this.lanz);
    this.setLayout((LayoutManager)null);
    this.state.setLayout((LayoutManager)null);
    this.state.setBounds(0, 0, 1024, 80);
    this.mipanel.setBounds(0, 80, 1024, 900);
    this.state.setBackground(Color.white);
    this.add(this.state);
    this.add(this.mipanel);
    this.setResizable(false);
    this.setSize(1030, 730);
    this.setVisible(true);
    this.movx[0] = 156;
    this.movy[0] = 299;
    this.movx[1] = 800;
    this.movy[1] = 299;
    this.movx[2] = 490;
    this.movy[2] = 296;

    int var4;
    for(var4 = 0; var4 < 2; ++var4) {
      this.cap = JOptionPane.showInputDialog("Introduza el nombre del jugador " + (var4 + 1));
      this.Nombres[var4] = this.cap;
      this.lblShowTurno.setText("" + this.Nombres[this.f]);
      this.lblShowTurno.setText("");
      this.lblShowTurno.setBounds(280, 5, 100, 50);
      this.lblShowTurno.setFont(new Font("Calibri", 1, 18));
      this.state.add(this.lblShowTurno);
      this.BTurno1.setText("" + this.Nombres[0]);
      String var5 = JOptionPane.showInputDialog("Indique cual camino va a seguir 1, 2, 3 : ");
      if (validar(var5) && Integer.parseInt(var5) > 0 & Integer.parseInt(var5) < 4) {
        this.r[var4] = Integer.parseInt(var5);
      } else {
        JOptionPane.showMessageDialog((Component)null, "Opcion invalida intente de nuevo", "Opcion invalida", -1, this.Imaopcin);
      }
    }

    this.BTurno2.setText("" + this.Nombres[1]);

    for(var4 = 0; var4 < 2; ++var4) {
      this.pos[var4] = -1;
      this.camino[var4] = this.r[var4];
    }

    this.timer = new Timer();
    this.timer.schedule(new Proyecto.RemindTask(), 0L, 500L);
  }

  public void actionPerformed(ActionEvent var1) {
    if (var1.getSource() == this.nova) {
      this.setVisible(false);
      new Proyecto();
    }

    if (var1.getSource() == this.exit) {
      System.exit(0);
    }

    if (var1.getSource() == this.reg) {
      this.setVisible(false);
      new Portada();
    }

    if (var1.getSource() == this.tiro) {
      ++this.f;
      if (this.pos[0] == 10 && this.medio) {
        this.f = 0;
        this.medio = false;
      }

      if (this.pos[1] == 10 && this.medio) {
        this.f = 1;
        this.medio = false;
      }

      if (this.f > 1) {
        this.f = 0;
      }

      this.pos_ant[this.f] = this.pos[this.f];
      this.r_ant[this.f] = this.camino[this.f];
      this.dado();
      this.movimiento = true;
      this.pierd = false;
    }

  }

  public static boolean validar(String var0) {
    if (var0.length() == 0) {
      return false;
    } else {
      int var1;
      if (var0.indexOf(45) == 0) {
        var1 = 1;
      } else {
        var1 = 0;
      }

      while(var1 < var0.length() && Character.isDigit(var0.charAt(var1))) {
        ++var1;
      }

      return var1 == var0.length();
    }
  }

  void jugador1(int var1, int var2) {
    if (var2 == 1) {
      this.movx[this.f] = this.ji1x[var1];
      this.movy[this.f] = this.ji1y[var1];
    }

    if (var2 == 2) {
      this.movx[this.f] = this.ji2x[var1];
      this.movy[this.f] = this.ji2y[var1];
    }

    if (var2 == 3) {
      this.movx[this.f] = this.ji3x[var1];
      this.movy[this.f] = this.ji3y[var1];
    }

    this.repaint();
  }

  void jugador2(int var1, int var2) {
    if (var2 == 1) {
      this.movx[this.f] = this.jd1x[var1];
      this.movy[this.f] = this.jd1y[var1];
    }

    if (var2 == 2) {
      this.movx[this.f] = this.jd2x[var1];
      this.movy[this.f] = this.jd2y[var1];
    }

    if (var2 == 3) {
      this.movx[this.f] = this.jd3x[var1];
      this.movy[this.f] = this.jd3y[var1];
    }

    this.repaint();
  }

  void dado() {
    do {
      this.e = (int)(Math.random() * 7.0D);
    } while(this.e < 1);

    this.lanz.setText("" + this.e);
    if (this.f == 0) {
      this.acumulador1 += this.e;
      this.movi1.setText("" + this.acumulador1);
    } else {
      this.acumulador2 += this.e;
      this.movi2.setText("" + this.acumulador2);
    }

  }

  public static void main(String[] var0) {
    new Proyecto();
  }

  void pregunta() {
    boolean var2 = false;

    do {
      String var1 = JOptionPane.showInputDialog("Elija el camino por el cual desea continuar(1,2,3): ");
      if (validar(var1) && Integer.parseInt(var1) > 0 & Integer.parseInt(var1) < 4) {
        var2 = true;
        this.r[this.f] = Integer.parseInt(var1);
        this.camino[this.f] = this.r[this.f];
      } else {
        JOptionPane.showMessageDialog((Component)null, "Opcion invalida intente de nuevo", "Opcion invalida", -1, this.Imaopcin);
      }
    } while(!var2);

  }

  void guardarScore() {
    int var5 = 0;

    try {
      FileInputStream var3 = new FileInputStream("Puntaje.txt");
      DataInputStream var4 = new DataInputStream(var3);
      String var6 = "";

      do {
        var6 = var4.readLine();
        if (var6 == null) {
          break;
        }

        ++var5;
      } while(var6 != null || var6 != "");

      String[] var7 = new String[var5];
      var3 = new FileInputStream("Puntaje.txt");
      var4 = new DataInputStream(var3);

      int var8;
      for(var8 = 0; var8 < var5; ++var8) {
        var6 = var4.readLine();
        var7[var8] = var6;
      }

      try {
        FileOutputStream var1 = new FileOutputStream("Puntaje.txt");
        PrintStream var2 = new PrintStream(var1);

        for(var8 = 0; var8 < var5; ++var8) {
          var2.println("" + var7[var8]);
        }

        var2.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        var2.println("");
        if (this.f == 0) {
          var2.println("" + this.Nombres[this.f] + " Gano en " + this.acumulador1 + " movimientos" + this.HoraIni.getText());
          var2.println("" + this.Nombres[this.f + 1] + " Perdio con " + this.acumulador2 + " movimientos" + this.HoraIni.getText());
        } else {
          var2.println("" + this.Nombres[this.f] + " Gano en " + this.acumulador2 + " movimientos" + this.HoraIni.getText());
          var2.println("" + this.Nombres[this.f - 1] + " Perdio con " + this.acumulador1 + " movimientos" + this.HoraIni.getText());
        }

        var2.close();
      } catch (IOException var9) {
        System.out.println(var9.getMessage());
      }
    } catch (IOException var10) {
      System.out.println(var10.getMessage());
    }

  }

  public class MiPanel extends JPanel {
    public MiPanel() {
    }

    public void paint(Graphics var1) {
      Proyecto.this.imag.paintIcon(this, var1, 0, 0);
      Proyecto.this.imag1.paintIcon(this, var1, Proyecto.this.movx[0], Proyecto.this.movy[0]);
      Proyecto.this.imag2.paintIcon(this, var1, Proyecto.this.movx[1], Proyecto.this.movy[1]);
      Proyecto.this.imag3.paintIcon(this, var1, Proyecto.this.movx[2], Proyecto.this.movy[2]);
    }
  }

  private class RemindTask extends TimerTask {
    private RemindTask() {
    }

    public void run() {
      int var10002;
      if (Proyecto.this.movimiento) {
        ++Proyecto.this.k;
        int var1;
        String var2;
        if (!Proyecto.this.regreso[Proyecto.this.f]) {
          if ((Proyecto.this.camino[Proyecto.this.f] == 1 || Proyecto.this.camino[Proyecto.this.f] == 2 || Proyecto.this.camino[Proyecto.this.f] == 3) && !Proyecto.this.regreso[Proyecto.this.f]) {
            if (Proyecto.this.pos[Proyecto.this.f] + 1 <= 9) {
              if (Proyecto.this.f == 0) {
                var10002 = Proyecto.this.pos[Proyecto.this.f]++;
                Proyecto.this.jugador1(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
              } else if (Proyecto.this.f == 1) {
                var10002 = Proyecto.this.pos[Proyecto.this.f]++;
                Proyecto.this.jugador2(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
              }
            } else if (Proyecto.this.inicio) {
              if (Proyecto.this.f == 0) {
                Proyecto.this.imag3 = new ImageIcon("");
                Proyecto.this.imag1 = new ImageIcon("EDIT.PNG");
                var10002 = Proyecto.this.pos[Proyecto.this.f]++;
                Proyecto.this.jugador1(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
                Proyecto.this.k = Proyecto.this.e;
                JOptionPane.showMessageDialog((Component)null, "El jugador " + Proyecto.this.Nombres[Proyecto.this.f] + " tiene la bandera", "Has ganado la Bandera", -1, Proyecto.this.Imaganaban);
                Proyecto.this.pregunta();
                Proyecto.this.medio = true;
                Proyecto.this.inicio = false;
                Proyecto.this.patras = false;
              } else {
                Proyecto.this.imag3 = new ImageIcon("");
                Proyecto.this.imag2 = new ImageIcon("EDIT2.PNG");
                var10002 = Proyecto.this.pos[Proyecto.this.f]++;
                Proyecto.this.jugador2(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
                Proyecto.this.k = Proyecto.this.e;
                JOptionPane.showMessageDialog((Component)null, "El jugador " + Proyecto.this.Nombres[Proyecto.this.f] + " tiene la bandera", "Has ganado la Bandera", -1, Proyecto.this.Imaganaban);
                Proyecto.this.pregunta();
                Proyecto.this.inicio = false;
                Proyecto.this.patras = true;
                Proyecto.this.medio = true;
              }

              Proyecto.this.regreso[Proyecto.this.f] = true;
              JOptionPane.showMessageDialog((Component)null, "Vuelves a lanzar dados", "Dados", -1, Proyecto.this.Imageno);
            } else {
              if (Proyecto.this.f == 0) {
                var10002 = Proyecto.this.pos[Proyecto.this.f]++;
                Proyecto.this.jugador1(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
                JOptionPane.showMessageDialog((Component)null, "Vas perdiendo recupera la bandera", "Has perdido la Bandera", -1, Proyecto.this.Imaperdban);
                Proyecto.this.pregunta();
                Proyecto.this.patras = true;
                Proyecto.this.atrapa = true;
              } else {
                var10002 = Proyecto.this.pos[Proyecto.this.f]++;
                Proyecto.this.jugador2(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
                JOptionPane.showMessageDialog((Component)null, "Vas perdiendo recupera la bandera", "Has perdido la Bandera", -1, Proyecto.this.Imaperdban);
                Proyecto.this.pregunta();
                Proyecto.this.patras = false;
                Proyecto.this.atrapa = true;
              }

              if (Proyecto.this.pos[0] == Proyecto.this.pos[1] || Proyecto.this.pos[1] == Proyecto.this.pos[0]) {
                if (Proyecto.this.f == 0) {
                  JOptionPane.showMessageDialog((Component)null, "Has atrapado a " + Proyecto.this.Nombres[1] + " ganas 1 punto", "Punto", -1, Proyecto.this.Imapunto);
                  Proyecto.this.imag1 = new ImageIcon("Player1.PNG");
                  Proyecto.this.imag2 = new ImageIcon("Player2.PNG");
                  Proyecto.this.imag3 = new ImageIcon("BanderaD.PNG");
                  ++Proyecto.this.contador1;
                  Proyecto.this.puntaje1.setText("" + Proyecto.this.contador1);
                  if (Proyecto.this.contador1 >= 3) {
                    JOptionPane.showMessageDialog((Component)null, "El jugador " + Proyecto.this.Nombres[Proyecto.this.f] + " Ha ganado", "Ganador", -1, Proyecto.this.Imaganador);
                    if (Proyecto.this.f == 0) {
                      Proyecto.this.guardarScore();
                    } else {
                      Proyecto.this.guardarScore();
                    }

                    Proyecto.this.movimiento = false;
                    if (Proyecto.this.contador1 >= 3) {
                      var1 = JOptionPane.showConfirmDialog((Component)null, "¿Desea salir al menu principal?");
                      if (var1 == 0) {
                        Proyecto.this.setVisible(false);
                        new Portada();
                      } else if (var1 == 1) {
                        System.exit(0);
                      }
                    }
                  }

                  for(var1 = 0; var1 < 2; ++var1) {
                    Proyecto.this.movx[0] = 156;
                    Proyecto.this.movy[0] = 299;
                    Proyecto.this.movx[1] = 800;
                    Proyecto.this.movy[1] = 299;
                    Proyecto.this.movx[2] = 490;
                    Proyecto.this.movy[2] = 296;
                    Proyecto.this.repaint();
                    var2 = JOptionPane.showInputDialog("Indique cual camino va a seguir 1, 2, 3 : ");
                    if (Proyecto.validar(var2) && Integer.parseInt(var2) > 0 & Integer.parseInt(var2) < 4) {
                      Proyecto.this.r[var1] = Integer.parseInt(var2);
                    } else {
                      JOptionPane.showMessageDialog((Component)null, "Opcion invalida intente de nuevo", "Opcion invalida", -1, Proyecto.this.Imaopcin);
                    }

                    Proyecto.this.pos[var1] = -1;
                    Proyecto.this.camino[var1] = Proyecto.this.r[var1];
                    Proyecto.this.regreso[var1] = false;
                    Proyecto.this.pierd = false;
                    Proyecto.this.inicio = true;
                    Proyecto.this.patras = false;
                    Proyecto.this.medio = false;
                  }

                  Proyecto.this.k = Proyecto.this.e;
                  Proyecto.this.atrapa = false;
                } else {
                  JOptionPane.showMessageDialog((Component)null, "Has atrapado a " + Proyecto.this.Nombres[0] + " Ganas 1 punto", "Punto", -1, Proyecto.this.Imapunto);
                  Proyecto.this.imag1 = new ImageIcon("Player1.PNG");
                  Proyecto.this.imag2 = new ImageIcon("Player2.PNG");
                  Proyecto.this.imag3 = new ImageIcon("BanderaD.PNG");
                  ++Proyecto.this.contador2;
                  Proyecto.this.puntaje2.setText("" + Proyecto.this.contador2);
                  if (Proyecto.this.contador2 >= 3) {
                    JOptionPane.showMessageDialog((Component)null, "El jugador " + Proyecto.this.Nombres[Proyecto.this.f] + " Ha ganado", "Ganador", -1, Proyecto.this.Imaganador);
                    if (Proyecto.this.f == 0) {
                      Proyecto.this.guardarScore();
                    } else {
                      Proyecto.this.guardarScore();
                    }

                    Proyecto.this.movimiento = false;
                    if (Proyecto.this.contador2 >= 3) {
                      var1 = JOptionPane.showConfirmDialog((Component)null, "¿Desea salir al menu principal?");
                      if (var1 == 0) {
                        Proyecto.this.setVisible(false);
                        new Portada();
                      } else if (var1 == 1) {
                        System.exit(0);
                      }
                    }
                  }

                  for(var1 = 0; var1 < 2; ++var1) {
                    Proyecto.this.movx[0] = 156;
                    Proyecto.this.movy[0] = 299;
                    Proyecto.this.movx[1] = 800;
                    Proyecto.this.movy[1] = 299;
                    Proyecto.this.movx[2] = 490;
                    Proyecto.this.movy[2] = 296;
                    Proyecto.this.repaint();
                    var2 = JOptionPane.showInputDialog("Indique cual camino va a seguir 1, 2, 3 : ");
                    if (Proyecto.validar(var2) && Integer.parseInt(var2) > 0 & Integer.parseInt(var2) < 4) {
                      Proyecto.this.r[var1] = Integer.parseInt(var2);
                    } else {
                      JOptionPane.showMessageDialog((Component)null, "Opcion invalida intente de nuevo", "Opcion invalida", -1, Proyecto.this.Imaopcin);
                    }

                    Proyecto.this.pos[var1] = -1;
                    Proyecto.this.camino[var1] = Proyecto.this.r[var1];
                    Proyecto.this.regreso[var1] = false;
                    Proyecto.this.pierd = false;
                    Proyecto.this.inicio = true;
                    Proyecto.this.patras = false;
                    Proyecto.this.medio = false;
                  }

                  Proyecto.this.k = Proyecto.this.e;
                  Proyecto.this.atrapa = false;
                }
              }

              Proyecto.this.regreso[Proyecto.this.f] = true;
            }
          }
        } else if (Proyecto.this.pos[Proyecto.this.f] - 1 < 0) {
          JOptionPane.showMessageDialog((Component)null, "El jugador " + Proyecto.this.Nombres[Proyecto.this.f] + " Ha ganado", "Ganador", -1, Proyecto.this.Imaganador);
          if (Proyecto.this.f == 0) {
            Proyecto.this.contador1 = 3;
            Proyecto.this.guardarScore();
          } else {
            Proyecto.this.contador2 = 3;
            Proyecto.this.guardarScore();
          }

          Proyecto.this.movimiento = false;
          if (Proyecto.this.contador1 >= 3 || Proyecto.this.contador2 >= 3) {
            var1 = JOptionPane.showConfirmDialog((Component)null, "¿Desea salir al menu principal?");
            if (var1 == 0) {
              Proyecto.this.setVisible(false);
              new Portada();
            } else if (var1 == 1) {
              System.exit(0);
            }
          }
        } else if (Proyecto.this.patras) {
          var10002 = Proyecto.this.pos[Proyecto.this.f]--;
          Proyecto.this.jugador2(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          if (Proyecto.this.pos[1] == Proyecto.this.pos[0] && Proyecto.this.camino[1] == Proyecto.this.camino[0] && Proyecto.this.atrapa) {
            JOptionPane.showMessageDialog((Component)null, "Has atrapado a " + Proyecto.this.Nombres[1] + " Ganas 1 punto", "Punto", -1, Proyecto.this.Imapunto);
            Proyecto.this.imag1 = new ImageIcon("Player1.PNG");
            Proyecto.this.imag2 = new ImageIcon("Player2.PNG");
            Proyecto.this.imag3 = new ImageIcon("BanderaD.PNG");
            ++Proyecto.this.contador1;
            Proyecto.this.puntaje1.setText("" + Proyecto.this.contador1);
            if (Proyecto.this.contador1 >= 3) {
              JOptionPane.showMessageDialog((Component)null, "El jugador " + Proyecto.this.Nombres[Proyecto.this.f] + " Ha ganado", "Ganador", -1, Proyecto.this.Imaganador);
              if (Proyecto.this.f == 0) {
                Proyecto.this.guardarScore();
              } else {
                Proyecto.this.guardarScore();
              }

              Proyecto.this.movimiento = false;
              if (Proyecto.this.contador1 >= 3) {
                var1 = JOptionPane.showConfirmDialog((Component)null, "¿Desea salir al menu principal?");
                if (var1 == 0) {
                  Proyecto.this.setVisible(false);
                  new Portada();
                } else if (var1 == 1) {
                  System.exit(0);
                }
              }
            }

            var1 = 0;

            while(true) {
              if (var1 >= 2) {
                Proyecto.this.k = Proyecto.this.e;
                Proyecto.this.atrapa = false;
                break;
              }

              Proyecto.this.movx[0] = 156;
              Proyecto.this.movy[0] = 299;
              Proyecto.this.movx[1] = 800;
              Proyecto.this.movy[1] = 299;
              Proyecto.this.movx[2] = 490;
              Proyecto.this.movy[2] = 296;
              Proyecto.this.repaint();
              var2 = JOptionPane.showInputDialog("Indique cual camino va a seguir 1, 2, 3 : ");
              if (Proyecto.validar(var2) && Integer.parseInt(var2) > 0 & Integer.parseInt(var2) < 4) {
                Proyecto.this.r[var1] = Integer.parseInt(var2);
              } else {
                JOptionPane.showMessageDialog((Component)null, "Opcion invalida intente de nuevo", "Opcion invalida", -1, Proyecto.this.Imaopcin);
              }

              Proyecto.this.pos[var1] = -1;
              Proyecto.this.camino[var1] = Proyecto.this.r[var1];
              Proyecto.this.regreso[var1] = false;
              Proyecto.this.pierd = false;
              Proyecto.this.inicio = true;
              Proyecto.this.patras = false;
              Proyecto.this.medio = false;
              ++var1;
            }
          }
        } else {
          var10002 = Proyecto.this.pos[Proyecto.this.f]--;
          Proyecto.this.jugador1(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          if (Proyecto.this.pos[0] == Proyecto.this.pos[1] && Proyecto.this.camino[0] == Proyecto.this.camino[1] && Proyecto.this.atrapa) {
            JOptionPane.showMessageDialog((Component)null, "Has atrapado a " + Proyecto.this.Nombres[0] + " Ganas 1 punto", "Punto", -1, Proyecto.this.Imapunto);
            Proyecto.this.imag1 = new ImageIcon("Player1.PNG");
            Proyecto.this.imag2 = new ImageIcon("Player2.PNG");
            Proyecto.this.imag3 = new ImageIcon("BanderaD.PNG");
            ++Proyecto.this.contador2;
            Proyecto.this.puntaje2.setText("" + Proyecto.this.contador2);
            if (Proyecto.this.contador2 >= 3) {
              JOptionPane.showMessageDialog((Component)null, "El jugador " + Proyecto.this.Nombres[Proyecto.this.f] + " Ha ganado", "Ganador", -1, Proyecto.this.Imaganador);
              if (Proyecto.this.f == 0) {
                Proyecto.this.guardarScore();
              } else {
                Proyecto.this.guardarScore();
              }

              Proyecto.this.movimiento = false;
              if (Proyecto.this.contador2 >= 3) {
                var1 = JOptionPane.showConfirmDialog((Component)null, "¿Desea salir al menu principal?");
                if (var1 == 0) {
                  Proyecto.this.setVisible(false);
                  new Portada();
                } else if (var1 == 1) {
                  System.exit(0);
                }
              }
            }

            var1 = 0;

            while(true) {
              if (var1 >= 2) {
                Proyecto.this.k = Proyecto.this.e;
                Proyecto.this.atrapa = false;
                break;
              }

              Proyecto.this.movx[0] = 156;
              Proyecto.this.movy[0] = 299;
              Proyecto.this.movx[1] = 800;
              Proyecto.this.movy[1] = 299;
              Proyecto.this.movx[2] = 490;
              Proyecto.this.movy[2] = 296;
              Proyecto.this.repaint();
              var2 = JOptionPane.showInputDialog("Indique cual camino va a seguir 1, 2, 3 : ");
              if (Proyecto.validar(var2) && Integer.parseInt(var2) > 0 & Integer.parseInt(var2) < 4) {
                Proyecto.this.r[var1] = Integer.parseInt(var2);
              } else {
                JOptionPane.showMessageDialog((Component)null, "Opcion invalida intente de nuevo", "Opcion invalida", -1, Proyecto.this.Imaopcin);
              }

              Proyecto.this.pos[var1] = -1;
              Proyecto.this.camino[var1] = Proyecto.this.r[var1];
              Proyecto.this.regreso[var1] = false;
              Proyecto.this.pierd = false;
              Proyecto.this.inicio = true;
              Proyecto.this.patras = false;
              Proyecto.this.medio = false;
              ++var1;
            }
          }
        }

        if (Proyecto.this.k == Proyecto.this.e) {
          Proyecto.this.movimiento = false;
          Proyecto.this.k = 0;
        }
      }

      Proyecto.this.lblShowTurno.setText("" + Proyecto.this.Nombres[1 - Proyecto.this.f]);
      if (!Proyecto.this.movimiento && (Proyecto.this.camino[Proyecto.this.f] == 1 && Proyecto.this.pos[Proyecto.this.f] == 3 && Proyecto.this.f == 0 || Proyecto.this.camino[Proyecto.this.f] == 1 && Proyecto.this.pos[Proyecto.this.f] == 1 && Proyecto.this.f == 1 || Proyecto.this.camino[Proyecto.this.f] == 1 && Proyecto.this.pos[Proyecto.this.f] == 3 && Proyecto.this.f == 1 && Proyecto.this.regreso[Proyecto.this.f] || Proyecto.this.camino[Proyecto.this.f] == 1 && Proyecto.this.pos[Proyecto.this.f] == 1 && Proyecto.this.f == 0 && Proyecto.this.regreso[Proyecto.this.f])) {
        if (!Proyecto.this.regreso[Proyecto.this.f]) {
          Proyecto.this.pos[Proyecto.this.f] += 2;
          if (Proyecto.this.f == 0) {
            JOptionPane.showMessageDialog((Component)null, "Has conseguido un atajo avanzas 2 posiciones", "Atajo", -1, Proyecto.this.Imatajo);
            Proyecto.this.jugador1(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          } else {
            JOptionPane.showMessageDialog((Component)null, "Has conseguido un atajo avanzas 2 posiciones", "Atajo", -1, Proyecto.this.Imatajo);
            Proyecto.this.jugador2(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          }
        } else if (Proyecto.this.movimiento || (Proyecto.this.camino[Proyecto.this.f] != 1 || Proyecto.this.pos[Proyecto.this.f] != 3 || Proyecto.this.f != 0 || Proyecto.this.patras) && (Proyecto.this.camino[Proyecto.this.f] != 1 || Proyecto.this.pos[Proyecto.this.f] != 1 || Proyecto.this.f != 1 || !Proyecto.this.patras)) {
          if (!Proyecto.this.movimiento && (Proyecto.this.camino[Proyecto.this.f] == 1 && Proyecto.this.pos[Proyecto.this.f] == 3 && Proyecto.this.f == 0 && Proyecto.this.patras || Proyecto.this.camino[Proyecto.this.f] == 1 && Proyecto.this.pos[Proyecto.this.f] == 1 && Proyecto.this.f == 1 && !Proyecto.this.patras)) {
            Proyecto.this.e = 2;
            Proyecto.this.movimiento = true;
            JOptionPane.showMessageDialog((Component)null, "Has conseguido un atajo avanzas 2 posiciones", "Atajo", -1, Proyecto.this.Imatajo);
            if (Proyecto.this.f == 0) {
              Proyecto.this.jugador2(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
            }

            if (Proyecto.this.f == 1) {
              Proyecto.this.jugador1(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
            }
          }
        } else {
          Proyecto.this.e = 2;
          Proyecto.this.movimiento = true;
          JOptionPane.showMessageDialog((Component)null, "Has conseguido un atajo avanzas 2 posiciones", "Atajo", -1, Proyecto.this.Imatajo);
          if (Proyecto.this.f == 0) {
            Proyecto.this.jugador2(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          }

          if (Proyecto.this.f == 1) {
            Proyecto.this.jugador1(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          }
        }
      }

      if (!Proyecto.this.movimiento && (Proyecto.this.camino[Proyecto.this.f] == 2 && Proyecto.this.pos[Proyecto.this.f] == 7 && Proyecto.this.f == 0 || Proyecto.this.camino[Proyecto.this.f] == 2 && Proyecto.this.pos[Proyecto.this.f] == 6 && Proyecto.this.f == 1 || Proyecto.this.camino[Proyecto.this.f] == 2 && Proyecto.this.pos[Proyecto.this.f] == 7 && Proyecto.this.f == 1 && Proyecto.this.regreso[Proyecto.this.f] || Proyecto.this.camino[Proyecto.this.f] == 2 && Proyecto.this.pos[Proyecto.this.f] == 6 && Proyecto.this.f == 0 && Proyecto.this.regreso[Proyecto.this.f])) {
        if (!Proyecto.this.regreso[Proyecto.this.f]) {
          Proyecto.this.pos[Proyecto.this.f] += 2;
          if (Proyecto.this.f == 0) {
            JOptionPane.showMessageDialog((Component)null, "Has conseguido un atajo avanzas 2 posiciones", "Atajo", -1, Proyecto.this.Imatajo);
            Proyecto.this.jugador1(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          } else {
            JOptionPane.showMessageDialog((Component)null, "Has conseguido un atajo avanzas 2 posiciones", "Atajo", -1, Proyecto.this.Imatajo);
            Proyecto.this.jugador2(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          }
        } else if (!Proyecto.this.movimiento && (Proyecto.this.camino[Proyecto.this.f] == 2 && Proyecto.this.pos[Proyecto.this.f] == 7 && Proyecto.this.f == 0 && !Proyecto.this.patras || Proyecto.this.camino[Proyecto.this.f] == 2 && Proyecto.this.pos[Proyecto.this.f] == 6 && Proyecto.this.f == 1 && Proyecto.this.patras)) {
          Proyecto.this.e = 2;
          Proyecto.this.movimiento = true;
          JOptionPane.showMessageDialog((Component)null, "Has conseguido un atajo avanzas 2 posiciones", "Atajo", -1, Proyecto.this.Imatajo);
          if (Proyecto.this.f == 0) {
            Proyecto.this.jugador2(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          }

          if (Proyecto.this.f == 1) {
            Proyecto.this.jugador1(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          }
        } else if (!Proyecto.this.movimiento && (Proyecto.this.camino[Proyecto.this.f] == 2 && Proyecto.this.pos[Proyecto.this.f] == 6 && Proyecto.this.f == 0 && Proyecto.this.patras || Proyecto.this.camino[Proyecto.this.f] == 2 && Proyecto.this.pos[Proyecto.this.f] == 7 && Proyecto.this.f == 1 && !Proyecto.this.patras)) {
          Proyecto.this.e = 2;
          Proyecto.this.movimiento = true;
          JOptionPane.showMessageDialog((Component)null, "Has conseguido un atajo avanzas 2 posiciones", "Atajo", -1, Proyecto.this.Imatajo);
          if (Proyecto.this.f == 0) {
            Proyecto.this.jugador2(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          }

          if (Proyecto.this.f == 1) {
            Proyecto.this.jugador1(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          }
        }
      }

      if (!Proyecto.this.movimiento && (Proyecto.this.camino[Proyecto.this.f] == 3 && Proyecto.this.pos[Proyecto.this.f] == 2 && Proyecto.this.f == 0 || Proyecto.this.camino[Proyecto.this.f] == 3 && Proyecto.this.pos[Proyecto.this.f] == 3 && Proyecto.this.f == 1 || Proyecto.this.camino[Proyecto.this.f] == 3 && Proyecto.this.pos[Proyecto.this.f] == 2 && Proyecto.this.f == 1 && Proyecto.this.regreso[Proyecto.this.f] || Proyecto.this.camino[Proyecto.this.f] == 3 && Proyecto.this.pos[Proyecto.this.f] == 3 && Proyecto.this.f == 0 && Proyecto.this.regreso[Proyecto.this.f])) {
        if (!Proyecto.this.regreso[Proyecto.this.f]) {
          Proyecto.this.pos[Proyecto.this.f] += 2;
          if (Proyecto.this.f == 0) {
            JOptionPane.showMessageDialog((Component)null, "Has conseguido un atajo avanzas 2 posiciones", "Atajo", -1, Proyecto.this.Imatajo);
            Proyecto.this.jugador1(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          } else {
            JOptionPane.showMessageDialog((Component)null, "Has conseguido un atajo avanzas 2 posiciones", "Atajo", -1, Proyecto.this.Imatajo);
            Proyecto.this.jugador2(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          }
        } else if (Proyecto.this.movimiento || (Proyecto.this.camino[Proyecto.this.f] != 3 || Proyecto.this.pos[Proyecto.this.f] != 2 || Proyecto.this.f != 0 || Proyecto.this.patras) && (Proyecto.this.camino[Proyecto.this.f] != 3 || Proyecto.this.pos[Proyecto.this.f] != 3 || Proyecto.this.f != 1 || !Proyecto.this.patras)) {
          if (!Proyecto.this.movimiento && (Proyecto.this.camino[Proyecto.this.f] == 3 && Proyecto.this.pos[Proyecto.this.f] == 3 && Proyecto.this.f == 0 && Proyecto.this.patras || Proyecto.this.camino[Proyecto.this.f] == 3 && Proyecto.this.pos[Proyecto.this.f] == 2 && Proyecto.this.f == 1 && !Proyecto.this.patras)) {
            Proyecto.this.e = 2;
            Proyecto.this.movimiento = true;
            JOptionPane.showMessageDialog((Component)null, "Has conseguido un atajo avanzas 2 posiciones", "Atajo", -1, Proyecto.this.Imatajo);
            if (Proyecto.this.f == 0) {
              Proyecto.this.jugador2(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
            }

            if (Proyecto.this.f == 1) {
              Proyecto.this.jugador1(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
            }
          }
        } else {
          Proyecto.this.e = 2;
          Proyecto.this.movimiento = true;
          JOptionPane.showMessageDialog((Component)null, "Has conseguido un atajo avanzas 2 posiciones", "Atajo", -1, Proyecto.this.Imatajo);
          if (Proyecto.this.f == 0) {
            Proyecto.this.jugador2(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          }

          if (Proyecto.this.f == 1) {
            Proyecto.this.jugador1(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          }
        }
      }

      if (!Proyecto.this.movimiento && (Proyecto.this.camino[Proyecto.this.f] == 3 && Proyecto.this.pos[Proyecto.this.f] == 7 && Proyecto.this.f == 0 || Proyecto.this.camino[Proyecto.this.f] == 3 && Proyecto.this.pos[Proyecto.this.f] == 6 && Proyecto.this.f == 1 || Proyecto.this.camino[Proyecto.this.f] == 3 && Proyecto.this.pos[Proyecto.this.f] == 7 && Proyecto.this.f == 1 && Proyecto.this.regreso[Proyecto.this.f] || Proyecto.this.camino[Proyecto.this.f] == 3 && Proyecto.this.pos[Proyecto.this.f] == 6 && Proyecto.this.f == 0 && Proyecto.this.regreso[Proyecto.this.f])) {
        if (!Proyecto.this.regreso[Proyecto.this.f]) {
          var10002 = Proyecto.this.pos[Proyecto.this.f]--;
          if (Proyecto.this.f == 0) {
            JOptionPane.showMessageDialog((Component)null, "Has pisado una trampa retrocedes 1 posicion", "Has caido en una trampa", -1, Proyecto.this.Imatrampa);
            Proyecto.this.jugador1(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          } else {
            JOptionPane.showMessageDialog((Component)null, "Has pisado una trampa retrocedes 1 posicion", "Has caido en una trampa", -1, Proyecto.this.Imatrampa);
            Proyecto.this.jugador2(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          }
        } else if (!Proyecto.this.movimiento && (Proyecto.this.camino[Proyecto.this.f] == 3 && Proyecto.this.pos[Proyecto.this.f] == 7 && Proyecto.this.f == 0 && !Proyecto.this.patras || Proyecto.this.camino[Proyecto.this.f] == 3 && Proyecto.this.pos[Proyecto.this.f] == 6 && Proyecto.this.f == 1 && Proyecto.this.patras)) {
          var10002 = Proyecto.this.pos[Proyecto.this.f]++;
          JOptionPane.showMessageDialog((Component)null, "Has pisado una trampa retrocedes 1 posicion", "Has caido en una trampa", -1, Proyecto.this.Imatrampa);
          if (Proyecto.this.patras) {
            Proyecto.this.jugador2(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          } else {
            Proyecto.this.jugador1(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          }
        } else if (!Proyecto.this.movimiento && (Proyecto.this.camino[Proyecto.this.f] == 3 && Proyecto.this.pos[Proyecto.this.f] == 6 && Proyecto.this.f == 0 && Proyecto.this.patras || Proyecto.this.camino[Proyecto.this.f] == 3 && Proyecto.this.pos[Proyecto.this.f] == 7 && Proyecto.this.f == 1 && !Proyecto.this.patras)) {
          var10002 = Proyecto.this.pos[Proyecto.this.f]++;
          JOptionPane.showMessageDialog((Component)null, "Has pisado una trampa retrocedes 1 posicion", "Has caido en una trampa", -1, Proyecto.this.Imatrampa);
          if (Proyecto.this.patras) {
            Proyecto.this.jugador2(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          } else {
            Proyecto.this.jugador1(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          }
        }
      }

      if (!Proyecto.this.movimiento && Proyecto.this.camino[Proyecto.this.f] == 2 && Proyecto.this.pos[Proyecto.this.f] == 3) {
        if (!Proyecto.this.regreso[Proyecto.this.f]) {
          var10002 = Proyecto.this.pos[Proyecto.this.f]--;
          if (Proyecto.this.f == 0) {
            JOptionPane.showMessageDialog((Component)null, "Has pisado una trampa retrocedes 1 posicion", "Has caido en una trampa", -1, Proyecto.this.Imatrampa);
            Proyecto.this.jugador1(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          } else {
            JOptionPane.showMessageDialog((Component)null, "Has pisado una trampa retrocedes 1 posicion", "Has caido en una trampa", -1, Proyecto.this.Imatrampa);
            Proyecto.this.jugador2(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          }
        } else {
          var10002 = Proyecto.this.pos[Proyecto.this.f]++;
          JOptionPane.showMessageDialog((Component)null, "Has pisado una trampa retrocedes 1 posicion", "Has caido en una trampa", -1, Proyecto.this.Imatrampa);
          if (Proyecto.this.patras) {
            Proyecto.this.jugador2(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          } else {
            Proyecto.this.jugador1(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          }
        }
      }

      if (!Proyecto.this.movimiento && Proyecto.this.camino[Proyecto.this.f] == 1 && Proyecto.this.pos[Proyecto.this.f] == 6) {
        if (!Proyecto.this.regreso[Proyecto.this.f]) {
          var10002 = Proyecto.this.pos[Proyecto.this.f]--;
          if (Proyecto.this.f == 0) {
            JOptionPane.showMessageDialog((Component)null, "Has pisado una trampa retrocedes 1 posicion", "Has caido en una trampa", -1, Proyecto.this.Imatrampa);
            Proyecto.this.jugador1(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          } else {
            JOptionPane.showMessageDialog((Component)null, "Has pisado una trampa retrocedes 1 posicion", "Has caido en una trampa", -1, Proyecto.this.Imatrampa);
            Proyecto.this.jugador2(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          }
        } else {
          var10002 = Proyecto.this.pos[Proyecto.this.f]++;
          JOptionPane.showMessageDialog((Component)null, "Has pisado una trampa retrocedes 1 posicion", "Has caido en una trampa", -1, Proyecto.this.Imatrampa);
          if (Proyecto.this.patras) {
            Proyecto.this.jugador2(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          } else {
            Proyecto.this.jugador1(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          }
        }
      }

      if (!Proyecto.this.movimiento && (Proyecto.this.camino[Proyecto.this.f] == 1 && Proyecto.this.pos[Proyecto.this.f] == 2 && Proyecto.this.f == 0 || Proyecto.this.camino[Proyecto.this.f] == 1 && Proyecto.this.pos[Proyecto.this.f] == 4 && Proyecto.this.f == 1 || Proyecto.this.camino[Proyecto.this.f] == 1 && Proyecto.this.pos[Proyecto.this.f] == 2 && Proyecto.this.f == 1 && Proyecto.this.regreso[Proyecto.this.f] || Proyecto.this.camino[Proyecto.this.f] == 1 && Proyecto.this.pos[Proyecto.this.f] == 4 && Proyecto.this.f == 0 && Proyecto.this.regreso[Proyecto.this.f])) {
        if (!Proyecto.this.regreso[Proyecto.this.f]) {
          if (Proyecto.this.pos_ant[Proyecto.this.f] == -1) {
            JOptionPane.showMessageDialog((Component)null, "Has pisado una trampa pierdes el turno", "Perdiendo turno", -1, Proyecto.this.Imapturno);
            if (Proyecto.this.f == 0) {
              Proyecto.this.movx[0] = 156;
              Proyecto.this.movy[0] = 299;
              Proyecto.this.pos[Proyecto.this.f] = -1;
              Proyecto.this.repaint();
            } else {
              Proyecto.this.movx[1] = 800;
              Proyecto.this.movy[1] = 299;
              Proyecto.this.pos[Proyecto.this.f] = -1;
              Proyecto.this.repaint();
            }
          } else {
            JOptionPane.showMessageDialog((Component)null, "Has pisado una trampa pierdes el turno", "Perdiendo turno", -1, Proyecto.this.Imapturno);
            if (Proyecto.this.f == 0) {
              Proyecto.this.pos[Proyecto.this.f] = Proyecto.this.pos_ant[Proyecto.this.f];
              Proyecto.this.camino[Proyecto.this.f] = Proyecto.this.r_ant[Proyecto.this.f];
              Proyecto.this.jugador1(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
            } else {
              Proyecto.this.pos[Proyecto.this.f] = Proyecto.this.pos_ant[Proyecto.this.f];
              Proyecto.this.camino[Proyecto.this.f] = Proyecto.this.r_ant[Proyecto.this.f];
              Proyecto.this.jugador2(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
            }
          }
        } else if (!Proyecto.this.movimiento && (Proyecto.this.camino[Proyecto.this.f] == 1 && Proyecto.this.pos[Proyecto.this.f] == 2 && Proyecto.this.f == 0 && !Proyecto.this.patras || Proyecto.this.camino[Proyecto.this.f] == 1 && Proyecto.this.pos[Proyecto.this.f] == 4 && Proyecto.this.f == 1 && Proyecto.this.patras)) {
          JOptionPane.showMessageDialog((Component)null, "Has pisado una trampa pierdes el turno", "Perdiendo turno", -1, Proyecto.this.Imapturno);
          Proyecto.this.pos[Proyecto.this.f] = Proyecto.this.pos_ant[Proyecto.this.f];
          Proyecto.this.camino[Proyecto.this.f] = Proyecto.this.r_ant[Proyecto.this.f];
          if (Proyecto.this.f == 0) {
            Proyecto.this.jugador1(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          } else {
            Proyecto.this.jugador2(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          }
        } else if (!Proyecto.this.movimiento && (Proyecto.this.camino[Proyecto.this.f] == 1 && Proyecto.this.pos[Proyecto.this.f] == 4 && Proyecto.this.f == 0 && Proyecto.this.patras || Proyecto.this.camino[Proyecto.this.f] == 1 && Proyecto.this.pos[Proyecto.this.f] == 2 && Proyecto.this.f == 1 && !Proyecto.this.patras)) {
          JOptionPane.showMessageDialog((Component)null, "Has pisado una trampa pierdes el turno", "Perdiendo turno", -1, Proyecto.this.Imapturno);
          Proyecto.this.pos[Proyecto.this.f] = Proyecto.this.pos_ant[Proyecto.this.f];
          Proyecto.this.camino[Proyecto.this.f] = Proyecto.this.r_ant[Proyecto.this.f];
          if (Proyecto.this.f == 0) {
            Proyecto.this.jugador2(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          } else {
            Proyecto.this.jugador1(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          }
        }
      }

      if (!Proyecto.this.movimiento && (Proyecto.this.camino[Proyecto.this.f] == 2 && Proyecto.this.pos[Proyecto.this.f] == 6 && Proyecto.this.f == 0 || Proyecto.this.camino[Proyecto.this.f] == 2 && Proyecto.this.pos[Proyecto.this.f] == 1 && Proyecto.this.f == 1 || Proyecto.this.camino[Proyecto.this.f] == 2 && Proyecto.this.pos[Proyecto.this.f] == 6 && Proyecto.this.f == 1 && Proyecto.this.regreso[Proyecto.this.f] || Proyecto.this.camino[Proyecto.this.f] == 2 && Proyecto.this.pos[Proyecto.this.f] == 1 && Proyecto.this.f == 0 && Proyecto.this.regreso[Proyecto.this.f])) {
        if (!Proyecto.this.regreso[Proyecto.this.f]) {
          if (Proyecto.this.pos_ant[Proyecto.this.f] == -1) {
            JOptionPane.showMessageDialog((Component)null, "Has pisado una trampa pierdes el turno", "Perdiendo turno", -1, Proyecto.this.Imapturno);
            if (Proyecto.this.f == 0) {
              Proyecto.this.movx[0] = 156;
              Proyecto.this.movy[0] = 299;
              Proyecto.this.pos[Proyecto.this.f] = -1;
              Proyecto.this.repaint();
            } else {
              Proyecto.this.movx[1] = 800;
              Proyecto.this.movy[1] = 299;
              Proyecto.this.pos[Proyecto.this.f] = -1;
              Proyecto.this.repaint();
            }
          } else {
            JOptionPane.showMessageDialog((Component)null, "Has pisado una trampa  pierdes el turno", "Perdiendo turno", -1, Proyecto.this.Imapturno);
            if (Proyecto.this.f == 0) {
              Proyecto.this.pos[Proyecto.this.f] = Proyecto.this.pos_ant[Proyecto.this.f];
              Proyecto.this.camino[Proyecto.this.f] = Proyecto.this.r_ant[Proyecto.this.f];
              Proyecto.this.jugador1(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
            } else {
              Proyecto.this.pos[Proyecto.this.f] = Proyecto.this.pos_ant[Proyecto.this.f];
              Proyecto.this.camino[Proyecto.this.f] = Proyecto.this.r_ant[Proyecto.this.f];
              Proyecto.this.jugador2(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
            }
          }
        } else if (Proyecto.this.movimiento || (Proyecto.this.camino[Proyecto.this.f] != 2 || Proyecto.this.pos[Proyecto.this.f] != 6 || Proyecto.this.f != 0 || Proyecto.this.patras) && (Proyecto.this.camino[Proyecto.this.f] != 2 || Proyecto.this.pos[Proyecto.this.f] != 1 || Proyecto.this.f != 1 || !Proyecto.this.patras)) {
          if (!Proyecto.this.movimiento && (Proyecto.this.camino[Proyecto.this.f] == 2 && Proyecto.this.pos[Proyecto.this.f] == 1 && Proyecto.this.f == 0 && Proyecto.this.patras || Proyecto.this.camino[Proyecto.this.f] == 2 && Proyecto.this.pos[Proyecto.this.f] == 6 && Proyecto.this.f == 1 && !Proyecto.this.patras)) {
            JOptionPane.showMessageDialog((Component)null, "Has pisado una trampa pierdes el turno");
            Proyecto.this.pos[Proyecto.this.f] = Proyecto.this.pos_ant[Proyecto.this.f];
            Proyecto.this.camino[Proyecto.this.f] = Proyecto.this.r_ant[Proyecto.this.f];
            if (Proyecto.this.f == 0) {
              Proyecto.this.jugador2(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
            } else {
              Proyecto.this.jugador1(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
            }
          }
        } else {
          JOptionPane.showMessageDialog((Component)null, "Has pisado una trampa pierdes el turno", "Perdiendo turno", -1, Proyecto.this.Imapturno);
          Proyecto.this.pos[Proyecto.this.f] = Proyecto.this.pos_ant[Proyecto.this.f];
          Proyecto.this.camino[Proyecto.this.f] = Proyecto.this.r_ant[Proyecto.this.f];
          if (Proyecto.this.f == 0) {
            Proyecto.this.jugador1(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          } else {
            Proyecto.this.jugador2(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          }
        }
      }

      if (!Proyecto.this.movimiento && (Proyecto.this.camino[Proyecto.this.f] == 3 && Proyecto.this.pos[Proyecto.this.f] == 5 && Proyecto.this.f == 0 || Proyecto.this.camino[Proyecto.this.f] == 3 && Proyecto.this.pos[Proyecto.this.f] == 2 && Proyecto.this.f == 1 || Proyecto.this.camino[Proyecto.this.f] == 3 && Proyecto.this.pos[Proyecto.this.f] == 5 && Proyecto.this.f == 1 && Proyecto.this.regreso[Proyecto.this.f] || Proyecto.this.camino[Proyecto.this.f] == 3 && Proyecto.this.pos[Proyecto.this.f] == 2 && Proyecto.this.f == 0 && Proyecto.this.regreso[Proyecto.this.f])) {
        if (!Proyecto.this.regreso[Proyecto.this.f]) {
          if (Proyecto.this.pos_ant[Proyecto.this.f] == -1) {
            JOptionPane.showMessageDialog((Component)null, "Has pisado una trampa pierdes el turno", "Perdiendo turno", -1, Proyecto.this.Imapturno);
            if (Proyecto.this.f == 0) {
              Proyecto.this.movx[0] = 156;
              Proyecto.this.movy[0] = 299;
              Proyecto.this.pos[Proyecto.this.f] = -1;
              Proyecto.this.repaint();
            } else {
              Proyecto.this.movx[1] = 800;
              Proyecto.this.movy[1] = 299;
              Proyecto.this.pos[Proyecto.this.f] = -1;
              Proyecto.this.repaint();
            }
          } else {
            JOptionPane.showMessageDialog((Component)null, "Has pisado una trampa  pierdes el turno", "Perdiendo turno", -1, Proyecto.this.Imapturno);
            if (Proyecto.this.f == 0) {
              Proyecto.this.pos[Proyecto.this.f] = Proyecto.this.pos_ant[Proyecto.this.f];
              Proyecto.this.camino[Proyecto.this.f] = Proyecto.this.r_ant[Proyecto.this.f];
              Proyecto.this.jugador1(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
            } else {
              Proyecto.this.pos[Proyecto.this.f] = Proyecto.this.pos_ant[Proyecto.this.f];
              Proyecto.this.camino[Proyecto.this.f] = Proyecto.this.r_ant[Proyecto.this.f];
              Proyecto.this.jugador2(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
            }
          }
        } else if (Proyecto.this.movimiento || (Proyecto.this.camino[Proyecto.this.f] != 3 || Proyecto.this.pos[Proyecto.this.f] != 5 || Proyecto.this.f != 0 || Proyecto.this.patras) && (Proyecto.this.camino[Proyecto.this.f] != 3 || Proyecto.this.pos[Proyecto.this.f] != 2 || Proyecto.this.f != 1 || !Proyecto.this.patras)) {
          if (!Proyecto.this.movimiento && (Proyecto.this.camino[Proyecto.this.f] == 3 && Proyecto.this.pos[Proyecto.this.f] == 2 && Proyecto.this.f == 0 && Proyecto.this.patras || Proyecto.this.camino[Proyecto.this.f] == 3 && Proyecto.this.pos[Proyecto.this.f] == 5 && Proyecto.this.f == 1 && !Proyecto.this.patras)) {
            JOptionPane.showMessageDialog((Component)null, "Has pisado una trampa  pierdes el turno", "Perdiendo turno", -1, Proyecto.this.Imapturno);
            Proyecto.this.pos[Proyecto.this.f] = Proyecto.this.pos_ant[Proyecto.this.f];
            Proyecto.this.camino[Proyecto.this.f] = Proyecto.this.r_ant[Proyecto.this.f];
            if (Proyecto.this.f == 0) {
              Proyecto.this.jugador2(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
            } else {
              Proyecto.this.jugador1(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
            }
          }
        } else {
          JOptionPane.showMessageDialog((Component)null, "Has pisado una trampa  pierdes el turno", "Perdiendo turno", -1, Proyecto.this.Imapturno);
          Proyecto.this.pos[Proyecto.this.f] = Proyecto.this.pos_ant[Proyecto.this.f];
          Proyecto.this.camino[Proyecto.this.f] = Proyecto.this.r_ant[Proyecto.this.f];
          if (Proyecto.this.f == 0) {
            Proyecto.this.jugador1(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          } else {
            Proyecto.this.jugador2(Proyecto.this.pos[Proyecto.this.f], Proyecto.this.camino[Proyecto.this.f]);
          }
        }
      }

    }
  }
}
