package edu.temple.imageactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

public class catdisplayactivity extends AppCompatActivity {

    TextView textview;
    ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        String catname = getIntent().getStringExtra("catname");
        int catimageposition = getIntent().getIntExtra("catimageposition", 0);

        textview = findViewById(R.id.textview);
        imageview = findViewById(R.id.imageview);

        textview.setText(catname);
        textview.setGravity(Gravity.CENTER_HORIZONTAL);
        textview.setTextSize(40);
        imageview.setImageResource(catimageposition);
    }
}