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

public class India extends AppCompatActivity {


    Button button;
    ImageView next;
    RadioGroup radioGroup;
    TextView textView;
    RadioButton R1,R2,R3,R4;
    int flag=0;
    String question[]={"What is the capital of India?","Which river is also known as the \"Sorrow of Bengal\"?","Which is the largest state in India in terms of area?",
    "Who was the first Prime Minister of India?","Which is the national animal of India?","In which year did India gain independence from British rule?",
    "Who is known as the \"Father of the Indian Constitution\"?","What is the name of India's first satellite launched in 1975?",
    "Which state in India is the largest producer of tea?","Who is known as the \"Iron Man of India\"?","Which is the largest dam in India?",
    "Which is the highest civilian award in India?","Which state in India has the highest literacy rate?","Who was the first Indian woman to win a Nobel Prize?"};
    String answer[]={"Delhi","Brahmaputra","Rajasthan","Jawaharlal Nehru","Tiger","1947","B.R. Ambedkar","Aryabhata","Assam","Sardar Vallabhbhai Patel",
    "Bhakra Nangal Dam","Bharat Ratna","Kerla",""};
    String options[]={"Delhi","Mumbai","Gujarat","Rajasthan","Ganges", "Brahmaputra", "Yamuna", "Godavari","Delhi","Mumbai","Gujarat","Rajasthan",
    "Indira Gandhi", "Jawaharlal Nehru", "Rajiv Gandhi", "Lal Bahadur Shastri","Tiger","Elephant","Peacock","Lion","1954","1945","1947","1948",
    "Mahatma Gandhi", "B.R. Ambedkar", "Jawaharlal Nehru", "Sardar Patel","Aryabhata" , "Bhaskara", "Rohini", "Chandrayaan","Tamil Nadu","Kerla",
    "Assam","Mumbai","Mahatma Gandhi", "Sardar Vallabhbhai Patel", "Subhash Chandra Bose", "Bhagat Singh","Bhakra Nangal Dam", "Sardar Sarovar Dam", "Tehri Dam", "Nagarjuna Sagar Dam"
    ,"Bharat Ratna", "Padma Vibhushan", "Padma Shri", "Padma Bhushan","Mumbai","Gujarat","Rajasthan","Kerla"," Mother Teresa", "Indira Gandhi", "Sarojini Naidu", "Amartya Sen"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_india);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("India");
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
                        Toast.makeText(India.this, "Questions are Completed ", Toast.LENGTH_SHORT).show();
                    }
                }catch (StringIndexOutOfBoundsException exception)
                {
                    Toast.makeText(India.this, "Questions are Completed ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {


                if (radioGroup.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(India.this, "Please select any option", Toast.LENGTH_SHORT).show();
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