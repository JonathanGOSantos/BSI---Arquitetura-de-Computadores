package dominio.bancos;

import java.util.HashMap;
import java.util.Map;

public class BancoRegistradores {
    private static final Map<String, Integer> dicionario = new HashMap<>();

    static {
        dicionario.put("$r0", 0);
        dicionario.put("$zero", 0);
        dicionario.put("$at", 1);
        dicionario.put("$v0", 2);
        dicionario.put("$v1", 3);
        dicionario.put("$a0", 4);
        dicionario.put("$a1", 5);
        dicionario.put("$a2", 6);
        dicionario.put("$a3", 7);
        dicionario.put("$t0", 8);
        dicionario.put("$t1", 9);
        dicionario.put("$t2", 10);
        dicionario.put("$t3", 11);
        dicionario.put("$t4", 12);
        dicionario.put("$t5", 13);
        dicionario.put("$t6", 14);
        dicionario.put("$t7", 15);
        dicionario.put("$s0", 16);
        dicionario.put("$s1", 17);
        dicionario.put("$s2", 18);
        dicionario.put("$s3", 19);
        dicionario.put("$s4", 20);
        dicionario.put("$s5", 21);
        dicionario.put("$s6", 22);
        dicionario.put("$s7", 23);
        dicionario.put("$t8", 24);
        dicionario.put("$t9", 25);
        dicionario.put("$k0", 26);
        dicionario.put("$k1", 27);
        dicionario.put("$gp", 28);
        dicionario.put("$sp", 29);
        dicionario.put("$s8", 30);
        dicionario.put("$ra", 31);
    }

    /**
     * Retorna o número do registrador ou null se não existir
     */
    public static Integer getNumero(String nome) {
        return dicionario.get(nome.toLowerCase());
    }

    /**
     * Verifica se um nome de registrador é válido
     */
    public static boolean existe(String nome) {
        return dicionario.containsKey(nome.toLowerCase());
    }
}