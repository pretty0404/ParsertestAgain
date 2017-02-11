package testapp.example.com.parsertest;

/**
 * Created by Pretty Rehal on 11/02/2017.
 */

import java.io.IOException;
import java.util.List;
import testapp.example.com.parsertest.*;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class SAXParserActivity extends Activity implements OnClickListener, OnItemSelectedListener {

    Button buttonBars;
    Button buttonEmp;
//
//    Spinner spinner;
//
//    ListView listView;
//    ListView listView2;

//    List<Employee> employees = null;
//    List<Bar> bars = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        findViewsById();
        //display();
        buttonBars.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(SAXParserActivity.this, Bar.class);
                        startActivity(intent);
                    }
        });
        buttonEmp.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(SAXParserActivity.this, Employee.class);
                        startActivity(intent);
                    }
                });
    }//end onCreate

    private void findViewsById() {
        buttonBars = (Button) findViewById(R.id.buttonClickBars);
        buttonEmp = (Button) findViewById(R.id.buttonClickEmployees);
    }

//    public void display() {
//        try {
//            bars = SAXXMLParser.parse(getAssets().open("bars.xml"));
//            employees = SAXXMLParser.parseEmp(getAssets().open("bars.xml"));
//
//            ArrayAdapter<Bar> adapter = new ArrayAdapter<Bar>(this, R.layout.list_item, bars);
//            ArrayAdapter<Employee> adapterEmp = new ArrayAdapter<Employee>(this, R.layout.list_item, employees);
//
//            listView.setAdapter(adapter);
//            listView.setOnItemSelectedListener(this);
//            listView2.setAdapter(adapterEmp);
//            listView2.setOnItemSelectedListener(this);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//        Bar bar = (Bar) parent.getItemAtPosition(pos);
//        Toast.makeText(parent.getContext(), bar.getBarDetails(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }

    @Override
    public void onClick(View v) {

    }
}
