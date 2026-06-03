package contadormips.dominio.enums;

import contadormips.dominio.entidades.InstrucaoEscritaNaMemoria;
import contadormips.dominio.entidades.InstrucaoMIPS;
import contadormips.dominio.entidades.InstrucaoTipoI;
import contadormips.dominio.entidades.InstrucaoTipoJ;
import contadormips.dominio.entidades.InstrucaoTipoR;

public enum EnumInstrucoes {
    // Tipo R
    // Lógicas e Aritméticas
    ADD(InstrucaoTipoR.class),
    SUB(InstrucaoTipoR.class),
    AND(InstrucaoTipoR.class),
    OR(InstrucaoTipoR.class),
    XOR(InstrucaoTipoR.class),
    // Deslocamento de Bits
    SLL(InstrucaoTipoR.class),
    SRL(InstrucaoTipoR.class),
    // Desvio
    JR(InstrucaoTipoR.class),

    // Tipo I
    // Load e Store
    LB(InstrucaoEscritaNaMemoria.class, 32),
    LH(InstrucaoEscritaNaMemoria.class, 3),
    LW(InstrucaoEscritaNaMemoria.class, 35),
    SB(InstrucaoTipoI.class, 40),
    SH(InstrucaoTipoI.class, 41),
    SW(InstrucaoTipoI.class, 43),
    // Lógicas e Aritméticas
    ADDI(InstrucaoTipoI.class, 8),
    ANDI(InstrucaoTipoI.class, 12),
    ORI(InstrucaoTipoI.class, 13),
    XORI(InstrucaoTipoI.class, 14),
    LUI(InstrucaoTipoI.class, 15),
    //Desvio
    BEQ(InstrucaoTipoI.class, 4),
    BNE(InstrucaoTipoI.class, 5),
    BLEZ(InstrucaoTipoI.class, 6),
    BGTZ(InstrucaoTipoI.class, 7),

    // Tipo J
    J(InstrucaoTipoJ.class, 2);
    private final Class<? extends InstrucaoMIPS> tipo;
    private final int opCode;

    EnumInstrucoes(Class<InstrucaoTipoR> tipo) {
        this.tipo = tipo;
        this.opCode = 0;
    }

    EnumInstrucoes(Class<? extends InstrucaoMIPS> tipo, int opCode) {
        this.tipo = tipo;
        this.opCode = opCode;
    }

    public Class<? extends InstrucaoMIPS> getTipo() {
        return tipo;
    }

    public int getOpCode() {
        return opCode;
    }

    public static EnumInstrucoes get(String instrucao) {
        return valueOf(instrucao.toUpperCase());
    }
}
