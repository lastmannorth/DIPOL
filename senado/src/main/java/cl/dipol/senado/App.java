package cl.dipol.senado;

import java.net.URLEncoder;
import java.util.List;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;


/**
 * Simple example of Yoctopuce library usage
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println("Senado command line example");

        String searchQuery = "7767" ;
		
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        try {
          String searchUrl = "https://www.senado.cl/appsenado/index.php?mo=sesionessala&ac=detalleVotacion&votaid=" + URLEncoder.encode(searchQuery, "UTF-8");
          HtmlPage page = client.getPage(searchUrl);
          DomElement main = page.getElementById("main");
          HtmlElement container = (HtmlElement) main.getByXPath("div/section/div").get(0);
          String tema = container.getChildNodes().get(5).asText();
          
         
          System.out.print(tema);
         
          HtmlTable votaTable = (HtmlTable) container.getChildNodes().get(6);
          
         List<HtmlElement> trList = votaTable.getByXPath(".//tr");
          for(HtmlElement tr : trList) {
        	  List<HtmlElement> tdList = tr.getByXPath(".//td");
        	  String senador = tdList.get(0).asText();
        	  String favor = tdList.get(1).asText();
        	  String contra = tdList.get(2).asText();
        	  String abstencion = tdList.get(3).asText();
        	  String pareo = tdList.get(4).asText();
        	  
          }
        }catch(Exception e){
          e.printStackTrace();
        }finally {
        	client.close();
        }
        
    }
}
