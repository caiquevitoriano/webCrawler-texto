    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;



/**
 *
 * @author caiq-
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String url = "https://tecmundo.com.br";
        Document doc = null;
        
        
        try {
            // conecta usando a api Jsoup, e recupera a página da url buscada.
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            System.out.println("erro ao buscar a pagina!!");
        }
        
        String title = doc.title();
        System.out.println("Título: " + title);
        System.out.println();
        
        String description = doc.select("meta[name='description']").attr("content");
        System.out.println("Descrição: " + description);
        System.out.println();
        
        String text = doc.select("p").text();
        System.out.println(text);
        
          File file = new File("D:\\textopaginahtml.txt");
        if(!file.exists()) {
            file.createNewFile();
        }
        
        PrintWriter writer = new PrintWriter(file);

        writer.print(title + "\r\n" + "\r\n" + description + "\r\n" + "\r\n" + text);

        System.out.println("----------------------");
        System.out.println("Escrita Completa");
        writer.close();
    }
    
    
    
}
