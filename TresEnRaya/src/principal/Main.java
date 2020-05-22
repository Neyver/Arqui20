package principal;
import modelo.Juego;
import vista.Consola;

public class Main {
    boolean juego = true;

    public static void main(String[] args) {

        //ganadorX
        int [] jugadorUno = {1,5,3,7,2};
        int [] jugadorDos = {4,6,9,8};
        int ganadorX = jugar(jugadorUno, jugadorDos);
        //ganadorY
        jugadorUno = new int[]{7,4,6};
        jugadorDos = new int[]{2,5,8};
        int ganadorY = jugar(jugadorUno, jugadorDos);
        //Empate
        jugadorUno = new int[]{1,2,6,7,9};
        jugadorDos = new int[]{3,4,5,8};
        int empate = jugar(jugadorUno, jugadorDos);

        ///////////////////////////////////////////////////////
        Juego modelo = new Juego();
        Consola vista = new Consola(modelo);
        vista.jugar();
    }

    public static int jugar(int[] jugadorUno,int[] jugadorDos) {
        Juego juego = new Juego();
        int turno = 1;
        int positionJugadorUno = 0;
        int positionJugadorDos = 0;
        while(juego.ganador() == 0) {
            if(turno == 1) {
                juego.setMovimiento(jugadorUno[positionJugadorUno]);
                positionJugadorUno++;
                turno=2;
            } else {
                juego.setMovimiento(jugadorDos[positionJugadorDos]);
                positionJugadorDos++;
                turno=1;
            }
        }
        return juego.ganador();
    }
}
