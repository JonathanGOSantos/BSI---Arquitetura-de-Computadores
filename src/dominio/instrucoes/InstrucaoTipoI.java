package dominio.instrucoes;

public class InstrucaoTipoI extends InstrucaoMIPS {

    private int rs;
    private int rt;
    private int immediate;

    public InstrucaoTipoI(int opCode, int rs, int rt, int immediate) {
        super(opCode);
        this.rs = rs;
        this.rt = rt;
        this.immediate = immediate;
    }

    public int getRs() {
        return rs;
    }

    public void setRs(int rs) {
        this.rs = rs;
    }

    public int getRt() {
        return rt;
    }

    public void setRt(int rt) {
        this.rt = rt;
    }

    public int getImmediate() {
        return immediate;
    }

    public void setImmediate(int immediate) {
        this.immediate = immediate;
    }
}
