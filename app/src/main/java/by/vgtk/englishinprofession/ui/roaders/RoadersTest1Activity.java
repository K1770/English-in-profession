package by.vgtk.englishinprofession.ui.roaders;

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
import by.vgtk.englishinprofession.databinding.FragmentRoadersBinding;

public class RoadersTest1Activity extends AppCompatActivity {

    TextView tv;
    Button submitButton, quitButton;
    RadioGroup radio_g;
    RadioButton rb1, rb2, rb3, rb4;

    String questions[] = {
            "Excavator is used to scrap a thin layer of soil?",
            "Milling machine is used for repair works?",
    };
    String answers[] = {"No", "Yes",};
    String opt[] = {
            "Yes", "No",
            "Yes", "No",
    };

    //flag == index
    int flag = 0;
    public static int correct = 0, wrong = 0;
    int number_of_answers = 2;

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

        rb3.setVisibility(View.INVISIBLE);
        rb4.setVisibility(View.INVISIBLE);

        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
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

                //change text on screen
                if (flag < questions.length) {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag * number_of_answers]);
                    rb2.setText(opt[flag * number_of_answers + 1]);
                } else {
                    rb1.setVisibility(View.INVISIBLE);
                    rb2.setVisibility(View.INVISIBLE);
                    radio_g.setVisibility(View.INVISIBLE);
                    submitButton.setVisibility(View.INVISIBLE);
                    quitButton.setVisibility(View.VISIBLE);
                    tv.setText("Number of questions: " + questions.length + "\nCorrect answer: "
                            + correct + "\n You result: " + (int) 10 / questions.length * correct);
                }
                radio_g.clearCheck();
            }
        });

        quitButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), FragmentRoadersBinding.class);
            startActivity(intent);
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
