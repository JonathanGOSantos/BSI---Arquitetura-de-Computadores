package contadormips.dominio.enums;

import contadormips.dominio.entidades.*;

import java.util.EnumSet;
import java.util.Set;

public enum EnumInstrucoes {
    // Tipo R
    // Lógicas e Aritméticas
    ADD(InstrucaoTipoR.class, 0, Comportamento.LE_REGISTRADOR, Comportamento.ESCREVE_REGISTRADOR),
    SUB(InstrucaoTipoR.class, 0, Comportamento.LE_REGISTRADOR, Comportamento.ESCREVE_REGISTRADOR),
    AND(InstrucaoTipoR.class, 0, Comportamento.LE_REGISTRADOR, Comportamento.ESCREVE_REGISTRADOR),
    OR(InstrucaoTipoR.class, 0, Comportamento.LE_REGISTRADOR, Comportamento.ESCREVE_REGISTRADOR),
    XOR(InstrucaoTipoR.class, 0, Comportamento.LE_REGISTRADOR, Comportamento.ESCREVE_REGISTRADOR),
    // Deslocamento de Bits
    SLL(InstrucaoTipoR.class, 0, Comportamento.LE_REGISTRADOR, Comportamento.ESCREVE_REGISTRADOR),
    SRL(InstrucaoTipoR.class, 0, Comportamento.LE_REGISTRADOR, Comportamento.ESCREVE_REGISTRADOR),
    // Desvio
    JR(InstrucaoTipoR.class, 0, Comportamento.LE_REGISTRADOR),

    // Tipo I
    // Load e Store
    LB(InstrucaoTipoI.class, 32, Comportamento.LE_REGISTRADOR, Comportamento.ESCREVE_REGISTRADOR, Comportamento.LE_MEMORIA),
    LH(InstrucaoTipoI.class, 3, Comportamento.LE_REGISTRADOR, Comportamento.ESCREVE_REGISTRADOR, Comportamento.LE_MEMORIA),
    LW(InstrucaoTipoI.class, 35, Comportamento.LE_REGISTRADOR, Comportamento.ESCREVE_REGISTRADOR, Comportamento.LE_MEMORIA),
    SB(InstrucaoTipoI.class, 40, Comportamento.LE_REGISTRADOR, Comportamento.ESCREVE_MEMORIA),
    SH(InstrucaoTipoI.class, 41, Comportamento.LE_REGISTRADOR, Comportamento.ESCREVE_MEMORIA),
    SW(InstrucaoTipoI.class, 43, Comportamento.LE_REGISTRADOR, Comportamento.ESCREVE_MEMORIA),

    // Lógicas e Aritméticas
    ADDI(InstrucaoTipoI.class, 8, Comportamento.LE_REGISTRADOR, Comportamento.ESCREVE_REGISTRADOR),
    ANDI(InstrucaoTipoI.class, 12, Comportamento.LE_REGISTRADOR, Comportamento.ESCREVE_REGISTRADOR),
    ORI(InstrucaoTipoI.class, 13, Comportamento.LE_REGISTRADOR, Comportamento.ESCREVE_REGISTRADOR),
    XORI(InstrucaoTipoI.class, 14, Comportamento.LE_REGISTRADOR, Comportamento.ESCREVE_REGISTRADOR),
    LIU(InstrucaoTipoI.class, 15, Comportamento.LE_REGISTRADOR, Comportamento.ESCREVE_REGISTRADOR),
    //Desvio
    BEQ(InstrucaoTipoI.class, 4, Comportamento.LE_REGISTRADOR),
    BNE(InstrucaoTipoI.class, 5, Comportamento.LE_REGISTRADOR),
    BLEZ(InstrucaoTipoI.class, 6, Comportamento.LE_REGISTRADOR),
    BGTZ(InstrucaoTipoI.class, 7, Comportamento.LE_REGISTRADOR),

    // Tipo J
    J(InstrucaoTipoJ.class, 2);
    private final Class<? extends InstrucaoMIPS> tipo;
    private final int opCode;
    private final Set<Comportamento> comportamentos;

    // Atualizado para receber varargs de comportamentos
    EnumInstrucoes(Class<? extends InstrucaoMIPS> tipo, int opCode, Comportamento... comportamentos) {
        this.tipo = tipo;
        this.opCode = opCode;
        // Se nenhum comportamento for passado, cria um set vazio. Caso contrário, adiciona os passados.
        if (comportamentos.length == 0) {
            this.comportamentos = EnumSet.noneOf(Comportamento.class);
        } else {
            this.comportamentos = EnumSet.of(comportamentos[0], comportamentos);
        }
    }

    public Class<? extends InstrucaoMIPS> getTipo() {
        return tipo;
    }

    public int getOpCode() {
        return opCode;
    }

    // Métodos utilitários para facilitar a verificação de onde você for usar
    public boolean leMemoria() {
        return comportamentos.contains(Comportamento.LE_MEMORIA);
    }

    public boolean escreveMemoria() {
        return comportamentos.contains(Comportamento.ESCREVE_MEMORIA);
    }

    public boolean leRegistrador() {
        return comportamentos.contains(Comportamento.LE_REGISTRADOR);
    }

    public boolean escreveRegistrador() {
        return comportamentos.contains(Comportamento.ESCREVE_REGISTRADOR);
    }

    public static EnumInstrucoes get(String instrucao) {
        return valueOf(instrucao.toUpperCase());
    }
}
