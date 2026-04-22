package conversormips.utils;

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
        if (numeroBinario.startsWith("0")) { // Número positivo
            return "0".repeat(bits - numeroBinario.length()) + numeroBinario; // Complementa os bits faltantes com 0
        }
        return numeroBinario.substring(32 - bits); // Número negativo
    }
}
