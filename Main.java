public class Main {

    public static void main(String [] arg) {
        Calculadora calculadora = new Calculadora();
        String peticion = "1 2 + 4 * 3 +";
        System.out.println("Resultado: " + String.valueOf(calculadora.resolver(peticion)));
    }

}