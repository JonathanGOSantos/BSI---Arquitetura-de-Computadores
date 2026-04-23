package conversormips;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import conversormips.dominio.entidades.InstrucaoMIPS;
import conversormips.dominio.enums.EnumInstrucoes;
import conversormips.utils.CaminhoArquivo;

public class ConversorMips {
    private static final String diretorio = "C:\\Teste_Arquitetura\\";

    public static void main(String[] args) {
        ConversorMips conversor = new ConversorMips();

        for (int i = 1; i <= 10; i++) {
            CaminhoArquivo caminho = new CaminhoArquivo(diretorio, "TESTE-" + String.format("%02d", i), "txt");
            List<String> linhasArquivo = conversor.lerArquivo(caminho.getCaminhoCompleto());
            List<String> linhasBinarias = conversor.processarLinhas(linhasArquivo);
            conversor.gravarArquivo(caminho.getCaminhoCompletoResultado(), linhasBinarias);
        }
    }

    public List<String> processarLinhas(List<String> linhas) {
        List<String> linhasBinarias = new ArrayList<>();
        for (String linha : linhas) {
            linhasBinarias.add(processarLinha(linha).getBinario());
        }
        return linhasBinarias;
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