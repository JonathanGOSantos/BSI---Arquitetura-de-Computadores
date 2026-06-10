package contadormips;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import contadormips.dominio.entidades.InstrucaoMIPS;
import contadormips.dominio.entidades.InstrucaoTipoI;
import contadormips.dominio.entidades.InstrucaoTipoR;
import contadormips.dominio.enums.EnumInstrucoes;
import contadormips.dominio.enums.EnumRegistradores;
import contadormips.utils.CaminhoArquivo;

public class ContadorMips {
    private static final String diretorio = "/home/jonathan/estudos/Arquitetura de Computadores/Arquitetura-de-Computadores/src/test/";
    private Queue<InstrucaoMIPS> fila;
    private Map<Integer, Integer> tempoParaUso;

    public ContadorMips() {
        this.fila = new LinkedList<>();
        this.tempoParaUso = new HashMap<>();
        resetarTempoDeUso();
    }

    public static void main(String[] args) {
        (new ContadorMips()).run();
    }

    private void resetarTempoDeUso() {
        for (EnumRegistradores registrador : EnumRegistradores.values()) {
            tempoParaUso.put(registrador.getCodigo(), 0);
        }
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                CaminhoArquivo caminho = new CaminhoArquivo(diretorio, "TESTE-" + String.format("%02d", i), "txt");
                List<String> linhas = lerArquivo(caminho.getCaminhoCompleto());
                int ciclos = processarLinhas(linhas);
                System.out.println(ciclos);    
            } catch (Exception e) {
                continue;    
            }
        }
    }

    public int processarLinhas(List<String> linhas) {
        resetarTempoDeUso();
        int bolhas = 0;

        Iterator<String> it = linhas.iterator();
        while (it.hasNext()) {
            InstrucaoMIPS instrucao = processarLinha(it.next());
            if (instrucao instanceof InstrucaoTipoR tipoR) {
                var reg1 = tipoR.getRd();
                var reg2 = tipoR.getRs();
                var reg3 = tipoR.getRt();

                if (tipoR.getInstrucao().leRegistrador()) {
                    int atraso = Math.max(tempoParaUso.get(reg2), tempoParaUso.get(reg3));
                    bolhas += atraso;
                    for (int i = 0; i < atraso; i++) {
                        diminuirTempoDeUso();
                    }
                }

                if (tipoR.getInstrucao().escreveRegistrador()) {
                    tempoParaUso.put(reg1, 1);
                }
            } else if (instrucao instanceof InstrucaoTipoI tipoI) {
                var reg1 = tipoI.getRs(); // Leitura
                var reg2 = tipoI.getRt(); // Leitura / Escrita

                if (tipoI.getInstrucao().leRegistrador()) {
                    int atraso = tempoParaUso.get(reg1);

                    if (!tipoI.getInstrucao().escreveRegistrador() && tempoParaUso.get(reg2) > 0) {
                        atraso = Math.max(tempoParaUso.get(reg1), tempoParaUso.get(reg2));
                    }
                    
                    bolhas += atraso;
                    for (int i = 0; i < atraso; i++) {
                        diminuirTempoDeUso();
                    }
                }

                if (tipoI.getInstrucao().leMemoria()) {
                    tempoParaUso.put(reg2, 2);
                } else if (tipoI.getInstrucao().escreveRegistrador()) {
                    tempoParaUso.put(reg2, 1);
                }
            }
            diminuirTempoDeUso();
        }

        return bolhas + linhas.size() + 4;
    }

    public void diminuirTempoDeUso() {
        for (EnumRegistradores registrador : EnumRegistradores.values()) {
            tempoParaUso.compute(registrador.getCodigo(), (k, tempoAtual) -> Math.max(0, tempoAtual - 1));
        }
    }

    public List<String> lerArquivo(String caminho) {
        List<String> linhas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha = br.readLine();
            while (linha != null) {
                linhas.add(linha);
                linha = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return linhas;
    }

    public void gravarArquivo(String caminho, List<String> linhas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))) {
            for (String linha : linhas) {
                bw.write(linha);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }

    }

    public InstrucaoMIPS processarLinha(String linha) {
        String[] tokens = linha.replace(",", "").split(" ");

        EnumInstrucoes instrucao = EnumInstrucoes.get(tokens[0]);
        if (instrucao == null)
            throw new IllegalArgumentException();
        return InstrucaoMIPS.fromTokens(instrucao.getTipo(), tokens);
    }
}