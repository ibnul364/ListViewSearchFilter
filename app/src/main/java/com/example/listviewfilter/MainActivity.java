package com.example.listviewfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    EditText editTextFilter;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listId);
        editTextFilter = findViewById(R.id.searchFilter);

        ArrayList<String> names = new ArrayList<>();
        names.add("JHON");
        names.add("STEVE");
        names.add("GREON");
        names.add("JHUAN");
        names.add("JIPPO");
        names.add("MUSCLE");

        adapter  = new ArrayAdapter(this,R.layout.list_item_layout,names);
        listView.setAdapter(adapter);

        //SearchFilter

        editTextFilter.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                (MainActivity.this).adapter.getFilter().filter(charSequence);


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });





    }
}