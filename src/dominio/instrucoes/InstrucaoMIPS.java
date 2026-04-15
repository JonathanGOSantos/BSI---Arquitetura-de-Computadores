package dominio.instrucoes;

public abstract class InstrucaoMIPS {
    protected int opCode;

    public InstrucaoMIPS(int opCode) {
        this.opCode = opCode;
    }

    public int getOpCode() {
        return opCode;
    }

    public void setOpCode(int opCode) {
        this.opCode = opCode;
    }
}
