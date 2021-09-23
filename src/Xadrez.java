public class Xadrez {
    public static void main(String[] args) throws Exception {
        int[][] tabuleiro = {{4, 3, 2, 5, 6, 2, 3, 4}, // montar tabuleiro aqui
                             {1, 1, 1, 1, 1, 1, 1, 1},
                             {0, 0, 0, 0, 0, 0, 0, 0},
                             {0, 0, 0, 0, 0, 0, 0, 0},
                             {0, 0, 0, 0, 0, 0, 0, 0},
                             {0, 0, 0, 0, 0, 0, 0, 0},
                             {1, 1, 1, 1, 1, 1, 1, 1},
                             {4, 3, 2, 5, 6, 2, 3, 4}};

        /* Vazio: 0
           Peão: 1
           Bispo: 2
           Cavalo: 3
           Torre: 4
           Rainha: 5
           Rei: 6
         */
        int[] pecas = {0, 0, 0, 0, 0, 0, 0};

        for (int[] i : tabuleiro) {
            for (int j : i) {
                try {
                    pecas[j]++;
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new Exception("Peça inválida");
                }
            }
        }

        System.out.printf("Peão: %d peça(s)\n", pecas[1]);
        System.out.printf("Bispo: %d peça(s)\n", pecas[2]);
        System.out.printf("Cavalo: %d peça(s)\n", pecas[3]);
        System.out.printf("Torre: %d peça(s)\n", pecas[4]);
        System.out.printf("Rainha: %d peça(s)\n", pecas[5]);
        System.out.printf("Rei: %d peça(s)\n", pecas[6]);
    }
}
