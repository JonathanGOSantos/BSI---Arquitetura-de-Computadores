package dominio.enums;

import dominio.instrucoes.InstrucaoMIPS;
import dominio.instrucoes.InstrucaoTipoI;
import dominio.instrucoes.InstrucaoTipoJ;
import dominio.instrucoes.InstrucaoTipoR;

public enum Instrucao {
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
    LB(InstrucaoTipoI.class),
    LH(InstrucaoTipoI.class),
    LW(InstrucaoTipoI.class),
    SB(InstrucaoTipoI.class),
    SH(InstrucaoTipoI.class),
    SW(InstrucaoTipoI.class),
    // Lógicas e Aritméticas
    ADDI(InstrucaoTipoI.class),
    ANDI(InstrucaoTipoI.class),
    ORI(InstrucaoTipoI.class),
    XORI(InstrucaoTipoI.class),
    LUI(InstrucaoTipoI.class),
    //Desvio
    BEQ(InstrucaoTipoI.class),
    BNE(InstrucaoTipoI.class),
    BLEZ(InstrucaoTipoI.class),
    BGYZ(InstrucaoTipoI.class),

    // Tipo J
    J(InstrucaoTipoJ.class);
    ;
    private final Class<? extends InstrucaoMIPS> tipo;
    Instrucao(Class<? extends InstrucaoMIPS> tipo) {
        this.tipo = tipo;
    }

    public Class<? extends InstrucaoMIPS> getTipo() {
        return tipo;
    }
}
