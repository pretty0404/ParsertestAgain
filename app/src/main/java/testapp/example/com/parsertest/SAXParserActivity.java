package testapp.example.com.parsertest;

/**
 * Created by Pretty Rehal on 11/02/2017.
 */

import java.io.IOException;
import java.util.List;
import testapp.example.com.parsertest.*;
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

public class SAXParserActivity extends Activity implements
        OnClickListener, OnItemSelectedListener {

    Button button;
    Spinner spinner;
    ListView listView;
    List<Employee> employees = null;
    List<Bar> bars = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        findViewsById();
        button.setOnClickListener(this);
    }

    private void findViewsById() {
        button = (Button) findViewById(R.id.button);
        spinner = (Spinner) findViewById(R.id.spinner);
        listView = (ListView) findViewById(R.id.listview);
    }

    public void onClick(View v) {
        try {
            bars = SAXXMLParser.parse(getAssets().open("bars.xml"));
            ArrayAdapter<Bar> adapter = new ArrayAdapter<Bar>(this, R.layout.list_item, bars);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        Bar bar = (Bar) parent.getItemAtPosition(pos);
        Toast.makeText(parent.getContext(), bar.getBarDetails(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }

}
