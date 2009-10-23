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
            URL url = new URL("http://dl.getdropbox.com/u/1737059/www.seungjin.net/data/contentswithouthidden.xml");
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

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();


        try {
            //Using factory get an instance of document builder
            DocumentBuilder db = dbf.newDocumentBuilder();

            ByteArrayInputStream bs = new ByteArrayInputStream(this.source.getBytes("UTF8"));

            //parse using builder to get DOM representation of the XML file
            Document dom = db.parse(bs);

            Element docElement = dom.getDocumentElement();

            NodeList nl = docElement.getElementsByTagName("content");

            String date = new String();
            String time = new String();
            String timezone = new String();
            String category = new String();
            String comment = new String();
            String ref = new String();

            if(nl != null && nl.getLength() > 0) {
                for(int i = 0 ; i < nl.getLength();i++) {
                    Element el = (Element)nl.item(i);

                    if ( el.getElementsByTagName("date").item(0).equals(null) ) {
                        date = "null";
                    } else {
                        date = el.getElementsByTagName("date").item(0).getFirstChild().getNodeValue();
                    }

                    if ( el.getElementsByTagName("category").item(0).equals(null) ) {
                        category = "null";
                    } else {
                        category = el.getElementsByTagName("category").item(0).getFirstChild().getNodeValue();
                    }

                    if ( el.getElementsByTagName("comment").item(0).equals(null) ) {
                        comment = "null";
                    } else {
                        comment = el.getElementsByTagName("comment").item(0).getFirstChild().getNodeValue();
                    }


                    ////////////
                    
                    try { 
                        time = el.getElementsByTagName("time").item(0).getFirstChild().getNodeValue();
                    } catch (Exception e) {
                        time = "null";
                    }

                    try {
                        timezone = el.getElementsByTagName("timezone").item(0).getFirstChild().getNodeValue();
                    } catch (Exception e) {
                        timezone = "null";
                    }

                    try {
                        ref = el.getElementsByTagName("ref").item(0).getFirstChild().getNodeValue();
                    } catch (Exception e) {
                        ref = "null";
                    }
                    
                    System.out.println("-");
                    System.out.println(date);
                    System.out.println(time);
                    System.out.println(timezone);
                    System.out.println(comment);
                    System.out.println(ref);
                    System.out.println("-");




                    PersistenceManager pm = PMF.get().getPersistenceManager();
                    Journal c = new Journal(category, comment, ref);
                    try {
                        pm.makePersistent(c);
                        System.out.println("inserting...");
                    } finally {
                        pm.close();
                    }


                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        


    }


    
}
