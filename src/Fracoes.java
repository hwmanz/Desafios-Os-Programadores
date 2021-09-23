import java.util.Scanner;
import java.io.*;

public class Fracoes {

    // algoritmo de Euclides
    public static int MDC(int a, int b) {
        if (b == 0)
            return a;

        return MDC(b, a % b);
    }

    // retorna a resposta adequada para uma fração
    public static String resposta(int numerador, int denominador){
        if (denominador == 0)
            return "ERR";

        int parteInt = 0;

        // se o numerador for maior ou igual ao denominador, é necessario calcular a parte inteira
        // e calcular o novo numerador
        if (numerador >= denominador) {
            parteInt = numerador / denominador;
            numerador = numerador % denominador;
        }

        int mdc = MDC(numerador, denominador);

        if (parteInt > 0){
            if (numerador > 0)
                return parteInt + " " + numerador/mdc + "/" + denominador/mdc;
            return String.valueOf(parteInt);
        }

        if (numerador == 0)
            return "0";

        return numerador/mdc + "/" + denominador/mdc;
    }

    public static void main(String[] args) throws FileNotFoundException{

        File f;

        // caso exista um argumento, utiliza o argumento como arquivo
        if (args.length > 0){
            f = new File(args[0]);

        // caso não exista utiliza o frac presente na pasta src
        // este arquivo é aquele fornecido pelo site para este desafio
        }else{
            f = new File("src/arquivos/frac.txt");
        }

        Scanner sc = new Scanner(f);

        while (sc.hasNextLine()){
            String[] fracao = sc.nextLine().split("/");

            int numerador = Integer.parseInt(fracao[0]);
            int denominador = 1;

            // verifica se há denominador, pois existem casos em que a entrada é apenas um número inteiro
            // se houver, a variável denominador é atualizada
            if (fracao.length == 2)
                denominador = Integer.parseInt(fracao[1]);

            // chama a resposta para cada fração
            System.out.println(resposta(numerador, denominador));

        }

        sc.close();

    }

}

