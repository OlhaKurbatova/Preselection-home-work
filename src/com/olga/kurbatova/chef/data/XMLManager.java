package com.olga.kurbatova.chef.data;

import com.olga.kurbatova.chef.products.vegetable.Cucumber;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class XMLManager implements CucumbersSource {

    private static final String FILENAME = "cucumberList.xml";

    public ArrayList<Cucumber> readXML() {
        // Строим объектную модель исходного XML файла
        final File xmlFile = new File(System.getProperty("user.dir")
                + File.separator + FILENAME);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        Document doc = null;
        try {
            db = dbf.newDocumentBuilder();
            doc = db.parse(xmlFile);
            doc.getDocumentElement().normalize();
            return getCucumbersFromXML(doc);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private ArrayList<Cucumber> getCucumbersFromXML(Document doc) {
        ArrayList<Cucumber> cucumbers = new ArrayList<Cucumber>();
        //нода - огурец из ХML файла
        NodeList nodeList = doc.getElementsByTagName("cucumber");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            Element element = (Element) node;
            Double weight = Double.valueOf(element.getElementsByTagName("weight").item(0).getTextContent());
            Double caloricity = Double.valueOf(element.getElementsByTagName("caloricity").item(0).getTextContent());
            Double price = Double.valueOf(element.getElementsByTagName("price").item(0).getTextContent());
            String country  = element.getElementsByTagName("country").item(0).getTextContent();
            String name = element.getElementsByTagName("name").item(0).getTextContent();

            Boolean isNative;
            if (country.equalsIgnoreCase("Ukraine")) {
                isNative = true;
            } else isNative = false;
            Cucumber cucumber = new Cucumber(caloricity, weight, price, name, country, isNative);

            cucumbers.add(cucumber);
        }

        return cucumbers;
    }

    @Override
    public ArrayList<Cucumber> getCucumbers() {
        return readXML();
    }

    @Override
    public String getSourceName() {
        return "XML";
    }
}
