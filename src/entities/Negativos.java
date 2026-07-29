package entities;

public class Negativos {
    private int[] vetor;

    public int[] getVetor() {
        return vetor;
    }

    public void setVetor(int[] vetorNegativo) {
        this.vetor = vetorNegativo;
    }

    public void negativos(int index, int[] novoVetor) {
        this.vetor = new int[index];
        int cont = 0;
        for (int i = 0; i < novoVetor.length; i++) {
            if (novoVetor[i] < 0) {
                vetor[cont] = novoVetor[i];
                cont++;
            }
        }
        setVetor(vetor);
    }
}
