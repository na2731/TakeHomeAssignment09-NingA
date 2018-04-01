package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mPreButton;
    private TextView text;
    public ImageView ima;

    public List<question>q;


    public int count = 0;
    public int truecount=0;
    public int falsecount=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialData();

        ima=(ImageView)findViewById(R.id.pic);

        mNextButton=(Button)findViewById(R.id.ne);
        mNextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                count = count + 1;
                textShow(count);
            }
        });

        mPreButton=(Button)findViewById(R.id.Pre);
        mPreButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View d){
                count = count - 1;
                textShow(count);
            }
        });


        mTrueButton=(Button)findViewById(R.id.true1);
        mTrueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                truecount++;
                Judgement(count,falsecount,truecount);

            }
        });
        mFalseButton=(Button)findViewById(R.id.false1);
        mFalseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                falsecount++;
                Judgement(count,falsecount,truecount);

            }
        });
    }
    public void openQuestion(View view){
        Intent i=new Intent(this,QuizApp.class);
        startActivity(i);
    }


    public void textShow(int count){
        text = (TextView)findViewById(R.id.tx);
        if(count<0){
            Toast.makeText(this,"No more questions",Toast.LENGTH_LONG).show();
        }
        if(count == 0){
            text.setText("If a piece of paper was folded 45 times, it would reach to the moon.");
            ima.setImageResource(R.drawable.moon);
        }
        if(count == 1){
            text.setText("It rains diamonds on Saturn and Jupiter.");
            ima.setImageResource(R.drawable.diamonds);
        }
        if(count==2){
            text.setText("Mammoths still walked the Earth when the Great Pyramid was being built.");
            ima.setImageResource(R.drawable.mam);
        }
        if (count==3){
            text.setText("Shaving makes hair grow back faster.");
            ima.setImageResource(R.drawable.shaving);
        }
        if(count>3){
            Toast.makeText(this,"No more questions",Toast.LENGTH_SHORT).show();
        }
    }

    public void Judgement(int count,int falsecount,int truecount){
        if(count==0 &&falsecount>0){
            Toast.makeText(this,"Answer is wrong",Toast.LENGTH_SHORT).show();
        }
        if(count==1 && falsecount>0){
            Toast.makeText(this,"Answer is wrong",Toast.LENGTH_SHORT).show();
        }
        if(count==2 && falsecount>0){
            Toast.makeText(this,"Answer is wrong",Toast.LENGTH_SHORT).show();
        }
        if (count==3&& truecount>0){
            Toast.makeText(this,"Answer is wrong",Toast.LENGTH_SHORT).show();
        }
    }

    public void toast(View view){
        if (count==0 && falsecount>0){
            Toast.makeText(this,"Cheating is wrong",Toast.LENGTH_SHORT).show();
        }
        if(count==1 && falsecount>0){
            Toast.makeText(this,"Cheating is wrong",Toast.LENGTH_SHORT).show();
        }
        if(count==2 && falsecount>0){
            Toast.makeText(this,"Cheating is wrong",Toast.LENGTH_SHORT).show();
        }
        if (count==3&& truecount>0){
            Toast.makeText(this,"Cheating is wrong",Toast.LENGTH_SHORT).show();
        }
    }

    public void initialData(){
        q=new ArrayList<>();
        q.add(new question(R.drawable.moon,"If a piece of paper was folded 45 times, it would reach to the moon.",true));
        q.add(new question(R.drawable.diamonds,"It rains diamonds on Saturn and Jupiter",true));
        q.add(new question(R.drawable.mam,"Mammoths still walked the Earth when the Great Pyramid was being built.",true));
        q.add(new question(R.drawable.shaving,"Shaving makes hair grow back faster.",false));
    }

}
