import dominio.bancos.BancoRegistradores;
import dominio.enums.Instrucao;
import dominio.instrucoes.InstrucaoTipoI;
import dominio.instrucoes.InstrucaoTipoJ;
import dominio.instrucoes.InstrucaoTipoR;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String linha = "add $s0, $s1, $s2";
        String linhaLimpa = linha.replace(",", "");
        String[] tokens = linhaLimpa.split(" ");
        var tipo = Instrucao.valueOf(tokens[0].toUpperCase()).getTipo();
        if (tipo.equals(InstrucaoTipoR.class)) {
            System.out.println("Tipo R");

            var rs = tokens[2];
            var rt = tokens[3];
            var rd = tokens[1];
            if (BancoRegistradores.existe(rs)) {
                int numReg = BancoRegistradores.getNumero(rs);
                System.out.println("O registrador " + rs + " é o número: " + numReg);
            } else {
                System.out.println("Erro: Registrador inválido!");
            }

            if (BancoRegistradores.existe(rt)) {
                int numReg = BancoRegistradores.getNumero(rt);
                System.out.println("O registrador " + rt + " é o número: " + numReg);
            } else {
                System.out.println("Erro: Registrador inválido!");
            }

            if (BancoRegistradores.existe(rd)) {
                int numReg = BancoRegistradores.getNumero(rd);
                System.out.println("O registrador " + rd + " é o número: " + numReg);
            } else {
                System.out.println("Erro: Registrador inválido!");
            }
        } else if (tipo.equals(InstrucaoTipoI.class)) {
            System.out.println("Tipo I");
        } else if (tipo.equals(InstrucaoTipoJ.class)) {
            System.out.println("Tipo J");
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static List<String> lerArquivo(String caminho) {
        throw new UnsupportedOperationException("Método ainda não implementado.");
    }

    public static void gravarArquivo(String caminho, List<String> conteudo) {
        throw new UnsupportedOperationException("Método ainda não implementado.");
    }

}