package modelo;

public interface JuegoTresEnRaya {
  void jugarOtraVez();

  String setMovimiento(int posicion);

  String marcar(int Posicion, String value);

  String subMarcar(int x, int y, String value);

  boolean getError();

  int getTurno();

  int ganador();

  boolean empate();

  String[][] getTablero();
}
