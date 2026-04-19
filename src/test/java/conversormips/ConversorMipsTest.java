package conversormips;

public class ConversorMipsTest {
  public static void main(String[] args) {
    ConversorMips conversorMips = new ConversorMips();
    String[] linhas = {
        "lw $t0, 1200($t1)",
        "add $t0, $s2, $t0",
        "sw $t0, 1200($t1)"
    };

    String[] resultadoEsperado = {
        "10001101001010000000010010110000",
        "00000010010010000100000000100000",
        "10101101001010000000010010110000"
    };

    for (int i = 0; i < linhas.length; i++) {
      String binario = conversorMips.processarLinha(linhas[i]).getBinario();
      System.out.printf("Linha %d: %s\nResultado: %s\n", i + 1, binario,
          binario.equals(resultadoEsperado[i]) ? "Correto" : "Errado");
    }
  }
}