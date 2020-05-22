package test;

import modelo.JuegoTresEnRaya;
import modelo.Juego;
import modelo.JuegoArreglo;
import org.junit.Test;
import org.junit.Assert;

public class JuegoTest {

  //para usar la clase Juego  JuegoTresEnRaya juego = new Juego();
  @Test
  public void iniciandoOtraVezElJuegoElErrorPodriaSerFalseTest() {
    JuegoTresEnRaya juego = new JuegoArreglo();
    juego.jugarOtraVez();
    Assert.assertEquals(false, juego.getError());
  }

  @Test
  public void iniciandoOtraVezElJuegoElGanadorEs0Test() {
    JuegoTresEnRaya juego = new JuegoArreglo();
    juego.jugarOtraVez();
    Assert.assertEquals(0, juego.ganador());
  }

  @Test
  public void iniciandoOtraVezElJuegoElTurnoEs1Test() {
    JuegoTresEnRaya juego = new JuegoArreglo();
    juego.jugarOtraVez();
    Assert.assertEquals(1, juego.getTurno());
  }

  @Test
  public void haciendoUnMovimientoTest() {
    JuegoTresEnRaya juego = new JuegoArreglo();
    String res = juego.setMovimiento(2);
    Assert.assertEquals("X", res);
  }

  @Test
  public void colocandoDosMovimientoCualquieraPodriaDevolverYTest() {
    JuegoTresEnRaya juego = new JuegoArreglo();
    juego.setMovimiento(2);
    String resJugadorDos = juego.setMovimiento(1);
    Assert.assertEquals("Y", resJugadorDos);
  }

  @Test
  public void MarcarConLaLetraOdeberiaDevolverOTest() {
    JuegoTresEnRaya juego = new JuegoArreglo();
    String res = juego.marcar(1, "O");
    Assert.assertEquals("O", res);
  }

  @Test
  public void MarcarDosVecesElMismoCampoElErrorPodriaSerTrue() {
    JuegoTresEnRaya juego = new JuegoArreglo();
    juego.subMarcar(1, 1, "O");
    juego.subMarcar(1, 1, "O");
    Assert.assertEquals(true, juego.getError());
  }

  @Test
  public void cuandoElJugadorUnoJuegaDeberiaJugarElJugadorDosTest() {
    JuegoTresEnRaya juego = new JuegoArreglo();
    juego.setMovimiento(1);
    Assert.assertEquals( 2, juego.getTurno());
  }

  @Test
  public void marcarTodosLosCamposyVerificarGanadorPodriaSer1Test() {
    Juego juego = new Juego();
    juego.setMovimiento(1);
    juego.setMovimiento(4);
    juego.setMovimiento(2);
    juego.setMovimiento(8);
    juego.setMovimiento(3);
    Assert.assertEquals(1, juego.ganador());
  }

  @Test
  public void marcarTodosLosCamposyVerificarGanadorPodriaSer2Test() {
    Juego juego = new Juego();
    juego.setMovimiento(1);
    juego.setMovimiento(2);
    juego.setMovimiento(9);
    juego.setMovimiento(5);
    juego.setMovimiento(4);
    juego.setMovimiento(8);
    Assert.assertEquals(2, juego.ganador());
  }

    @Test
    public void marcarTodosLosCamposyVerificarEmpateTest() {
        Juego juego = new Juego();
        juego.setMovimiento(1);
        juego.setMovimiento(2);
        juego.setMovimiento(3);
        juego.setMovimiento(7);
        juego.setMovimiento(4);
        juego.setMovimiento(5);
        juego.setMovimiento(8);
        juego.setMovimiento(6);
        juego.setMovimiento(9);
        Assert.assertEquals(3, juego.ganador());
    }

    @Test
    public void marcarUnCampoVerfificarElTableroTest() {
        Juego juego = new Juego();
        juego.setMovimiento(1);
        String tablero[][] = {
                {"X", "", ""},
                {"", "", ""},
                {"", "", ""}
        };
        Assert.assertArrayEquals(tablero, juego.getTablero());
    }

    @Test
    public void marcarDosCampoVerfificarElTableroConLaMarcaYTest() {
        Juego juego = new Juego();
        juego.setMovimiento(1);
        juego.setMovimiento(2);
        String tablero[][] = {
                {"X", "Y", ""},
                {"", "", ""},
                {"", "", ""}
        };
        Assert.assertArrayEquals(tablero, juego.getTablero());
    }
}
