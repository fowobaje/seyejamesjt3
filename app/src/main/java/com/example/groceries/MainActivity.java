package com.example.groceries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    EditText cReceiver, cCompose, cSubject;
    Button buttont, bottons; TextView textView;
    ArrayList<String> selectedItems = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView checkedL= findViewById(R.id.lView);
        final TextView textView = (TextView) findViewById(R.id.textView);
        Button buttont = (Button) findViewById(R.id.btn_total);


        buttont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTotalCost();
            }
        });

        checkedL.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        String[] items={"Pasta", "Cooking oil", "Butter", "Milk", "Egg"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, R.layout.rowlayout, R.id.chk_view, items);
        checkedL.setAdapter(adapter);
        checkedL.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=((TextView)view).getText().toString();
                if (selectedItems.contains(selectedItem)){
                    selectedItems.remove(selectedItem);
                }
                else
                    selectedItems.add(selectedItem);
            }
        });

    }
    public void openTotalCost(){

        Intent intent = new Intent(this, TotalCost.class);
        startActivity(intent);

    }


    public void showSelectedItems(View view){
        String items="";
        for (String item:selectedItems){
            items+="-"+item+"\n";
        }
        Toast.makeText(this, "You have selected \n"+items, Toast.LENGTH_LONG).show();
    }


}
