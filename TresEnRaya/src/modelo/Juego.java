package modelo;

public class Juego implements JuegoTresEnRaya {

  private int turno = 1;
  private String MARCAR_1 = "X";
  private String MARCAR_2 = "Y";
  private boolean error = false;
  private int ganador = 0;

  private String tablero[][] = {
          {"", "", ""},
          {"", "", ""},
          {"", "", ""}
  };

  @Override
  public void jugarOtraVez() {
    for (int i = 0; i < tablero.length; i++)
      for (int j = 0; j < tablero.length; j++)
        tablero[i][j] = "";
    this.error = false;
    this.ganador = 0;
    this.turno = 1;
  }

  @Override
  public String setMovimiento(int posicion) {
    String res = "";
    if (turno == 1) {
      res = marcar(posicion, this.MARCAR_1);
      turno = 2;
      if (gano(this.tablero, this.MARCAR_1))
        this.ganador = 1;
      else if (empate())
        this.ganador = 3;
    } else {
      res = marcar(posicion, this.MARCAR_2);
      turno = 1;
      if (gano(this.tablero, this.MARCAR_2))
        this.ganador = 2;
      else if (empate())
        this.ganador = 3;
    }
    return res;
  }

  @Override
  public String marcar(int Posicion, String value) {
    String marca = "";
    switch (Posicion) {
      case 1:
        marca = subMarcar(0, 0, value);
        break;
      case 2:
        marca = subMarcar(0, 1, value);
        break;
      case 3:
        marca = subMarcar(0, 2, value);
        break;
      case 4:
        marca = subMarcar(1, 0, value);
        break;
      case 5:
        marca = subMarcar(1, 1, value);
        break;
      case 6:
        marca = subMarcar(1, 2, value);
        break;
      case 7:
        marca = subMarcar(2, 0, value);
        break;
      case 8:
        marca = subMarcar(2, 1, value);
        break;
      case 9:
        marca = subMarcar(2, 2, value);
        break;
    }
    return marca;
  }

  @Override
  public String subMarcar(int x, int y, String value) {
    String marca = "";
    this.error = false;
    if (this.tablero[x][y].equals(""))
    {
      this.tablero[x][y] = value;
      marca = value;
    } else
    {
      marca = this.tablero[x][y];
      this.error = true;
    }
    return marca;
  }

  @Override
  public boolean getError() {
    return this.error;
  }

  @Override
  public int getTurno() {
    return (this.turno == 1) ? 1 : 2;
  }

  @Override
  public int ganador() {
    return this.ganador;
  }

  private boolean gano(String arreglo[][], String marca) {
    //busqueda de ganador por filas
    for (int i = 0; i < arreglo.length; i++) {
      int contador = 0;
      for (int j = 0; j < arreglo.length; j++)
        contador += (arreglo[i][j].equals(marca)) ? 1 : 0;
      if (contador == 3)
        return true;
    }
    //busqueda de ganador por columnas
    for (int j = 0; j < arreglo.length; j++) {
      int contador = 0;
      for (int i = 0; i < arreglo.length; i++)
        contador += (arreglo[i][j].equals(marca)) ? 1 : 0;
      if (contador == 3)
        return true;
    }
    //diagonales
    if (arreglo[0][0].equals(marca) && arreglo[1][1].equals(marca) && arreglo[2][2].equals(marca))
      return true;

    if (arreglo[0][2].equals(marca) && arreglo[1][1].equals(marca) && arreglo[2][0].equals(marca))
      return true;

    return false;
  }

  @Override
  public boolean empate() {
    for (int i = 0; i < tablero.length; i++)
      for (int j = 0; j < tablero.length; j++)
        if (tablero[i][j].equals(""))
          return false;
    return true;
  }

  @Override
  public String[][] getTablero() {
    return this.tablero;
  }
  
}
