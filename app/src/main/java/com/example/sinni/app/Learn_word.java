package com.example.sinni.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.io.IOException;
import java.util.Locale;

import static com.example.sinni.app.R.id.listView;

public class Learn_word extends AppCompatActivity implements TextToSpeech.OnInitListener{
    String[] word =new String[] {"明","件","冰"};
    //String[] part =new String[]{"日","月","人","牛","冫","水"};
    String[][] part =new String[][]{{"日","月"},{"イ","牛"},{"冫","水"}};
    String[] spell = {"míng","jiàn","bīng"};
    String Situation,Word_or_Voc,Learn_or_Test;
    int[]  imgIds = new int[]{R.raw.easy_food_gif1,R.raw.easy_food_gif2,R.raw.easy_food_gif3};
    int p=0;
    ImageView back,last,next,showGIF,sound;
    MediaController  mc;
    GifAnimationDrawable gif;
    private TextToSpeech tts;
    ListView mList;
    ArrayAdapter mAdapter;
    VideoView videoView;
    TextView spel;
    String[] mean;
    int w = 0;
    Bundle bundle;
   // Learn_word.Struct[] mItems = buildData(part[w].length);;
    TextView t1;
    int[][] video = new int[][] {{R.raw.easyfoodvideo_sun,R.raw.easyfoodvideo_moon},{R.raw.easyfoodvideo_people,R.raw.easyfoodvideo_cow},{R.raw.easyfoodvideo_ice2,R.raw.easyfoodvideo_water}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_word);
        setTitle("Word");
        //畫面出始化給與各國文字
        findView();

        //浮動button
        floatingButton();
        bundle = getIntent().getExtras();
        Situation = bundle.getString("Situation");

        mList = (ListView) findViewById(listView);
        tts = new TextToSpeech(this, this);
        mc = new MediaController(this);
        /*mAdapter = new ArrayAdapter<Struct>(this,android.R.layout.simple_list_item_2,android.R.id.text1,mItems) {
            @Override
            public View getView(int pos, View convert, ViewGroup group) {
                View v = super.getView(pos, convert, group);
                t1 = (TextView) v.findViewById(android.R.id.text1);
                t1.setText(getItem(pos).iName);
                return v;
            }
        };*/
        //使用ListAdapter來顯示你輸入的文字
        mAdapter = new ArrayAdapter(this , android.R.layout.simple_list_item_checked);
        for(int i=0;i<part[w].length;i++) {
            mAdapter.add(part[w][i]);
        }
        mList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        //設定選擇的模式
        mList.setAdapter(mAdapter);
        //將ListAdapter設定至ListView裡面

