package testapp.example.com.parsertest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.io.IOException;
import java.util.List;

/**
 * Created by Pretty Rehal on 11/02/2017.
 */



public class Employee extends Activity implements AdapterView.OnItemClickListener {

    ListView listView;

    List<Employee> employees = null;

    private String department;
    private String type;
    private String name;
    private int id;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        findViewsById();
        display();
    }

    private void findViewsById() {
        listView = (ListView) findViewById(R.id.listviewEmployee);
    }

    public void display() {
        try {
            employees = SAXXMLParser.parseEmp(getAssets().open("employees.xml"));
            ArrayAdapter<Employee> adapterEmp = new ArrayAdapter<Employee>(this, R.layout.list_item, employees);
            listView.setAdapter(adapterEmp);
            listView.setOnItemClickListener(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return id + ": " + name;
    }

    public String getEmployeeDetails() {
        String result = id + ": " + name + "\n" + department + "-" + type;
        return result;
    }


//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
////on item click listener
//        Intent intent = new Intent(Employee.this, employeeDetail.class);
//        startActivity(intent);
//    }

//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Employee emp = employees.get(position);
        Intent intent = new Intent(Employee.this, employeeDetail.class);
        intent.putExtra("name",emp.getName());
        startActivity(intent);
    }
}
