package com.example.sinni.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Word_or_voc extends AppCompatActivity {

    TextView Vocabulary,Word;
    String Situation;
    Bundle bundle;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_or_voc);
        setTitle("Choose");

        intent = new Intent();
        bundle = this.getIntent().getExtras();
        Situation = bundle.getString("Situation");
        bundle = new Bundle();
        Vocabulary = (TextView) findViewById(R.id.Vocabulary);
        Vocabulary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Word_or_voc.this,Learn_or_test.class);
                bundle.putString("Situation", Situation);
                bundle.putString("Word_or_Voc", "Voc");
               // Toast.makeText(getApplicationContext(), "你選擇" +Situation, Toast.LENGTH_SHORT).show();
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        Word = (TextView) findViewById(R.id.Word);
        Word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Word_or_voc.this,Learn_or_test.class);
                bundle.putString("Situation", Situation);
                bundle.putString("Word_or_Voc", "Word");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}