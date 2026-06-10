package contadormips.dominio.entidades;

import contadormips.dominio.enums.EnumInstrucoes;
import contadormips.utils.UtilitarioBinario;

public class InstrucaoTipoJ extends InstrucaoMIPS {

    private int address;

    public InstrucaoTipoJ(EnumInstrucoes instrucao, int opCode, int address) {
        super(instrucao, opCode);
        this.address = address;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    @Override
    public String getBinario() {
        StringBuilder sb = new StringBuilder();
        sb.append(UtilitarioBinario.parseInt(opCode, 6));
        sb.append(UtilitarioBinario.parseInt(address, 26));
        return sb.toString();
    }
}
