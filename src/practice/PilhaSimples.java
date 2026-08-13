package practice;

import java.util.ArrayDeque;
import java.util.Deque;

public class PilhaSimples {
    private static final int CAPACIDADE_MAXIMA = 3;

    public static void main(String[] args) {
        simularPilha();
    }

    public static void simularPilha() {
        Deque<Integer> pilha = new ArrayDeque<>();

        push(pilha, 5);
        push(pilha, 8);
        push(pilha, 4);
        push(pilha, 7);

        pop(pilha);
        pop(pilha);

        peek(pilha);

        pop(pilha);
        pop(pilha);
    }

    private static void push(Deque<Integer> pilha, int elemento) {
        if (pilha.size() >= CAPACIDADE_MAXIMA) {
            System.out.println("Pilha cheia!");
        } else {
            pilha.push(elemento);
            System.out.println("Empilhado: " + elemento);
        }
    }

    private static void pop(Deque<Integer> pilha) {
        if (pilha.isEmpty()) {
            System.out.println("Pilha vazia!");
        } else {
            System.out.println("Desempilhado: " + pilha.pop());
        }
    }

    private static void peek(Deque<Integer> pilha) {
        if (pilha.isEmpty()) {
            System.out.println("Pilha vazia!");
        } else {
            System.out.println("Topo atual: " + pilha.peek());
        }
    }
}