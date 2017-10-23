package com.example.lucascarvalho.appadocao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimalView extends AppCompatActivity {

    String passedVar = null;
    String passedDesc;

    private TextView passedView =null;
    TextView passedViewDesc = null;
    ImageView passedImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_view);

        passedVar=getIntent().getStringExtra(AnimalList.t);
        passedDesc=getIntent().getStringExtra(AnimalList.f);

        passedView=(TextView)findViewById(R.id.edtName);
        passedView.setText("Clicou no ITEM id=" +passedVar);
        passedViewDesc=(TextView)findViewById(R.id.edtDescricao);
        passedViewDesc.setText(passedDesc);


    }
}
