import java.io.*;

public class Reader {
    
    /**
     * Constructor vacio
     */
    public Reader() {}

    /**
     * @return devuelve la linea escrita en el txt 
     */
    public String readFile() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linea = "";

        try {
           archivo = new File ("datos.txt");
           fr = new FileReader (archivo);
           br = new BufferedReader(fr);
  
           linea = br.readLine();
        }
        catch(Exception e){
           linea = e.toString();
        }finally{
           try{                    
              if( null != fr ){   
                 fr.close();     
              }                  
           }catch (Exception e2){ 
              linea = e2.toString();
           }
        }

        return linea;
    }

}