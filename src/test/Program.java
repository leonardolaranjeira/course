package test;

public class Program {
    private String nome;
    private int nivel;

    // O segredo está em retornar o próprio objeto com 'return this'
    public Program setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Program setNivel(int nivel) {
        this.nivel = nivel;
        return this;
    }

    public void exibirInfo() {
        System.out.println("Nome: " + this.nome + " | Nível: " + this.nivel);
    }

    public static void main(String[] args) {
        Program jogador = new Program();

        // Encadeamento de métodos (Method Chaining)
        jogador.setNome("Guerreiro")
                .setNivel(10)
                .exibirInfo();
    }
}
