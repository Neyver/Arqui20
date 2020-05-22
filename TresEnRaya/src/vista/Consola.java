package vista;

import modelo.Juego;
import java.util.Scanner;

public class Consola {
  private Juego juego;
   public Consola(Juego juego) {
     this.juego = juego;
   }

  public Consola() {
    this.juego = new Juego();
  }

  public void jugar() {
    System.out.println("Inicio el juego");
    opciones();
    int opcion = obtenerNumero();
    if(validarNumero(opcion,1,2) && opcion == 1) {
      while(opcion == 1) {
        if(this.juego.ganador() == 0) {
          dibujarJuego(this.juego.getTablero());
          System.out.println("---------------------");
          System.out.println("Elija una casilla vacia(1-9)");
          System.out.println("10.- Volver a Jugar");
          System.out.println("11.- Salir ");
          int jugada = obtenerNumero();
          if(validarNumero(jugada,1,11) && opcion == 10) {
            this.juego.jugarOtraVez();
          }
          if(validarNumero(jugada,1,11) && jugada == 11) {
            opcion = 2;
          }
          juego.setMovimiento(jugada);
        }else {
          dibujarJuego(this.juego.getTablero());
          System.out.println(verificarGanador(this.juego.ganador()));
          opciones();
          opcion = obtenerNumero();
          if(validarNumero(opcion,1,2) && opcion == 1) {
            this.juego.jugarOtraVez();
          }
        }
      }
    } else {
      if(opcion == 2) {
        salir();
      } else {
        jugar();
      }
    }
  }

  public boolean validarNumero(int opcion, int inicio, int fin) {
     return opcion >= inicio && opcion <= fin;
  }

  private void dibujarJuego(String[][] tablero) {
    System.out.println(tablero[0][0] + " | " + tablero[0][1] + " | " + tablero[0][2] + "\n---------");
    System.out.println(tablero[1][0] + " | " + tablero[1][1] + " | " + tablero[1][2] + "\n---------");
    System.out.println(tablero[2][0] + " | " + tablero[2][1] + " | " + tablero[2][2] + "\n");
  }

  public String verificarGanador(int ganador) {
     switch (ganador){
       case 1:  return "Gano el Jugador X";
       case 2:  return "Gano el Jugador Y";
       default: return "Empate";
     }
  }

  private void salir() {
    System.out.println("bye bye");
    return;
  }

  private int obtenerNumero() {
    Scanner reader = new Scanner(System.in);
    int opcion = 0;
    try {
        opcion = reader.nextInt();
      } catch (Exception e) {
        opciones();
        return 0;
      }
      return opcion;
  }
   private void opciones() {
     System.out.println("Escoja Una Opcion");
     System.out.println("1.- Nueva Partida");
     System.out.println("2.- Salir");
   }
}
