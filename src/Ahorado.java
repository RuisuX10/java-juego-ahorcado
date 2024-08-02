import java.util.Scanner;

public class Ahorado {
    public static void main(String[] args) throws Exception {
        //Clase scanner que nos permite que el usuario escriba
        Scanner scanner = new Scanner(System.in);

        //Declaraciones y asignaciones
        String palabraSecreta = "inteligencia";
        int intentosMaximos = 10;
        int intentos = 0;
        boolean fueAdivinada = false;

        //Arreglos
        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        //Estructura de control: iterativa
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }

        while (!fueAdivinada && intentos < intentosMaximos) {
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + ")");

            System.out.println("Introduce una letra por favor");

            char letra = Character.toLowerCase(scanner.next().charAt(0));

            boolean letraCorrecta = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {
                if(palabraSecreta.charAt(i) == letra){
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                };
            }

            if (!letraCorrecta) {
                intentos++;
                System.out.println("Incorrecto. Te quedan " + (intentosMaximos - intentos) + " intentos.");
            }

            if(String.valueOf(letrasAdivinadas).equals(palabraSecreta)){
                fueAdivinada = true;
                System.out.println("Felicidades! has adivinado la palabra secreta: " + palabraSecreta);
            }
        }

        if(!fueAdivinada){
            System.out.println("Game over");
        }

        scanner.close();
    }
}
