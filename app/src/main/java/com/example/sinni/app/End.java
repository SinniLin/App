package com.example.sinni.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class End extends AppCompatActivity {
    TextView count,correct,wrong;
    int count1,correct1,wrong1;
    Button re;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        count=(TextView)findViewById(R.id.count);
        correct=(TextView)findViewById(R.id.correct);
        wrong=(TextView)findViewById(R.id.wrong);
        re=(Button)findViewById(R.id.re);
        if(getIntent().getExtras()!=null){
            Bundle bundle3=getIntent().getExtras();
            count1=bundle3.getInt("count");
            correct1 =bundle3.getInt("correct");
            wrong1=bundle3.getInt("wrong");
            count.setText(String.valueOf(count1));
            correct.setText(String.valueOf(correct1));
            wrong.setText(String.valueOf(wrong1));
        }
        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(End.this,StructureCognition.class);
                startActivity(intent);
                finish();
            }
        });
    }
}