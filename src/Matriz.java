import java.util.Random;
import java.util.Scanner;

public class Matriz {
    private int[][] matriz;
    private int linhas;
    private int colunas;

    // Construtor para inicializar a matriz com dimensões definidas pelo usuário
    public Matriz(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.matriz = new int[linhas][colunas];
    }

    // Método para preencher a matriz manualmente
    public void preencherManual() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira os valores para a matriz:");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }
    }

    // Método para preencher a matriz com valores aleatórios
    public void preencherAleatorio() {
        Random random = new Random();
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = random.nextInt(100); // Valores entre 0 e 99
            }
        }
        System.out.println("Matriz preenchida com valores aleatórios.");
    }

    // Método para inserir um elemento em uma posição específica
    public void inserirElemento(int linha, int coluna, int valor) {
        if (linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas) {
            matriz[linha][coluna] = valor;
        } else {
            System.out.println("Posição inválida.");
        }
    }

    // Método para remover um elemento em uma posição específica (seta o valor como 0)
    public void removerElemento(int linha, int coluna) {
        if (linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas) {
            matriz[linha][coluna] = 0;
        } else {
            System.out.println("Posição inválida.");
        }
    }

    // Método para exibir a matriz
    public void exibirMatriz() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }


    //ORDENAÇÃO

    // Bubble Sort aplicado a cada linha
    public void bubbleSortPorLinha() {
        for (int i = 0; i < linhas; i++) {
            bubbleSort(matriz[i]);
        }
    }

    // Bubble Sort aplicado a cada coluna
    public void bubbleSortPorColuna() {
        for (int j = 0; j < colunas; j++) {
            int[] coluna = new int[linhas];
            for (int i = 0; i < linhas; i++) {
                coluna[i] = matriz[i][j];
            }
            bubbleSort(coluna);
            for (int i = 0; i < linhas; i++) {
                matriz[i][j] = coluna[i];
            }
        }
    }

    // Ordenar toda a matriz como um vetor
    public void ordenarMatrizCompleta() {
        int[] array = achatarMatriz();
        mergeSort(array, 0, array.length - 1); // Usando Merge Sort
        reconstruirMatriz(array);
    }

    // Método Bubble Sort para um array (iterativo)
    private void bubbleSort(int[] array) {
        boolean trocou;
        do {
            trocou = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    trocou = true;
                }
            }
        } while (trocou);
    }

    // Merge Sort (recursivo) para um array
    private void mergeSort(int[] array, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = (esquerda + direita) / 2;
            mergeSort(array, esquerda, meio);
            mergeSort(array, meio + 1, direita);
            merge(array, esquerda, meio, direita);
        }
    }

    // Mesclar duas subpartes de um array (método auxiliar para o Merge Sort)
    private void merge(int[] array, int esquerda, int meio, int direita) {
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;

        int[] esquerdaArray = new int[n1];
        int[] direitaArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            esquerdaArray[i] = array[esquerda + i];
        }
        for (int j = 0; j < n2; j++) {
            direitaArray[j] = array[meio + 1 + j];
        }

        int i = 0, j = 0;
        int k = esquerda;
        while (i < n1 && j < n2) {
            if (esquerdaArray[i] <= direitaArray[j]) {
                array[k] = esquerdaArray[i];
                i++;
            } else {
                array[k] = direitaArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = esquerdaArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = direitaArray[j];
            j++;
            k++;
        }
    }

    // Achatar a matriz em um vetor
    private int[] achatarMatriz() {
        int[] array = new int[linhas * colunas];
        int index = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                array[index++] = matriz[i][j];
            }
        }
        return array;
    }

    // Reconstruir a matriz a partir de um vetor
    private void reconstruirMatriz(int[] array) {
        int index = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = array[index++];
            }
        }
    }
}
