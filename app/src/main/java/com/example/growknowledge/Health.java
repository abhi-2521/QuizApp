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

public class Health extends AppCompatActivity {

    Button button;
    ImageView next;
    RadioGroup radioGroup;
    TextView textView;
    RadioButton R1,R2,R3,R4;
    int flag=0;
    String question[]={"What is the recommended daily intake of water for adults?","Which of the following is not a symptom of a heart attack?"
            ,"What is the most common cause of food poisoning?","Which of the following is not a risk factor for developing type 2 diabetes?",
            "What is the normal range for blood pressure in adults?","Which of the following is not a symptom of depression?",
            "Which of the following is a common symptom of a urinary tract infection (UTI)?","What is the recommended amount of physical activity for adults per week?",
            "What is the most effective way to prevent the spread of germs?","Which of the following is not a symptom of a stroke?",
            "What is the normal resting heart rate for adults?","Which of the following is not a risk factor for developing osteoporosis?",
            "What is the most common sexually transmitted infection (STI) in the United States?","What is the recommended age for a woman to start getting mammograms to screen for breast cancer?",
            "What is the leading cause of death worldwide?","What is the body's largest organ?"};
    String answer[]={"2 liters","Chest pain","Bacteria","Being underweight","120/80 mmHg","Racing heart","Painful urination","60 minutes","All of the above",
    "Sudden chest pain","60-80 beats per minute","Physical activity","Chlamydia","40 years old","Cardiovascular disease","Skin"};
    String options[]={"1 liter","2 liters","3 liters","4 liters","Chest pain", "Shortness of breath", "Nausea or vomiting", "Headache",
    "Bacteria", "Viruses", "Fungi", "Parasites","Age", "Obesity", "Physical inactivity", "Being underweight"," 80/60 mmHg","120/80 mmHg", "140/90 mmHg", "160/100 mmHg",
    "Weight loss", "Insomnia", "Loss of interest in activities", "Racing heart","Constipation", "Headache", "Abdominal pain", "Painful urination",
            "30 minutes","60 minutes", "90 minutes", "120 minutes","Washing your hands", "Covering your mouth when you cough", "Using hand sanitizer", "All of the above",
    "Sudden weakness"," Sudden confusion or trouble speaking", "Sudden vision loss", "Sudden chest pain"," 50-60 beats per minute", "60-80 beats per minute", "80-100 beats per minute", "100-120 beats per minute",
    "Age", "Smoking", "Physical activity", "Gender","Gonorrhea","Chlamydia", "Herpes", "Human papillomavirus (HPV)"," 30 years old", "40 years old", "50 years old", "60 years old",
    "Cancer", "Diabetes", "Cardiovascular disease", "Influenza","Skin","Bone","Leaver","Heart"};
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Health");
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
                        Toast.makeText(Health.this, "Questions are Completed ", Toast.LENGTH_SHORT).show();
                    }
                }catch (StringIndexOutOfBoundsException exception)
                {
                    Toast.makeText(Health.this, "Questions are Completed ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {


                if (radioGroup.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(Health.this, "Please select any option", Toast.LENGTH_SHORT).show();
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