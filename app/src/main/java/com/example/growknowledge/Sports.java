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

public class Sports extends AppCompatActivity {

    Button button;
    ImageView next;
    RadioGroup radioGroup;
    TextView textView;
    RadioButton R1,R2,R3,R4;
    int flag=0;
    String question[]={"Which country has won the most FIFA World Cup titles?","Which of the following sports uses a shuttlecock?",
    "Which NBA player is known as \"The King\"?","Which country is hosting the 2022 Winter Olympics?","Who won the Men's Singles title at the 2021 Wimbledon Championships?",
    "Which country won the Men's Football Gold Medal at the 2020 Tokyo Olympics?","Who is the current Formula 1 World Champion?","Which team won the 2021 UEFA Champions League?","" +
            "Which country has won the first t20 world cup?","Which player has won the most number of Grand Slam singles titles in men's tennis?",
    "Which team won the 2021 NBA Championship?","Who won the Men's Singles title at the 2021 French Open?","Which country won the Men's Cricket World Cup in 2019?",
    "Which country won the Men's Rugby World Cup in 2019?"};
    String answer[]={"Brazil","Badminton","LeBron James","China","Novak Djokovic","India","Max Verstappen","Chelsea","Brazil","Novak Djokovic","Milwaukee Bucks",
    "Novak Djokovic","England","South Africa"};
    String options[]={"Brazil", "Germany", "Italy", "Argentina"," Tennis", "Badminton", "Table tennis", "Squash","Kobe Bryant","Michael Jordan", "LeBron James", "Magic Johnson",
    " Canada", "Japan", "South Korea", "China"," Novak Djokovic", "Rafael Nadal", "Roger Federer", "Andy Murray","India", "Pakistan", "Sri Lanka", "West Indies"
    ," Lewis Hamilton", "Max Verstappen", "Sebastian Vettel", "Fernando Alonso","Manchester City" , "Chelsea", "Paris Saint-Germain", "Real Madrid",
    "Brazil", "Germany", "Italy", "Argentina","Roger Federer", "Rafael Nadal", "Novak Djokovic", "Pete Sampras","Milwaukee Bucks" , "Phoenix Suns", "Los Angeles Lakers", "Brooklyn Nets"
    ," Rafael Nadal", "Novak Djokovic", "Stefanos Tsitsipas", "Roger Federer","Australia","India","Sri Lanka","England","India","South Africa","New Zealand","Australia"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Sports");
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
                        Toast.makeText(Sports.this, "Questions are Completed ", Toast.LENGTH_SHORT).show();
                    }
                }catch (StringIndexOutOfBoundsException exception)
                {
                    Toast.makeText(Sports.this, "Questions are Completed ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {


                if (radioGroup.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(Sports.this, "Please select any option", Toast.LENGTH_SHORT).show();
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