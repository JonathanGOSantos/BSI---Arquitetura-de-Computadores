package contadormips.dominio.entidades;

public class InstrucaoEscritaNaMemoria extends InstrucaoTipoI {

    public InstrucaoEscritaNaMemoria(int opCode, int rs, int rt, int immediate) {
        super(opCode, rs, rt, immediate);
    }

}
