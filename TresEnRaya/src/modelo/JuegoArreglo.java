package modelo;

public class JuegoArreglo implements JuegoTresEnRaya {

  private int turno = 1;
  private String MARCAR_1 = "X";
  private String MARCAR_2 = "Y";
  private boolean error = false;
  private int ganador = 0;
  private String tablero[] = {"", "", "", "", "", "", "", "", ""};

  @Override
  public void jugarOtraVez() {
    for (int i = 0; i < tablero.length; i++)
        tablero[i] = "";
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
        marca = subMarcar(1,1, value);
        break;
      case 2:
        marca = subMarcar(2,2, value);
        break;
      case 3:
        marca = subMarcar(3,3, value);
        break;
      case 4:
        marca = subMarcar(4,4, value);
        break;
      case 5:
        marca = subMarcar(5,5, value);
        break;
      case 6:
        marca = subMarcar(6,6, value);
        break;
      case 7:
        marca = subMarcar(7,7, value);
        break;
      case 8:
        marca = subMarcar(8,8, value);
        break;
      case 9:
        marca = subMarcar(9,9, value);
        break;
    }
    return marca;
  }

  @Override
  public String subMarcar(int x, int y, String value) {
    String marca = "";
    this.error = false;
    if (this.tablero[x].equals(""))
    {
      this.tablero[x] = value;
      marca = value;
    } else
    {
      marca = this.tablero[x];
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

  @Override
  public boolean empate() {
    return false;
  }

  @Override
  public String[][] getTablero() {
    return new String[0][];
  }

  private boolean gano(String arreglo[], String marca) {
    return false;
  }
}
