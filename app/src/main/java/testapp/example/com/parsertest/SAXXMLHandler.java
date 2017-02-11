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
    private String tempVal;
    private Bar tempEmp;

    public SAXXMLHandler() {
        bars = new ArrayList<Bar>();
    }

    public List<Bar> getBars() {
        return bars;
    }

    // Event Handlers
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        // reset
        tempVal = "";
        if (qName.equalsIgnoreCase("bar")) {
            // create a new instance of employee
            tempEmp = new Bar();
        }
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        tempVal = new String(ch, start, length);
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("bar")) {
            // add it to the list
            bars.add(tempEmp);
        } else if (qName.equalsIgnoreCase("id")) {
            tempEmp.setId(Integer.parseInt(tempVal));
        } else if (qName.equalsIgnoreCase("name")) {
            tempEmp.setName(tempVal);
        }
         else if (qName.equalsIgnoreCase("description")) {
            tempEmp.setDescription(tempVal);
        }
        else if (qName.equalsIgnoreCase("specialnights")) {
            tempEmp.setSpecialNights(tempVal);
        }
        else if (qName.equalsIgnoreCase("openinghours")) {
            tempEmp.setOpeningHours(tempVal);
        }
        else if (qName.equalsIgnoreCase("doorcharge")) {
            tempEmp.setDoorCharge(tempVal);
        }
        else if (qName.equalsIgnoreCase("prices")) {
            tempEmp.setPrices(tempVal);
        }

    }
}
