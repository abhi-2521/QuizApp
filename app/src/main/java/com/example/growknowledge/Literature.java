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
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Literature extends AppCompatActivity {

    Button button;
    ImageView next;
    RadioGroup radioGroup;
    TextView textView;
    RadioButton R1,R2,R3,R4;
    String question[]={"Who wrote the novel \"To Kill a Mockingbird\"?","In the play \"Romeo and Juliet\", which family does Romeo belong to?",
            "What is the name of the author who wrote \"The Great Gatsby\"?","Who is the protagonist of the novel \"1984\"?","Who wrote the play \"Hamlet\"?"
            ,"In the novel \"Pride and Prejudice\", what is the name of the protagonist?","Who wrote the novel \"Frankenstein\"?","In the play \"Macbeth\", who is Macbeth's wife?",
            "Who is the author of \"Wuthering Heights\"?","In the novel \"The Catcher in the Rye\", what is the name of the protagonist?",
            "Who is the author of \"The Picture of Dorian Gray\"?","What is the name of the protagonist in the novel \"Jane Eyre\"?","Who is the author of \"The Canterbury Tales\"?"
            ,"What is the name of the protagonist in the novel \"The Adventures of Huckleberry Finn\"?","Who wrote the play \"Othello\"?","In the novel \"Heart of Darkness\", what is the name of the protagonist?"};
    String answer[]={"Harper Lee","Montague","F. Scott Fitzgerald","Winston Smith","William Shakespeare","Elizabeth Bennet","Mary Shelley","Lady Macbeth",
            "Emily Bronte","Holden Caulfield","Oscar Wilde","Jane Eyre","Geoffrey Chaucer","Huckleberry Finn"," William Shakespeare","Marlow",};
    String options[]={"J.K. Rowling", "Harper Lee", "Jane Austen", "Charles Dickens","Montague","Capulet", "Verona", "Escalus","F. Scott Fitzgerald","Ernest Hemingway", "William Faulkner", "John Steinbeck",
    "Winston Smith", "Julia", "Big Brother", "O'Brien","William Shakespeare", "Samuel Beckett", "Oscar Wilde", "Tennessee Williams","Elizabeth Bennet","Jane Bennet", "Mary Bennet", "Lydia Bennet", "Mary Shelley", "Emily Bronte", "Charlotte Bronte", "Anne Bronte",
            "Lady Macbeth", "Queen Mab", "Ophelia", "Cordelia","Emily Bronte", "Charlotte Bronte", "Anne Bronte", "Jane Austen", "Holden Caulfield", "Atticus Finch", "Scout Finch", "Boo Radley"," Oscar Wilde", "Virginia Woolf", "James Joyce", "T.S. Eliot",
        "Jane Eyre", "Elizabeth Bennet", "Marianne Dashwood", "Elinor Dashwood","Geoffrey Chaucer", "William Shakespeare", "Samuel Beckett", "Virginia Woolf",
    "Huckleberry Finn", "Tom Sawyer", "Jim", "Becky Thatcher","William Shakespeare", "Arthur Miller", "Tennessee Williams", "Samuel Beckett","Marlow" , "Kurtz", "The Manager", "The Accountant"};
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_literature);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Literature");
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
                        Toast.makeText(Literature.this, "Questions are Completed ", Toast.LENGTH_SHORT).show();
                    }
                }catch (StringIndexOutOfBoundsException exception)
                {
                    Toast.makeText(Literature.this,exception.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {


                if (radioGroup.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(Literature.this, "Please select any option", Toast.LENGTH_SHORT).show();
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