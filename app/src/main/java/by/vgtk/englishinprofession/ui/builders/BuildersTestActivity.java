package by.vgtk.englishinprofession.ui.builders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import by.vgtk.englishinprofession.R;
import by.vgtk.englishinprofession.databinding.FragmentComputersBinding;

public class BuildersTestActivity extends AppCompatActivity {

    TextView tv;
    Button submitButton, quitButton;
    RadioGroup radio_g;
    RadioButton rb1, rb2, rb3, rb4;

    String questions[] = {
            "Select Professions",
            "Select Materials",
            "Select Tools",
            "Select Parts of a building",
            "Select Professions",
            "Select Materials",
            "Select Tools",
            "Select Parts of a building",
    };

    String answers[] = {
            "A carpenter, a plasterer, a brick-layer, a floor-and-wall tiler",
            "A brick, concrete, timber, reinforced concrete, stucco, board",
            "A level, a hammer, a concrete-mixer, a tape-measure, a spade, spatula, bore bit, a bucket, sand",
            "A paper-hanger, a roof, a floor, a wall, a storey",
            "A glazier, a plumber, a construction worker, a joiner, slater-and-tiler",
            "A rock, a brick, a tile, paint, glue, plaster, clay, mortar",
            "A brick trowel, a mallet, a dust mask, a concrete mixer, a wheel barrow, a truck",
            "A foundation, plumbing, heating, framework",
    };

    String opt[][] = {
            {"A brick, concrete, timber, reinforced concrete, stucco, board",
                    "A level, a hammer, a concrete-mixer, a tape-measure, a spade, spatula, bore bit, a bucket, sand",
                    "A paper-hanger, a roof, a floor, a wall, a storey",
                    "A carpenter, a plasterer, a brick-layer, a floor-and-wall tiler"},
            {"A brick, concrete, timber, reinforced concrete, stucco, board",
                    "A level, a hammer, a concrete-mixer, a tape-measure, a spade, spatula, bore bit, a bucket, sand",
                    "A paper-hanger, a roof, a floor, a wall, a storey",
                    "A carpenter, a plasterer, a brick-layer, a floor-and-wall tiler"},
            {"A brick, concrete, timber, reinforced concrete, stucco, board",
                    "A level, a hammer, a concrete-mixer, a tape-measure, a spade, spatula, bore bit, a bucket, sand",
                    "A paper-hanger, a roof, a floor, a wall, a storey",
                    "A carpenter, a plasterer, a brick-layer, a floor-and-wall tiler"},
            {"A brick, concrete, timber, reinforced concrete, stucco, board",
                    "A level, a hammer, a concrete-mixer, a tape-measure, a spade, spatula, bore bit, a bucket, sand",
                    "A paper-hanger, a roof, a floor, a wall, a storey",
                    "A carpenter, a plasterer, a brick-layer, a floor-and-wall tiler"},
            {"A brick trowel, a mallet, a dust mask, a concrete mixer, a wheel barrow, a truck",
                    "A glazier, a plumber, a construction worker, a joiner, slater-and-tiler",
                    "A rock, a brick, a tile, paint, glue, plaster, clay, mortar",
                    "A foundation, plumbing, heating, framework"},
            {"A brick trowel, a mallet, a dust mask, a concrete mixer, a wheel barrow, a truck",
                    "A glazier, a plumber, a construction worker, a joiner, slater-and-tiler",
                    "A rock, a brick, a tile, paint, glue, plaster, clay, mortar",
                    "A foundation, plumbing, heating, framework"},
            {"A brick trowel, a mallet, a dust mask, a concrete mixer, a wheel barrow, a truck",
                    "A glazier, a plumber, a construction worker, a joiner, slater-and-tiler",
                    "A rock, a brick, a tile, paint, glue, plaster, clay, mortar",
                    "A foundation, plumbing, heating, framework"},
            {"A brick trowel, a mallet, a dust mask, a concrete mixer, a wheel barrow, a truck",
                    "A glazier, a plumber, a construction worker, a joiner, slater-and-tiler",
                    "A rock, a brick, a tile, paint, glue, plaster, clay, mortar",
                    "A foundation, plumbing, heating, framework"},

    };

    int question_counter = 0;
    public static int correct = 0, wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        correct = 0;
        wrong = 0;

        TextView textView = (TextView) findViewById(R.id.DispName);

        tv = (TextView) findViewById(R.id.tvque);
        submitButton = (Button) findViewById(R.id.button3);
        quitButton = (Button) findViewById(R.id.buttonquit);

        tv.setText(questions[question_counter]);

        radio_g = (RadioGroup) findViewById(R.id.answersgrp);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb4 = (RadioButton) findViewById(R.id.radioButton4);

        rb1.setText(opt[question_counter][0]);
        rb2.setText(opt[question_counter][1]);
        rb3.setText(opt[question_counter][2]);
        rb4.setText(opt[question_counter][3]);

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
                if (ansText.equals(answers[question_counter])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                question_counter++;

                //change text on screen
                if (question_counter < questions.length) {
                    tv.setText(questions[question_counter]);
                    rb1.setText(opt[question_counter][0]);
                    rb2.setText(opt[question_counter][1]);
                    rb3.setText(opt[question_counter][2]);
                    rb4.setText(opt[question_counter][3]);
                } else {
                    rb1.setVisibility(View.INVISIBLE);
                    rb2.setVisibility(View.INVISIBLE);
                    rb3.setVisibility(View.INVISIBLE);
                    rb4.setVisibility(View.INVISIBLE);
                    radio_g.setVisibility(View.INVISIBLE);
                    submitButton.setVisibility(View.GONE);
                    quitButton.setVisibility(View.VISIBLE);
                    tv.setText("Number of questions: " + questions.length + "\nCorrect answer: "
                            + correct + "\n You result: " + Math.round(10.0 / questions.length * correct));
                }
                radio_g.clearCheck();
            }
        });

        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FragmentComputersBinding.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
