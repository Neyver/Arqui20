package test;

import org.junit.Assert;
import vista.Consola;
import org.junit.Test;

public class ConsolaTest {

  @Test
  public void verificandoGandorDadoElUnoPodriaDevolverUnMensajeTest() {
    Consola consola = new Consola();
    String res = consola.verificarGanador(1);
    Assert.assertEquals("Gano el Jugador X", res);
  }
  @Test
  public void verificandoGandorDadoElDosPodriaDevolverUnMensajeTest() {
    Consola consola = new Consola();
    String res = consola.verificarGanador(2);
    Assert.assertEquals("Gano el Jugador Y", res);
  }
  @Test
  public void verificandoGandorDadoElTresPodriaDevolverUnMensajeTest() {
    Consola consola = new Consola();
    String res = consola.verificarGanador(3);
    Assert.assertEquals("Empate", res);
  }
  @Test
  public void validarUnRangoDeOpcionesdeberiaDevolverTrueTest() {
    Consola consola = new Consola();
    boolean res = consola.validarNumero(3, 1,3);
    Assert.assertTrue(res);
  }
  @Test
  public void validarUnRangoDeOpcionesdeberiaDevolverfalseTest() {
    Consola consola = new Consola();
    boolean res = consola.validarNumero(3, 1,1);
    Assert.assertFalse( res);
  }
}
