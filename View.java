public class View {
    
    public View() {}

    /**
     * ejecuta el programa y crea objeto tupo calculadora
     */
    public void execute() {
        Reader reader = new Reader();
        Calculadora calculadora = new Calculadora();
        String peticion = reader.readFile();
        System.out.println("Resultado: " + String.valueOf(calculadora.resolver(peticion)));
    }

}