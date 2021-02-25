package edu.temple.imageactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    ImageView imageview;
    Button button;
    Spinner spinner;

    boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> catarray = new ArrayList<>(Arrays.asList("sushi","tofu","dragonroll"));
        ArrayList<Integer> catimagearray = new ArrayList<Integer>(Arrays.asList(
                R.drawable.cat1, R.drawable.cat2, R.drawable.cat3
                ));
        //String[] catarray = new String[]{"sushi", "tofu", "dragonroll"};
        //int[] catimagearray = new int[]{R.drawable.cat1, R.drawable.cat2, R.drawable.cat3};
        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, catarray);

        ImageAdapter adapter = new ImageAdapter(this, catarray, catimagearray);

        imageview = findViewById(R.id.imageView);
        button = findViewById(R.id.button);
        spinner = findViewById(R.id.spinner);
        spinner.setAdapter(adapter);


        flag = true;
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(flag){
                    //hello there
                    flag = false; //initial launch, no image display
                }else{
                    imageview.setImageResource(catimagearray.get(position));
                    Toast.makeText(MainActivity.this, "item selected", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "item unselected", Toast.LENGTH_SHORT).show();
            }
        });

        button.setOnClickListener(v -> {
            imageview.setImageResource(0); //remove image
        });
    }
}