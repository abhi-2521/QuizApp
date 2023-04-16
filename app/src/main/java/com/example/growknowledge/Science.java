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

public class Science extends AppCompatActivity {

    Button button;
    ImageView next;
    RadioGroup radioGroup;
    TextView textView;
    RadioButton R1,R2,R3,R4;
    int flag=0;
    String question[]={"Which of the following is the fundamental unit of life?","Which of the following is the smallest unit of matter?"
            ,"What is the formula for water?","Which of the following is the process of converting a solid directly into a gas without passing through the liquid state?",
            "What is the study of heredity called?","Which of the following is the closest planet to the sun?","What is the name of the largest organ in the human body?"
            ,"Which of the following is the largest organ in the human body?","What is the process by which plants release water vapor into the air?",
            "Which of the following is the hardest substance known?","What is the formula for the gas law that describes the relationship between pressure, volume, and temperature of a gas?",
            "What is the name of the process by which living organisms convert food into energy?","What is the name of the pigment that gives leaves their green color and is necessary for photosynthesis?"
            ,"Which of the following is the study of the Earth's physical features, including mountains, oceans, and continents?",
            "What is the name of the process by which plants and some other organisms convert light energy into chemical energy?"};
    String answer[]={"Cell","Atom","H20","Sublimation","Genetics","Mercury","Skin","Skin","Transpiration","Diamond","Charles's Law","Respiration","Chlorophyll",
    "Geology","Photosynthesis"};

    String options[]={"Atom" , "Molecule" , "Cell" , "Tissue","Proton" ,"Electron" , "Neutron" , "Atom","CO2" , "H2SO4" , "H2O" , "NaCl"," Melting" , "Boiling" , "Sublimation" , "Freezing",
    "Genetics" , "Zoology" , "Botany" , "Microbiology","Venus",  "Earth" , "Mars" , "Mercury","Brain" , "Skin" , "Heart" , "Liver"," Brain" , "Skin" ,"Heart" , "Liver",
            "Respiration" , "Photosynthesis" , "Transpiration" , "Absorption","Diamond","Gold","Iron","Copper"," Boyle's Law" , "Charles's Law" , "Gay-Lussac's Law" ,"Avogadro's Law",
            " Metabolism" , "Photosynthesis" , "Digestion" , "Respiration","Chlorophyll" , "Hemoglobin" , "Melanin" , "Carotene","Biology" , "Chemistry" ,
            "Geology" , "Physics"," Photosynthesis" , "Respiration" , "Transpiration" , "Absorption"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Science");
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
                        Toast.makeText(Science.this, "Questions are Completed ", Toast.LENGTH_SHORT).show();
                    }
                }catch (StringIndexOutOfBoundsException exception)
                {
                    Toast.makeText(Science.this, "Questions are Completed ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {


                if (radioGroup.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(Science.this, "Please select any option", Toast.LENGTH_SHORT).show();
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