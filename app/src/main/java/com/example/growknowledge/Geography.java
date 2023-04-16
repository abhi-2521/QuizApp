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

public class Geography extends AppCompatActivity {

    Button button;
    ImageView next;
    RadioGroup radioGroup;
    TextView textView;
    RadioButton R1,R2,R3,R4;
    int flag=0;
    String question[]={"Which of the following is the largest country in the world by land area?","Which of the following countries does not have a coastline?"
            ,"Which of the following is the highest mountain in the world?","Which of the following countries is located on two different continents?",
            "Which of the following is the longest river in Africa?","Which of the following is the largest ocean in the world?",
            "Which of the following is the largest desert in the world?","Which of the following is the smallest continent in the world?",
            "Which of the following is the capital city of Brazil?","Which of the following countries is known as the \"Land of the Rising Sun\"?",
            "Which of the following countries is the largest producer of oil in the world?","Which of the following countries is located entirely within another country?"
            ,"Which of the following countries is known as the \"Pearl of Africa\"?","Which of the following countries is the most populous in the world?",
            "Which of the following countries is known as the \"Land of the Thunder Dragon\"?","Which of the following countries is the smallest in the world by land area?"};
    String answer[]={"Russia","Bolivia","Mount Everest","Russia","Nile River","Pacific Ocean","Shara Desert","Australia","Brasília","Japan","Russia","Lesotho",
            "Uganda","China","Bhutan","Vatican City"};


    String options[]={"Russia", "China", "United States", "Canada"," Bolivia", "Uruguay", "Paraguay", "Chile","Mount Kilimanjaro", "Mount Everest", "Mount Aconcagua", "Mount Denali",
            "Egypt","Syria","Russia","Canada",") Niger River", "Congo River", "Nile River", "Zambezi River","Atlantic Ocean","Pacific Ocean","Pacific Ocean"
    ,"Indian Ocean","Gobi Desert", "Arabian Desert", "Sahara Desert", "Kalahari Deser","North America", "South America", "Africa", "Australia",
    "Rio de Janeiro", "Brasília","São Paulo", "Salvador","China", "Japan", "India", "South Korea","India","Russia","China","Iran","San Marino", "Cyprus", "Vatican City", "Lesotho"
            ,"Tanzania", "Kenya", "Uganda", "Rwanda","China", "India", "United States", "Indonesia","Nepal", "Bhutan", "Myanmar", "Sri Lanka"," Monaco","Nauru", "Vatican City", "San Marino"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geography);
        getSupportActionBar().setTitle("Geography");
        button=findViewById(R.id.button);
        radioGroup=findViewById(R.id.radiogroup);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#5E40E6"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
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
                        Toast.makeText(Geography.this, "Questions are Completed ", Toast.LENGTH_SHORT).show();
                    }
                }catch (StringIndexOutOfBoundsException exception)
                {
                    Toast.makeText(Geography.this, "Questions are Completed ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if (radioGroup.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(Geography.this, "Please select any option", Toast.LENGTH_SHORT).show();
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
