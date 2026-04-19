package conversormips;

import java.util.List;

import conversormips.dominio.entidades.InstrucaoMIPS;
import conversormips.dominio.enums.EnumInstrucoes;

public class ConversorMips {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public List<String> lerArquivo(String caminho) {
        throw new UnsupportedOperationException("Método ainda não implementado.");
    }

    public void gravarArquivo(String caminho, List<String> conteudo) {
        throw new UnsupportedOperationException("Método ainda não implementado.");
    }

    public InstrucaoMIPS processarLinha(String linha) {
        String[] tokens = linha.replace(",", "").split(" ");

        EnumInstrucoes instrucao = EnumInstrucoes.get(tokens[0]);
        if (instrucao == null)
            throw new IllegalArgumentException();

        return InstrucaoMIPS.fromTokens(instrucao.getTipo(), tokens);
    }
}