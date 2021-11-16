package ifpr.pgua.eic.biblioteca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AppArquivos {
    
    public static void main(String[] args){
        
        //escreveArquivo();
        leArquivo();
        

    }

    private static void leArquivo(){
        try{
            File arq = new File("arquivo.txt");
            FileReader fr = new FileReader(arq);
            BufferedReader br = new BufferedReader(fr);

            String linha = br.readLine();

            while(linha != null){
                System.out.println(linha);
                linha = br.readLine();
            }
        
            br.close();
            fr.close();
        }catch(IOException e){
            System.out.println("Erro com o arquivo!!! "+e.getMessage());
        }
    }

    private static void escreveArquivo(){
        try{
            File arq = new File("arquivo.txt");
            FileWriter fw = new FileWriter(arq);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Testando a escrita em arquivos...1");
            bw.newLine();
            bw.write("Outra linha no arquivo..."+(10));
            bw.newLine();

            bw.close();
            fw.close();
            
        }catch(IOException e){
            System.out.println("Erro com o arquivo!!! "+e.getMessage());
        }
    }
}
