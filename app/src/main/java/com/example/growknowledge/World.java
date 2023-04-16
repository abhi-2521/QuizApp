package com.example.growknowledge;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class World extends AppCompatActivity {

    Button button;
    ImageView next;
    RadioGroup radioGroup;
    TextView textView;
    RadioButton R1,R2,R3,R4;
    int flag=0;
    String question[]={"Which is the largest continent in the world?","Which is the smallest country in the world by land area?",
    "Which is the highest mountain in the world?","Which is the longest river in the world?","Which is the most spoken language in the world?",
    "In which country is the Great Barrier Reef located?","Which is the largest ocean in the world?","Which is the currency of Japan?",
    "In which continent is the country of Egypt located?","Which is the largest island in the world?","Which is the coldest continent in the world?",
    "Which is the most populous country in the world?","Which is the most widely spoken official language in the world?",
    "In which country is the city of Marrakesh located?"};
    String options[]={"Africa", "Europe", "Asia", "North America","Vatican City" , "Monaco", "San Marino", "Nauru","Mount Everest", "K2", "Kangchenjunga", "Makalu",
    "Amazon River", "Nile River", "Mississippi River", "Yangtze River","Nile River"," Mandarin Chinese" , "English", "Spanish", "Hindi",
    "Australia", "Brazil", "Canada", "Indonesia"," Atlantic Ocean", "Indian Ocean", "Pacific Ocean", "Southern Ocean","Yen" , "Won", "Dollar", "Euro",
    " Africa", "Asia", "Europe", "South America","Greenland" , "Madagascar", "Borneo", "Iceland","Asia" , "Antarctica", "North America", "Europe",
    "China","India","Pakistan","Bhutan","Hindi","Spanish","Hebrew","English","Morocco",
            "Egypt",
            "Tunisia",
            "Algeria"};
    String answer[]={"Asia","Vatican City","Mount Everest","Nile River","Mandarin Chinese","Australia","Pacific Ocean","Yen","Africa","Greenland",
    "Antarctica","China","English","Morocco"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("World");
        button=findViewById(R.id.button);
        radioGroup=findViewById(R.id.radiogroup);
        textView=findViewById(R.id.question);
        R1=findViewById(R.id.Option1);
        next=findViewById(R.id.next);
        R2=findViewById(R.id.Option2);
        R3=findViewById(R.id.Option3);
        R4=findViewById(R.id.Option4);
        textView.setText(question[flag]);
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#5E40E6"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        R1.setText(options[0]);
        R2.setText(options[1]);
        R3.setText(options[2]);
        R4.setText(options[3]);
        MediaPlayer rightanswer=MediaPlayer.create(getApplicationContext(),R.raw.goodjob);
        MediaPlayer wronganswer=MediaPlayer.create(getApplicationContext(),R.raw.buzzer);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag++;
                radioGroup.clearCheck();
                try {
                    if (flag<question.length)
                    {
                        textView.setText(question[flag]);
                        R1.setText(options[flag*4]);
                        R2.setText(options[flag*4+1]);
                        R3.setText(options[flag*4+2]);
                        R4.setText(options[flag*4+3]);
                    }
                    else {
                        Toast.makeText(World.this, "Questions are Completed ", Toast.LENGTH_SHORT).show();
                    }
                }catch (StringIndexOutOfBoundsException exception)
                {
                    Toast.makeText(World.this, "Questions are Completed ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {


                if (radioGroup.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(World.this, "Please select any option", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton ans=(RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                String ansText=ans.getText().toString();
                if (ansText.equals(answer[flag]))
                {
                    if (wronganswer.isPlaying())
                    {
                        wronganswer.pause();
                    }
                    rightanswer.start();
                    View view=getLayoutInflater().inflate(R.layout.rightanswer,(ViewGroup)findViewById(R.id.rightanswer));
                    Toast toast=new Toast(getApplicationContext());
                    toast.setView(view);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL,-70,500);
                    toast.show();
                }
                else {
                    if (rightanswer.isPlaying())
                    {
                        rightanswer.pause();
                    }
                    wronganswer.start();
                    View view=getLayoutInflater().inflate(R.layout.wronganswer,(ViewGroup)findViewById(R.id.wronganswer));
                    Toast toast=new Toast(getApplicationContext());
                    toast.setView(view);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL,-70,500);
                    toast.show();
                }
            }

        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}