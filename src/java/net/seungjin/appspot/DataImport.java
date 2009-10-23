/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.seungjin.appspot;

import javax.jdo.PersistenceManager;
import net.seungjin.appspot.Journal;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.jdo.PersistenceManager;

import java.util.Date;
import net.seungjin.appspot.Journal;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import org.w3c.dom.Document;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.io.ByteArrayInputStream;



/**
 *
 * @author seungjin
 */
public class DataImport {

    private String source = new String();

    public DataImport() {

       StringBuilder sb = new StringBuilder();

        try {
            URL url = new URL("http://dl.getdropbox.com/u/1737059/www.seungjin.net/data/contents.xml");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(),"UTF8"));
            String line;

            while ((line = reader.readLine()) != null) {
                // ...
                sb.append(line);
            }
            reader.close();

        } catch (MalformedURLException e) {
            // ...
        } catch (IOException e) {
            // ...
        }

        this.source = sb.toString();


    }


    public String test() {

        StringBuilder sb = new StringBuilder();

        try {
            URL url = new URL("http://dl.getdropbox.com/u/1737059/www.seungjin.net/data/contents.xml");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(),"UTF8"));
            String line;

            while ((line = reader.readLine()) != null) {
                // ...
                sb.append(line);
            }
            reader.close();

        } catch (MalformedURLException e) {
            // ...
        } catch (IOException e) {
            // ...
        }

        return sb.toString();

    }

    public void importAction() {

        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            //Document doc = docBuilder.parse (new File("book.xml"));

            ByteArrayInputStream bs = new ByteArrayInputStream(this.source.getBytes("UTF8"));

            Document doc = docBuilder.parse(bs);

            doc.getDocumentElement ().normalize();
            System.out.println ("Root element of the doc is " + doc.getDocumentElement().getNodeName());

            NodeList listOfContents = doc.getElementsByTagName("content");
            int totalPersons = listOfContents.getLength();
            System.out.println("Total no of people : " + totalPersons);

            for(int s=0; s<listOfContents.getLength() ; s++){
                System.out.println("#"+s);
                System.out.println("#?"+listOfContents.getLength());
                
                Node firstContentNode = listOfContents.item(s);

                if(firstContentNode.getNodeType() == Node.ELEMENT_NODE){
                    
                    Element firstContentElement = (Element)firstContentNode;
                    //System.out.println(firstContentElement.);
                    
                    //-------
                    NodeList dateList = firstContentElement.getElementsByTagName("date");
                    Element dateElement = (Element)dateList.item(0);

                    NodeList textDateList = dateElement.getChildNodes();
                    System.out.println(((Node)textDateList.item(0)).getNodeValue().trim());

                    //-------
                    NodeList timeList = firstContentElement.getElementsByTagName("time");
                    Element timeElement = (Element)timeList.item(0);

                    NodeList textTimeList = timeElement.getChildNodes();
                    System.out.println(((Node)textTimeList.item(0)).getNodeValue().trim());

                    //-------
                    NodeList timezoneList = firstContentElement.getElementsByTagName("timezone");
                    Element timezoneElement = (Element)timezoneList.item(0);

                    NodeList textTimezoneList = timezoneElement.getChildNodes();
                    System.out.println(((Node)textTimezoneList.item(0)).getNodeValue().trim());

                    //-------
                    NodeList categoryList = firstContentElement.getElementsByTagName("category");
                    Element categoryElement = (Element)categoryList.item(0);

                    NodeList textCategoryList = categoryElement.getChildNodes();
                    System.out.println(((Node)textCategoryList.item(0)).getNodeValue().trim());

                    //-------
                    NodeList commentList = firstContentElement.getElementsByTagName("comment");
                    Element commentElement = (Element)commentList.item(0);

                    NodeList textCommentList = commentElement.getChildNodes();
                    System.out.println(((Node)textCommentList.item(0)).getNodeValue().trim());
                    /*
                    //-------
                    NodeList refList = firstContentElement.getElementsByTagName("ref");
                    Element refElement = (Element)refList.item(0);
                    NodeList textRefList = refElement.getChildNodes();
                    if ((Node)textRefList.item(0) != null ) {
                        System.out.println(((Node)textRefList.item(0)).getNodeValue().trim());
                    } else {
                        System.out.println("%%");
                    }
                    */

                }//end of if clause
                

            }//end of for loop with s var
           

        } catch (Exception e) {
            e.printStackTrace();
        }
        


    }


    
}