        //VideoView畫面
        videoView.setVisibility(View.INVISIBLE);
        setvalue(w);
        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(w<=0){
                //   Toast.makeText(Learn_word.this, "已是第一張" , Toast.LENGTH_SHORT).show();
                }else{
                    w = w -1;
                    setvalue(w);
                    mAdapter.clear();
                    for(int i=0;i<part[w].length;i++) {
                        mAdapter.insert(part[w][i],i);
                    }
                    mList.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();
                    //將ListAdapter設定至ListView裡面
                    videoView.setVisibility(View.INVISIBLE);
                    //videoView.setMediaController(mc);
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(w>=word.length-1){
                  //  Toast.makeText(Learn_word.this, "已是最後一張" , Toast.LENGTH_SHORT).show();
                }else{
                    w = w +1;
                    setvalue(w);
                        mAdapter.clear();
                    for(int i=0;i<part[w].length;i++) {
                        mAdapter.insert(part[w][i],i);
                    }
                    mList.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();
                    //將ListAdapter設定至ListView裡面
                    videoView.setVisibility(View.INVISIBLE);
                    showGIF.setVisibility(View.VISIBLE);
                    //videoView.setMediaController(mc);
                }
            }
        });
        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tts.speak(word[w], TextToSpeech.QUEUE_FLUSH, null);     //發音
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Learn_word.this,word_and_voc .class);
                Bundle bundle1 = new Bundle();
                bundle1.putString("Situation", Situation);
                bundle1.putString("Word_or_Voc", Word_or_Voc);
                intent.putExtras(bundle1);
                startActivity(intent);
            }
        });
        mList.setAdapter(mAdapter);
        mList.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
              //  Toast.makeText(getApplicationContext(), "你選擇" + part[position], Toast.LENGTH_SHORT).show();
                //picture(R.raw.not_thing_video);
                showGIF.setVisibility(View.INVISIBLE);
                videoView.setVisibility(View.VISIBLE);
                //videoView.notify();
                spel.setText("");
                videoView.setMediaController(mc);
                videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + video[w][position]));
                videoView.requestFocus();
                videoView.start();
            }
        });

    }
    public void setvalue(int i) {
        tts.speak(word[i], TextToSpeech.QUEUE_FLUSH, null);     //發音
        spel.setText(spell[i]);
       picture(i);
    }
    public void findView() {
        showGIF = (android.widget.ImageView) findViewById(R.id.imageView);
        spel = (TextView) findViewById(R.id.spell);
        last = (ImageView) findViewById(R.id.last);
        next = (ImageView) findViewById(R.id.next);
        back = (ImageView) findViewById(R.id.back);
        sound = (ImageView) findViewById(R.id.sound);
        videoView = (VideoView) findViewById(R.id.videoView);
        if(getIntent().getExtras()!=null){
            Bundle bundle = this.getIntent().getExtras();
            Situation = bundle.getString("Situation");
            Word_or_Voc = bundle.getString("Word_or_Voc");
            Learn_or_Test = bundle.getString("Learn_or_Test");
        }
    }
    class Struct {
        public String iName;
        Struct(String name) {
            iName = name;
        }
    }

    private Learn_word.Struct[] buildData(int length) {
        Learn_word.Struct[] array = new Learn_word.Struct[length];
        for (int i = 0; i<length; i++) {
            array[i] = new Struct(part[i].toString() );
        }
        return array;
    }

    public void picture(int i){
        showGIF.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {(
                // 點擊一下, 再開始播放一次
                // 以下寫法, 等同 gif2.setVisible(true, true);
                showGIF.getDrawable()).setVisible(true, true);
            }
        });

        try{ // 取得 Gif 動畫檔
            gif = new GifAnimationDrawable( getResources().openRawResource(imgIds[i]) );
            // Gif Drawable 設定給 ImageView
            showGIF.setImageDrawable(gif);
            // 只播放一次
            gif.setOneShot(true);
        }catch( IOException ioe ){

        }
    }

    @Override
    public void onInit(int status) {
        // TODO Auto-generated method stub
        if (status == TextToSpeech.SUCCESS) {
            int result = tts.setLanguage(Locale.TAIWAN);    //設定語言
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                tts.setPitch((float) 1);    //語調(1為正常語調；0.5比正常語調低一倍；2比正常語調高一倍)
                tts.setSpeechRate((float) 0.5);    //速度(1為正常速度；0.5比正常速度慢一倍；2比正常速度快一倍)
            }
        } else {
            Log.e("TTS", "Initilization Failed!");
        }
    }
    @Override
    public void onDestroy() {
        // shutdown tts
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
    }

    //浮動button-function
    public void floatingButton() {
        String test = getString(R.string.test);
        FloatingActionButton Multiple_choice = new FloatingActionButton(getBaseContext());
        FloatingActionButton Learn_word = new FloatingActionButton(getBaseContext());

        //浮動button-我的收藏
        Multiple_choice.setTitle(test);
        Multiple_choice.setColorNormalResId(R.color.other_button_color);
        Multiple_choice.setColorDisabled(R.color.white_pressed);
        Multiple_choice.setColorPressedResId(R.color.black_20);
        Multiple_choice.setIcon(R.drawable.icon_check);
        Multiple_choice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Toast.makeText(getApplicationContext(), "選擇題", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Learn_word.this, StructureExercise.class);
                intent.putExtra("Situation", Situation);
                startActivity(intent);
                finish();
            }
        });


        final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
        menuMultipleActions.addButton(Multiple_choice);

    }
}



