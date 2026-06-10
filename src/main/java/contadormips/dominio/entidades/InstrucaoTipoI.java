package contadormips.dominio.entidades;

import contadormips.dominio.enums.EnumInstrucoes;
import contadormips.utils.UtilitarioBinario;

public class InstrucaoTipoI extends InstrucaoMIPS {

    private int rs;
    private int rt;
    private int immediate;

    public InstrucaoTipoI(EnumInstrucoes instrucao, int opCode, int rs, int rt, int immediate) {
        super(instrucao, opCode);
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

    @Override
    public String getBinario() {
        StringBuilder sb = new StringBuilder();
        sb.append(UtilitarioBinario.parseInt(opCode, 6));
        sb.append(UtilitarioBinario.parseInt(rs, 5));
        sb.append(UtilitarioBinario.parseInt(rt, 5));
        sb.append(UtilitarioBinario.parseInt(immediate, 16));
        return sb.toString();
    }
}
