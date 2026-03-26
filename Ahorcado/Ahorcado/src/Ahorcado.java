import java.util.Random;
import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {

        String[] palabras = {
            "casa", "perro", "gato", "mesa", "silla",
            "puerta", "ventana", "agua", "comida", "escuela",
            "trabajo", "amigo", "familia", "tiempo", "dinero",
            "ciudad", "calle", "coche", "libro", "mano",
            "sol", "luna", "niño", "niña", "día",
            "noche", "música", "ropa", "zapato", "árbol"
        };

        Random ramdom = new Random();
        
        System.out.println("Bienvenido al juego");
        System.out.println("Iniciamos, se ha generado una palabra secreta...");

        Scanner scanner = new Scanner(System.in);
        String palabraSecreta = palabras[ramdom.nextInt(palabras.length)];
        boolean palabraAdivinada = false;
        char letrasAdivinadas [] = new char[palabraSecreta.length()];
        int intentos = 0;
        int intentosMaximo = 7;

        for(int i = 0;i < palabraSecreta.length(); i++){
            letrasAdivinadas[i] = '_';
        }
        
        while (!palabraAdivinada && intentos < intentosMaximo){
            //Validar si ya adivinó la palabra
            for(int i = 0;i < letrasAdivinadas.length; i++){
                if(letrasAdivinadas[i] == '_'){
                    palabraAdivinada = false;
                    break;
                }
                palabraAdivinada = true;
            }
            
            if(!palabraAdivinada){
                System.out.println("Palabra a adivinar " + String.valueOf(letrasAdivinadas));

                System.out.println("Introduce una letra, por favor");

                char letra = scanner.next().charAt(0);

                boolean letraCorrecta = false;

                for(int i = 0; i < palabraSecreta.length();i++){
                    if(palabraSecreta.charAt(i) == letra){
                        letrasAdivinadas[i] = letra;
                        letraCorrecta = true;
                    }
                }

                if(!letraCorrecta){
                    intentos++;
                    switch (intentos) {
                        case 1:
                            System.out.println("=========");
                            break;
                        case 2:
                            System.out.println("      |");
                            System.out.println("=========");
                            break;
                        case 3:
                            System.out.println(" / \\  |");
                            System.out.println("      |");
                            System.out.println("=========");
                            break;
                        case 4:
                            System.out.println(" /|\\  |");
                            System.out.println(" / \\  |");
                            System.out.println("      |");
                            System.out.println("=========");
                            break;
                        case 5:
                            System.out.println("  O   |");
                            System.out.println(" /|\\  |");
                            System.out.println(" / \\  |");
                            System.out.println("      |");
                            System.out.println("=========");
                            break;
                        case 6:
                            System.out.println("  |   |");
                            System.out.println("  O   |");
                            System.out.println(" /|\\  |");
                            System.out.println(" / \\  |");
                            System.out.println("      |");
                            System.out.println("=========");
                            break;
                        case 7:
                            System.out.println("GAME OVER!");
                            System.out.println("  +---+");
                            System.out.println("  |   |");
                            System.out.println("  O   |");
                            System.out.println(" /|\\  |");
                            System.out.println(" / \\  |");
                            System.out.println("      |");
                            System.out.println("=========");

                            System.out.println("La palabra era " + palabraSecreta);
                            break;
                        default:
                            break;
                    }
                }
            }
            else
            {
                System.out.println("Felicidades, has ganado!!!\\n has adivinado la palabra " + palabraSecreta);
                break;
            }
        }
    }
}
