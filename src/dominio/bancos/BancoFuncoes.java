package dominio.bancos;

import dominio.enums.Instrucao;

import java.util.HashMap;
import java.util.Map;

public class BancoFuncoes {
    private static final Map<Instrucao, Integer> opCodes = new HashMap<>();

    static {
        opCodes.put(Instrucao.ADD, 32);
        opCodes.put(Instrucao.SUB, 34);
        opCodes.put(Instrucao.AND, 36);
        opCodes.put(Instrucao.OR, 37);
        opCodes.put(Instrucao.XOR, 38);
    }

    public static int getFuncao(Instrucao instrucao) {
        return opCodes.get(instrucao);
    }

    public static boolean existe(Instrucao instrucao) {
        return opCodes.containsKey(instrucao);
    }
}
