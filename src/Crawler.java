/**
 * Created by nathangrant.
 */

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Crawler {

    public static void main(String []args){

        String url="http://www.netinstructions.com/how-to-make-a-simple-web-crawler-in-java/";
        String word="Java";


        try {
            boolean wordFound=Crawler(url,word);

            if(wordFound){
                System.out.println("The word was found on this website");
            }
            else{
                System.out.println("The word was not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public static boolean Crawler(String url, String word) throws Exception{

        try {
            Connection connection = Jsoup.connect(url + ""); //Access the server side through HTTPrequests
            Document htmlD = connection.get();              //Document is contained here
            String bodytext=htmlD.body().text();

            if(bodytext.toLowerCase().contains(word.toLowerCase())){
                return true;
            }
            else{
                return false;
            }
        }
        catch(IOException ioe){
            System.out.println("Link was not found");
        }
        return true;
    }

}
