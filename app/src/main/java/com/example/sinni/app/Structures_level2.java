package com.example.sinni.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

public class Structures_level2 extends AppCompatActivity {
    ImageView underTheThreePacks
            ,onTheThreeBags
            ,leftLowerPack
            ,topLeftPackage
            ,rightUpperPackage
            ,leftThreePacks
            ,allSurrounded;
    Intent it;
    String Situation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_structures_level2);
        if(getIntent().getExtras()!=null){
            Bundle bundle3=getIntent().getExtras();
            Situation = bundle3.getString("Situation");
        }
        //浮動button
        floatingButton();

        //第三級
        allSurrounded=(ImageView)findViewById(R.id.allsurrounded);
        underTheThreePacks=(ImageView)findViewById(R.id.underthethreepacks);
        onTheThreeBags=(ImageView)findViewById(R.id.onthethreebags);
        leftLowerPack=(ImageView)findViewById(R.id.leftlowerpack);
        topLeftPackage=(ImageView)findViewById(R.id.topleftpackage);
        rightUpperPackage=(ImageView)findViewById(R.id.rightupperpackage);
        leftThreePacks=(ImageView)findViewById(R.id.leftthreepacks);

        //左三包
        leftThreePacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 it=new Intent();
                 it.setClass(Structures_level2.this,LeftThreePacks.class);
                startActivity(it);
                finish();
            }
        });

        //下三包
        underTheThreePacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 it=new Intent();
                it.setClass(Structures_level2.this,UnderTheThreePacks.class);
                startActivity(it);
                finish();
            }
        });

        //上三包
        onTheThreeBags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it=new Intent();
                it.setClass(Structures_level2.this,OnTheThreeBags.class);
                startActivity(it);
                finish();
            }
        });

        //向右上包字判斷
        leftLowerPack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 it=new Intent();
                 it.setClass(Structures_level2.this,LeftLowerPack.class);
                startActivity(it);
                finish();
            }
        });

        //向右下包字判斷
        topLeftPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 it=new Intent();
                  it.setClass(Structures_level2.this,TopLeftPackage.class);
                startActivity(it);
                finish();
            }
        });

        //向左下包字判斷
        rightUpperPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 it=new Intent();
                 it.setClass(Structures_level2.this,RightUpperPackage.class);
                startActivity(it);
                finish();
            }
        });

        //全包圍
        allSurrounded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 it=new Intent();
                   it.setClass(Structures_level2.this,AllSurrounded.class);
                startActivity(it);
                finish();
            }
        });
    }

    //浮動button-function
    public void floatingButton(){
        String level1 = getString(R.string.level1);
        String level3 = getString(R.string.level3);

        FloatingActionButton first = new FloatingActionButton(getBaseContext());
        FloatingActionButton third = new FloatingActionButton(getBaseContext());
    //    FloatingActionButton fourth = new FloatingActionButton(getBaseContext());

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
                Intent intent = new Intent(Structures_level2.this, StructureTeaching.class);
                startActivity(intent);
            }
        });


        //浮動button-第三級
        third.setTitle(level3);
        third.setColorNormalResId(R.color.other_button_color);
        third.setColorDisabled(R.color.white_pressed);
        third.setColorPressedResId(R.color.black_20);
        third.setIcon(R.drawable.number_three);
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"結構",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Structures_level2.this, Structures_level3.class);
                startActivity(intent);
            }
        });
        final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
        menuMultipleActions.addButton(first);
        menuMultipleActions.addButton(third);

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
