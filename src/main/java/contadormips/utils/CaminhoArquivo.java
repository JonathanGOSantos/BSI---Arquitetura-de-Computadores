package contadormips.utils;

public class CaminhoArquivo {
    private String nome;
    private String extensao;
    private String caminho;

    public CaminhoArquivo(String caminho, String nome, String extensao) {
        this.caminho = caminho;
        this.nome = nome;
        this.extensao = extensao;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getExtensao() {
        return extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    public String getCaminhoCompleto() {
        return caminho + nome + "." + extensao;
    }

    public String getCaminhoCompletoResultado() {
        return caminho + nome + "-RESULTADO." + extensao;
    }
}