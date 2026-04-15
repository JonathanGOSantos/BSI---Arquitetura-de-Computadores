package dominio.instrucoes;

public class InstrucaoTipoJ extends InstrucaoMIPS {

    private int address;

    public InstrucaoTipoJ(int opCode, int address) {
        super(opCode);
        this.address = address;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }
}
