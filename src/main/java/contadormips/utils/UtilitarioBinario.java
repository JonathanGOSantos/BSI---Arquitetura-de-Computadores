package contadormips.utils;

public class UtilitarioBinario {
    /**
     * Recebe um número decimal e o converte para binário com a quantidade dada de bits, ex:
     * numero = 10, bits = 8
     * resultado: 00001010
     * @param numero o número a ser convertido
     * @param bits a quantidade de bits que deve ser retornada
     * @return número convertido para binário
     */
    public static String parseInt(int numero, int bits) {
        String numeroBinario = Integer.toBinaryString(numero);
        // System.out.println("Número: " + numero);
        // System.out.println("Bits: " + "0".repeat(bits));
        String out;
        if (numeroBinario.length() != 32) { // Número positivo
            out = "0".repeat(bits - numeroBinario.length()) + numeroBinario;
            // System.out.println("Binario: " + out);
            return out; // Complementa os bits faltantes com 0
        }
        // System.out.println("Binario: " + numeroBinario);
        return numeroBinario.substring(32 - bits); // Número negativo
    }
}