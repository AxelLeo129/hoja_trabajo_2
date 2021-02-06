public class View {
    
    public View() {}

    public void execute() {
        Reader reader = new Reader();
        Calculadora calculadora = new Calculadora();
        String peticion = reader.readFile();
        System.out.println("Resultado: " + String.valueOf(calculadora.resolver(peticion)));
    }

}