package mykitab.mykitabcomptepu.XmlParsers;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 07/07/2016.
 */


public class XMLPullParserHandler {
    static final String KEY_SITE = "site";
    static final String KEY_NAME = "name";
    static final String KEY_LINK = "link";
    static final String KEY_ABOUT = "about";


    List<Employee> employees;
    private Employee employee;
    String curText = "";

    public XMLPullParserHandler() {
        employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Employee> parse(InputStream is) {
        XmlPullParserFactory factory = null;
        XmlPullParser parser = null;
        try {
            factory = XmlPullParserFactory.newInstance();
            // factory.setNamespaceAware(true);
            parser = factory.newPullParser();

            parser.setInput(is, null);

            int eventType = parser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {

                String tagname = parser.getName();

                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase(KEY_SITE)) {
                            // create a new instance of employee
                            employee = new Employee();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        curText = parser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if (tagname.equalsIgnoreCase(KEY_SITE)) {
                            // add employee object to list
                            employees.add(employee);
                        } else if (tagname.equalsIgnoreCase(KEY_NAME)) {
                            employee.setName(curText);
                        }else if (tagname.equalsIgnoreCase(KEY_LINK)) {
                            employee.setLink(curText);
                        } else if (tagname.equalsIgnoreCase(KEY_ABOUT)) {
                            employee.setAbout(curText);
                        }
                        break;

                    default:
                        break;
                }
                eventType = parser.next();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;
    }
}

