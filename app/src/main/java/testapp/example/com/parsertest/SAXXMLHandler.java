package testapp.example.com.parsertest;

/**
 * Created by Pretty Rehal on 11/02/2017.
 */

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import testapp.example.com.parsertest.*;

public class SAXXMLHandler extends DefaultHandler {

    private List<Bar> bars;
    private List<Employee> employees;

    private String tempValBar;
    private String tempValEmp;

    private Bar tempBar;
    private Employee tempEmp;

    public SAXXMLHandler() {//constructor
        bars = new ArrayList<Bar>();
        employees= new ArrayList<Employee>();
    }

    public List<Bar> getBars() {
        return bars;
    }

    public List<Employee> getEmployees(){
        return employees;
    }

    // Event Handlers
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // reset
        tempValBar = "";
        tempValEmp = "";
        if (qName.equalsIgnoreCase("bar")) {
            // create a new instance of bar
            tempBar = new Bar();
            tempEmp = null;
        }
        else if (qName.equalsIgnoreCase("employee")) {
            // create a new instance of bar
            tempEmp = new Employee();
            tempBar = null;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        tempValBar = new String(ch, start, length);
        tempValEmp = new String(ch, start, length);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("bar")) {
            // add it to the list
            bars.add(tempBar);
        } else if (qName.equalsIgnoreCase("employee")) {
            employees.add(tempEmp);
        } else if (qName.equalsIgnoreCase("id")) {
            tempEmp.setId(Integer.parseInt(tempValEmp));
        } else if (qName.equalsIgnoreCase("name")) {
            //tempEmp.setName(tempValEmp);
            if(tempBar!=null){
                tempBar.setName(tempValBar);
            }
            else if(tempEmp!=null){
                tempEmp.setName(tempValEmp);
            }
        } else if (qName.equalsIgnoreCase("description")) {
            tempBar.setDescription(tempValBar);
        } else if (qName.equalsIgnoreCase("openinghours")) {
            tempBar.setOpeningHours(tempValBar);
        } else if (qName.equalsIgnoreCase("prices")) {
            tempBar.setPrices(tempValBar);
        } else if (qName.equalsIgnoreCase("department")) {
            tempEmp.setDepartment(tempValEmp);
        } else if (qName.equalsIgnoreCase("type")) {
            tempEmp.setType(tempValEmp);
        }

    }
}
