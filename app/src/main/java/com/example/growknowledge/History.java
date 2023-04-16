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

public class History extends AppCompatActivity {

    Button button;
    ImageView next;
    RadioGroup radioGroup;
    TextView textView;
    RadioButton R1,R2,R3,R4;
    int flag=0;
    String question[]={"What was the real name of Mumtaz Mahal?","Name the only President to have been elected for two consecutive terms? ",
            "The Gandhi - Irwin pact was signed in the year","The name of the first bank established in India was","The first Governor-General of India was?"
    ,"Which of the following movement began in 1942?","Under whose leadership was the all-India Muslim League set up ?","Who among the following rulers had stamped the figure of Goddess Lakshmi on his coins and had his name inscribed in Nagari Characters?",
            "Rajatarangini, a book that generally recorded the heritage of Kashmir in the 12th Century, was written by","In whose time Malik Muhammad Jayasi composed 'Padmavat'?","Where is Humayun's tomb?","  Bibi Ka Maqbara is located in India?","Who among the following Indian rulers was a contemporary of Akbar?"," ._____ is also known as ‘The Light of Asia’.","Pietra Dura, the inlay technique of architecture can be found in which of the following monuments?"
            ,"India's first mission to the moon was launched in which year?"};
    String answer[]={"Arjumand Banu Begum","Rajendra Prasad","1931","Bank of Hindustan","Lord William Bentick","Quit India Movement","Sayyid Ahmed Khan","Muhammad Ghori",
"Kalhana"," Sher Shah","Delhi","Aurangabad","Rani Durgavati","Buddha","Taj Mahal","2008"
    };
    String options[]={"Arjumand Banu Begum","Roshan Ara","Ladli Begum","none of these"," APJ Abdul Kalam"," Pratibha Patil"," Dr Zakir Hussain",
            "Rajendra Prasad","1932","1934","1938","1931","Imperial Bank","Reserve Bank of India","Bank of Hindustan","State Bank of India",
    "Lord William Bentick","Warren Hastings","Lord Canning"," Lord Mountbatten","Non-Cooperation movement", "Khilafat movement", "Quit India Movement", "Home Rule movement",
    "Faisal Khan", "Mohmmed Ali Jinnha", "Sayyid Ahmed Khan", "None of these",") Muhammad Bin Tughlaq","Iltutmish", "Muhammad Ghazni", "Muhammad Ghori",
    "Lalitapida", "Kashyapa","Pravaragupta", "Kalhana"," Akbar", "Shah Jahan", "Aurangzeb", "Sher Shah","Delhi","Agra","Mumbai","None of the above","Delhi",
    "Gujarat","Aurangabad","Rajasthan","Ahilyabai", "Martand Verma" , "Rani Durgavati", "none of these","Rumi", "Buddha", "Gandhi", "Swami Vivekananda",
    "Taj Mahal", "India Gate", "Char Minar", "Gateway of India","2008","2010","2012","2004"};
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("History");
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#5E40E6"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        button=findViewById(R.id.button);
        radioGroup=findViewById(R.id.radiogroup);
        textView=findViewById(R.id.question);
        R1=findViewById(R.id.Option1);
        next=findViewById(R.id.next);
        R2=findViewById(R.id.Option2);
        R3=findViewById(R.id.Option3);
        R4=findViewById(R.id.Option4);
        textView.setText(question[flag]);
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
                }catch (StringIndexOutOfBoundsException exception)
                {
                    Toast.makeText(History.this, "Questions are Completed ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {


                    if (radioGroup.getCheckedRadioButtonId()==-1)
                    {
                        Toast.makeText(History.this, "Please select any option", Toast.LENGTH_SHORT).show();
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