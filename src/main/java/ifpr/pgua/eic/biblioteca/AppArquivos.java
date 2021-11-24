package ifpr.pgua.eic.biblioteca;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AppArquivos {
    
    public static void main(String[] args){
        
        //escreveArquivoTexto();
        //leArquivoTexto();
        //escreveArquivoBinario();
        leArquivoBinario();



    }

    private static void escreveArquivoBinario(){
        try{
            File arq = new File("arquivo.bin");
            FileOutputStream fos = new FileOutputStream(arq);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            bos.write(new Double(26.0).byteValue());

            bos.close();
            fos.close();


        }catch(IOException e){
            System.out.println("Erro na leitura do arquivo binário!"+e.getMessage());
        }
    }

    private static void leArquivoBinario(){
        try{
            File arq = new File("arquivo.bin");
            FileInputStream fis = new FileInputStream(arq);
            BufferedInputStream bis = new BufferedInputStream(fis);

            
            


        }catch(IOException e){
            System.out.println("Erro na escrita do arquivo binário!"+e.getMessage());    
        }
    }


    private static void leArquivoTexto(){
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

    private static void escreveArquivoTexto(){
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

