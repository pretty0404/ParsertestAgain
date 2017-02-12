package testapp.example.com.parsertest;

/**
 * Created by Pretty Rehal on 11/02/2017.
 */

import java.io.InputStream;
import java.util.List;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import testapp.example.com.parsertest.*;
import android.util.Log;

public class SAXXMLParser {

    public static List<Bar> parseBar(InputStream is) {
        List<Bar> bars = null;
        try {
            // create a XMLReader from SAXParser
            XMLReader xmlReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            // create a SAXXMLHandler
            SAXXMLHandler saxHandler = new SAXXMLHandler();
            // store handler in XMLReader
            xmlReader.setContentHandler(saxHandler);
            // the process starts
            xmlReader.parse(new InputSource(is));
            // get the `Employee list`
            bars = saxHandler.getBars();

        } catch (Exception ex) {
            Log.d("XML", "SAXXMLParser: parse() failed");
        }
        // return Employee list
        return bars;
    }

    public static List<Employee> parseEmp(InputStream is) {
        List<Employee> employees = null;
        try {
            // create a XMLReader from SAXParser
            XMLReader xmlReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            // create a SAXXMLHandler
            SAXXMLHandler saxHandler = new SAXXMLHandler();
            // store handler in XMLReader
            xmlReader.setContentHandler(saxHandler);
            // the process starts
            xmlReader.parse(new InputSource(is));
            // get the `Employee list`
            employees = saxHandler.getEmployees();
        } catch (Exception ex) {
            Log.d("XML", "SAXXMLParser: parse() failed");
        }
        // return Employee list
        return employees;
    }
}
