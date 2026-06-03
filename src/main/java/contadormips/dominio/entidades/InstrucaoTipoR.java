package contadormips.dominio.entidades;

import java.util.HashMap;
import java.util.Map;

import contadormips.dominio.enums.EnumInstrucoes;
import contadormips.utils.UtilitarioBinario;

public class InstrucaoTipoR extends InstrucaoMIPS {
    protected static final Map<EnumInstrucoes, Integer> functs = new HashMap<>();
    static {
        functs.put(EnumInstrucoes.ADD, 32);
        functs.put(EnumInstrucoes.SUB, 34);
        functs.put(EnumInstrucoes.AND, 36);
        functs.put(EnumInstrucoes.OR, 37);
        functs.put(EnumInstrucoes.XOR, 38);
        functs.put(EnumInstrucoes.SLL, 0);
        functs.put(EnumInstrucoes.SRL, 2);
        functs.put(EnumInstrucoes.JR, 8);
    }

    protected final int rs;
    protected final int rt;
    protected final int rd;
    protected final int shamt;
    protected final int funct;

    public InstrucaoTipoR(int rs, int rt, int rd, int shamt, int funct) {
        super(0);
        this.rs = rs;
        this.rt = rt;
        this.rd = rd;
        this.shamt = shamt;
        this.funct = funct;
    }

    public int getRs() {
        return rs;
    }

    public int getRt() {
        return rt;
    }

    public int getRd() {
        return rd;
    }

    public int getShamt() {
        return shamt;
    }

    public int getFunct() {
        return funct;
    }

    public static int getFuncao(EnumInstrucoes instrucao) {
        return functs.get(instrucao);
    }

    public static boolean existe(EnumInstrucoes instrucao) {
        return functs.containsKey(instrucao);
    }

    @Override
    public String getBinario() {
        StringBuilder sb = new StringBuilder();
        sb.append(UtilitarioBinario.parseInt(opCode, 6));
        sb.append(UtilitarioBinario.parseInt(rs, 5));
        sb.append(UtilitarioBinario.parseInt(rt, 5));
        sb.append(UtilitarioBinario.parseInt(rd, 5));
        sb.append(UtilitarioBinario.parseInt(shamt, 5));
        sb.append(UtilitarioBinario.parseInt(funct, 6));
        return sb.toString();
    }
}
