package conversormips;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import conversormips.dominio.entidades.InstrucaoMIPS;
import conversormips.dominio.enums.EnumInstrucoes;

public class ConversorMips {
    public static void main(String[] args) {
        ConversorMips conversor = new ConversorMips();
        String caminho = "C:\\Teste_Arquitetura\\";

        for (int i = 1; i <= 2; i++) {
            String nomeArquivo = "TESTE-0"+i;
            conversor.gravarArquivo(caminho+nomeArquivo+"-RESULTADO.txt", conversor.processarLinhas(conversor.lerArquivo(caminho+nomeArquivo+".txt")));
        }
    }
    public List<String> processarLinhas(List<String> linhas){
        List<String> linhasBinarias = new ArrayList<>();
        for (String linha: linhas){
            linhasBinarias.add(processarLinha(linha).getBinario());
        }
        return linhasBinarias;
    }

    public List<String> lerArquivo(String caminho) {
        List<String> linhas = new ArrayList<>();
        try(BufferedReader  br = new BufferedReader(new FileReader(caminho))){
            String linha = br.readLine();
            while(linha != null){
                linhas.add(linha);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return linhas;

    }

    public void gravarArquivo(String caminho, List<String> linhas) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))){
            for (String linha: linhas){
                bw.write(linha);
                bw.newLine();
            }

        }catch (IOException e){
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