package contadormips;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import contadormips.dominio.entidades.InstrucaoEscritaNaMemoria;
import contadormips.dominio.entidades.InstrucaoMIPS;
import contadormips.dominio.enums.EnumInstrucoes;
import contadormips.dominio.enums.EnumRegistradores;
import contadormips.utils.CaminhoArquivo;

public class ContadorMips {
    private static final String diretorio = "C:\\Teste_Arquitetura\\";
    private Queue<InstrucaoMIPS> fila;
    private Map<Integer, Integer> tempoParaUso;

    public ContadorMips() {
        this.fila = new LinkedList<>();
        this.tempoParaUso = new HashMap<>();

        for (EnumRegistradores registrador : EnumRegistradores.values()) {
            tempoParaUso.putIfAbsent(registrador.getCodigo(), 0);
        }
    }

    public static void main(String[] args) {
        (new ContadorMips()).run();
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            CaminhoArquivo caminho = new CaminhoArquivo(diretorio, "TESTE-" + String.format("%02d", i), "txt");
            List<String> linhas = lerArquivo(caminho.getCaminhoCompleto());
            int ciclos = processarLinhas(linhas);

            // lw $s1, 1200($zero)
            // bolha
            // bolha
            // add $t0, $s1, $s2
        }
    }
    
    public int processarLinhas(List<String> linhas) {
        Iterator<String> it = linhas.iterator();
        String linha = it.next();
        while (it.hasNext()) {
            InstrucaoMIPS instrucao = processarLinha(linha);
            if (instrucao instanceof InstrucaoEscritaNaMemoria i) {
                int destino = i.getRs();
                tempoParaUso.put(destino, 2);
            }
        }

        return 0;
    }

    public void diminuirTempoDeUso() {
        for (EnumRegistradores registrador : EnumRegistradores.values()) {
            int tempoAtual = tempoParaUso.get(registrador.getCodigo());
            tempoParaUso.put(registrador.getCodigo(), Math.min(0, tempoAtual - 1));
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