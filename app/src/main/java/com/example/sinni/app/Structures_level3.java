package com.example.sinni.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

public class Structures_level3 extends AppCompatActivity {
    ImageView onTheLowerStructure
            ,leftRightStructure
            ,onTheNextTwoStructures
            ,onTheNextOneStructures
            ,leftAndRightTwoStructures
            ,leftTwoStructures;
    Intent it;
   String Situation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_structures_level3);
        if(getIntent().getExtras()!=null){
            Bundle bundle3=getIntent().getExtras();
            Situation = bundle3.getString("Situation");
        }
        //浮動button
        floatingButton();

        //第四級
        onTheLowerStructure=(ImageView)findViewById(R.id.onthelowerstructure);
        onTheNextTwoStructures=(ImageView)findViewById(R.id.onthenexttwostructures);
        onTheNextOneStructures=(ImageView)findViewById(R.id.onthenextonestructures);
        leftAndRightTwoStructures=(ImageView)findViewById(R.id.leftandrighttwostructures);
        leftTwoStructures=(ImageView)findViewById(R.id.lefttwostructures);
        leftRightStructure=(ImageView)findViewById(R.id.leftrightstructure);

//上中下結構
        onTheLowerStructure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it=new Intent();
                  it.setClass(Structures_level3.this,OnTheLowerStructure.class);
                startActivity(it);
                finish();
            }
        });
//左中右結構
        leftRightStructure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it=new Intent();
                 it.setClass(Structures_level3.this,LeftRightStructure.class);
                startActivity(it);
                finish();
            }
        });
//上一下二結構
        onTheNextTwoStructures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it=new Intent();
                 it.setClass(Structures_level3.this,OnTheNextTwoStructures.class);
                startActivity(it);
                finish();
            }
        });
//上二下一結構
        onTheNextOneStructures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it=new Intent();
                 it.setClass(Structures_level3.this,OnTheNextOneStructures.class);
                startActivity(it);
                finish();
            }
        });
//左一右二結構
        leftAndRightTwoStructures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it=new Intent();
                  it.setClass(Structures_level3.this,LeftAndRightTwoStructures.class);
                startActivity(it);
                finish();
            }
        });
//左二右一結構
        leftTwoStructures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it=new Intent();
                   it.setClass(Structures_level3.this,LeftTwoStructures.class);
                startActivity(it);
                finish();
            }
        });}

    //浮動button-function
    public void floatingButton(){
        String level2 = getString(R.string.level2);
        String level1 = getString(R.string.level1);

        FloatingActionButton second = new FloatingActionButton(getBaseContext());
        FloatingActionButton first = new FloatingActionButton(getBaseContext());
        //    FloatingActionButton fourth = new FloatingActionButton(getBaseContext());

        //浮動button-第二級
        second.setTitle(level2);
        second.setColorNormalResId(R.color.other_button_color);
        second.setColorDisabled(R.color.white_pressed);
        second.setColorPressedResId(R.color.black_20);
        second.setIcon(R.drawable.number_two);
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"結構",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Structures_level3.this, StructureTeaching.class);
                startActivity(intent);
            }
        });

        //浮動button-第一級
        first.setTitle(level1);
        first.setColorNormalResId(R.color.other_button_color);
        first.setColorDisabled(R.color.white_pressed);
        first.setColorPressedResId(R.color.black_20);
        first.setIcon(R.drawable.number_one);
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"結構",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Structures_level3.this, Structures_level2.class);
                startActivity(intent);
            }
        });
        final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
        menuMultipleActions.addButton(second);
        menuMultipleActions.addButton(first);

        //浮動button-第四級
//        fourth.setTitle("");
//        fourth.setColorNormalResId(R.color.other_button_color);
//        fourth.setColorDisabled(R.color.white_pressed);
//        fourth.setColorPressedResId(R.color.black_20);
//        fourth.setIcon(R.drawable.number_three);
//        fourth.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Toast.makeText(getApplicationContext(),"結構",Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Structures_level2.this, Structure_home_page.class);
//                startActivity(intent);
//            }
//        });
//        menuMultipleActions = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
//        // menuMultipleActions.addButton(my_favorite);
//        menuMultipleActions.addButton(fourth);

    }
}
