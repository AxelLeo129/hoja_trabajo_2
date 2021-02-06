import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import java.lang.NumberFormatException;

/**
 * @author Axel Lopez
 * @author Luis Pedro Gonzalez
 *
 */
public class Calculadora implements Icalculadora, Pila < Double > {

    private Stack < Double > stack = new Stack < Double > ();
    private String[] operadores = {
        "+",
        "-",
        "*",
        "/"
    };

    /**
     * Constructor vacio
     */
    public Calculadora() {}

    
    /** 
     * @param input
     * @return double
     */
    @Override
    public double resolver(String input) {
        String[] comandos = input.split(" ");
        for (int i = 0; i < comandos.length; i++) {
            if (!comandos[i].equals(" ")) {
                if (!Arrays.asList(operadores).contains(comandos[i])) {
                    try {
                        push(Double.parseDouble(comandos[i]));
                    } catch(NumberFormatException e) {
                        System.out.println("El achivo '.txt' no tiene el formato correcto");
                        return Double.NaN;
                    }
                } else {
                    int largo = size();
                    ArrayList < Double > operandos_ordenados = new ArrayList < > ();
                    for (int j = 0; j < largo; j++) {
                        operandos_ordenados.add(pop());
                    }
                    if (operandos_ordenados.size() > 1) {
                        Double resultado = operandos_ordenados.get(operandos_ordenados.size() - 1);
                        for (int j = (operandos_ordenados.size() - 2); j > -1; j--) {
                            ScriptEngineManager mgr = new ScriptEngineManager();
                            ScriptEngine engine = mgr.getEngineByName("JavaScript");
                            try {
                                resultado = (double) engine.eval(resultado + " " + comandos[i] + String.valueOf(operandos_ordenados.get(j)));
                            } catch (ScriptException e) {
                                e.printStackTrace();
                            }
                        }
                        push(resultado);
                    } else {
                        System.out.println("El achivo '.txt' no tiene el formato correcto.");
                        return Double.NaN;
                    }
                }
            }
        }
        return pop();
    }

    
    /** 
     * @return boolean
     */
    @Override
    public boolean empty() {
        return stack.empty();
    }

    
    /** 
     * @return int
     */
    @Override
    public int size() {
        return stack.size();
    }

    
    /** 
     * @param item
     */
    @Override
    public void push(Double item) {
        stack.push(item);
    }

    
    /** 
     * @return Double
     */
    @Override
    public Double pop() {
        return stack.pop();
    }

    
    /** 
     * @return Double
     */
    @Override
    public Double peek() {
        return stack.peek();
    }

}