import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //TESTES DA CLASSE MATRIZ

        Matriz matriz = new Matriz(3, 3);

        // Preenchimento manual
        matriz.preencherManual();
        matriz.exibirMatriz();

        // Inserção de um elemento
        matriz.inserirElemento(1, 1, 99);
        matriz.exibirMatriz();

        // Remoção de um elemento
        matriz.removerElemento(1, 1);
        matriz.exibirMatriz();

        // Preenchimento aleatório
        matriz.preencherAleatorio();
        matriz.exibirMatriz();


        // TESTES DOS ALGORITMOS DE ORDEDNAÇÃO

        Scanner scanner = new Scanner(System.in);
        Matriz matriz = new Matriz(4, 4); // Exemplo com 3x3
        matriz.preencherAleatorio();

        System.out.println("Matriz original:");
        matriz.exibirMatriz();

        System.out.println("Escolha uma opção de ordenação:");
        System.out.println("1. Ordenar por linhas (Bubble Sort)");
        System.out.println("2. Ordenar por colunas (Bubble Sort)");
        System.out.println("3. Ordenar matriz completa (Merge Sort)");

        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                matriz.bubbleSortPorLinha();
                break;
            case 2:
                matriz.bubbleSortPorColuna();
                break;
            case 3:
                matriz.ordenarMatrizCompleta();
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        System.out.println("Matriz após ordenação:");
        matriz.exibirMatriz();

    }
}