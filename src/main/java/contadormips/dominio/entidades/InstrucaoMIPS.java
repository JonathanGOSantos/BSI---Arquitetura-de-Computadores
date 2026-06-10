package contadormips.dominio.entidades;

import contadormips.dominio.enums.EnumInstrucoes;
import contadormips.dominio.enums.EnumRegistradores;

public abstract class InstrucaoMIPS {
    protected EnumInstrucoes instrucao;
    protected int opCode;

    public InstrucaoMIPS(EnumInstrucoes instrucao, int opCode) {
        this.instrucao = instrucao;
        this.opCode = opCode;
    }

    public EnumInstrucoes getInstrucao() {
        return instrucao;
    }

    public int getOpCode() {
        return opCode;
    }

    public void setOpCode(int opCode) {
        this.opCode = opCode;
    }

    public abstract String getBinario();

    public static InstrucaoMIPS fromTokens(Class<? extends InstrucaoMIPS> tipoInstrucao, String[] tokens) {
        if (InstrucaoTipoR.class.equals(tipoInstrucao)) {
            EnumInstrucoes instrucao = EnumInstrucoes.get(tokens[0]);
            int rd = 0, rs = 0, rt = 0, shamt = 0;
            if (tokens.length == 2) {
                // Jump Register
                rs = EnumRegistradores.getCodigo(tokens[1]);
            } else if (tokens[3].startsWith("$")) {
                // Aritimetica
                rd = EnumRegistradores.getCodigo(tokens[1]);
                rs = EnumRegistradores.getCodigo(tokens[2]);
                rt = EnumRegistradores.getCodigo(tokens[3]);
            } else {
                // Deslocamento
                rd = EnumRegistradores.getCodigo(tokens[1]);
                rt = EnumRegistradores.getCodigo(tokens[2]);
                shamt = Integer.parseInt(tokens[3]);
            }
            
            int funct = InstrucaoTipoR.getFuncao(instrucao);

            return new InstrucaoTipoR(instrucao, rs, rt, rd, shamt, funct);
        }

        if (InstrucaoTipoI.class.equals(tipoInstrucao)) {
            var instrucao = EnumInstrucoes.get(tokens[0]);

            var opCode = instrucao.getOpCode();
            int rt = EnumRegistradores.getCodigo(tokens[1]); // Destino
            int rs = 0, immediate = 0;

            if (tokens.length == 3) {
                int startRegister = tokens[2].indexOf("(");
                int endRegister = tokens[2].indexOf(")");
                String rsString = tokens[2].substring(startRegister + 1, endRegister);
                rs = EnumRegistradores.getCodigo(rsString);

                String immediateString = tokens[2].substring(0, startRegister);
                immediate = Integer.parseInt(immediateString);
            } else if (tokens.length == 4) {
                rs = EnumRegistradores.getCodigo(tokens[2]); // Fonte
                immediate = Integer.parseInt(tokens[3]); // Fonte
            }

            return new InstrucaoTipoI(instrucao, opCode, rs, rt, immediate);
        }

        if (InstrucaoTipoJ.class.equals(tipoInstrucao)) {
            var instrucao = EnumInstrucoes.get(tokens[0]);
            var opCode = instrucao.getOpCode();
            var address = Integer.parseInt(tokens[1]);

            return new InstrucaoTipoJ(instrucao, opCode, address);
        }

        throw new IllegalArgumentException("Instrução " + tokens[0] + " não encontrada!");
    }
}
