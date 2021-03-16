package edu.temple.imageactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ImageView imageview;
    Button button;
    //Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setTitle("item selection");
        ArrayList<String> catarray = new ArrayList<>(Arrays.asList("sushi", "tofu", "dragonroll",
                "sushi2", "tofu2", "dragonroll2"));
        ArrayList<Integer> catimagearray = new ArrayList<>(Arrays.asList(
                R.drawable.cat1, R.drawable.cat2, R.drawable.cat3, R.drawable.cat1,
                R.drawable.cat2, R.drawable.cat3
        ));
        //String[] catarray = new String[]{"sushi", "tofu", "dragonroll"};
        //int[] catimagearray = new int[]{R.drawable.cat1, R.drawable.cat2, R.drawable.cat3};
        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, catarray);

        ImageAdapter adapter = new ImageAdapter(this,
                getResources().getStringArray(R.array.catarrayname),
                catimagearray);

        //imageview = findViewById(R.id.imageView);
        //spinner = findViewById(R.id.spinner);
        //spinner.setAdapter(adapter);

        GridView gridview = findViewById(R.id.gridview);
        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //sendcat(catarray.get(position), catimagearray.get(position));
                sendcat(getResources().getStringArray(R.array.catarrayname)[position],
                        catimagearray.get(position));

            }
        });

    }

    public void sendcat(String name, Integer position){
        Intent intent = new Intent(this, catdisplayactivity.class);
        intent.putExtra("catname", name);
        intent.putExtra("catimageposition", position);
        startActivity(intent);
    }
}