package ztest;

public class Personagem {
    private String nome;
    private int nivel;

    // O segredo está em retornar o próprio objeto com 'return this'
    public Personagem setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Personagem setNivel(int nivel) {
        this.nivel = nivel;
        return this;
    }

    public void exibirInfo() {
        System.out.println("Nome: " + this.nome + " | Nível: " + this.nivel);
    }

    public static void main(String[] args) {
        Personagem jogador = new Personagem();

        // Encadeamento de métodos (Method Chaining)
        jogador.setNome("Guerreiro")
                .setNivel(10)
                .exibirInfo();
    }
}
