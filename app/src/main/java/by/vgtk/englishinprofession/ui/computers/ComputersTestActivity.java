package by.vgtk.englishinprofession.ui.computers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import by.vgtk.englishinprofession.MainActivity3;
import by.vgtk.englishinprofession.R;

public class ComputersTestActivity extends AppCompatActivity {

    TextView tv;
    Button submitButton, quitButton;
    RadioGroup radio_g;
    RadioButton rb1, rb2, rb3, rb4;

    String questions[] = {
            "Which method can be defined only once in a program?",
            "Which of these is not a bitwise operator?",
            "Which keyword is used by method to refer to the object that invoked it?",
            "Which of these keywords is used to define interfaces in Java?",
            "Which of these access specifiers can be used for an interface?",
    };
    String answers[] = {"main method", "<=", "this", "interface", "public"};
    String opt[] = {
            "finalize method", "main method", "static method", "private method",
            "&", "&=", "|=", "<=",
            "import", "this", "catch", "abstract",
            "Interface", "interface", "intf", "Intf",
            "public", "protected", "private", "All of the mentioned",
    };
    //flag == index
    int flag = 0;
    public static int correct = 0, wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computers_test);
        correct = 0;
        wrong = 0;

        TextView textView = (TextView) findViewById(R.id.DispName);

        tv = (TextView) findViewById(R.id.tvque);
        submitButton = (Button) findViewById(R.id.button3);
        quitButton = (Button) findViewById(R.id.buttonquit);

        tv.setText(questions[flag]);

        radio_g = (RadioGroup) findViewById(R.id.answersgrp);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb4 = (RadioButton) findViewById(R.id.radioButton4);

        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if (radio_g.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if (ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (flag < questions.length) {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag * 4]);
                    rb2.setText(opt[flag * 4 + 1]);
                    rb3.setText(opt[flag * 4 + 2]);
                    rb4.setText(opt[flag * 4 + 3]);
                } else {
                    rb1.setVisibility(View.INVISIBLE);
                    rb2.setVisibility(View.INVISIBLE);
                    rb3.setVisibility(View.INVISIBLE);
                    rb4.setVisibility(View.INVISIBLE);
                    radio_g.setVisibility(View.INVISIBLE);
                    submitButton.setVisibility(View.INVISIBLE);
                    quitButton.setVisibility(View.VISIBLE);
                    tv.setText("Number of questions: " + questions.length + "\nCorrect answer: " + correct + "\n You result: " + (int) 10 / questions.length * correct);
                }
                radio_g.clearCheck();
            }
        });

        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
