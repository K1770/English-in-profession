package by.vgtk.englishinprofession.ui.roaders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import by.vgtk.englishinprofession.R;

public class RodersTestsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_roaders_tests);

        Button btnTest1 = (Button) findViewById(R.id.roaders_btn_tests_1);
        btnTest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "test 1", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnTest2 = (Button) findViewById(R.id.roaders_btn_tests_2);
        btnTest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "test 2", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnTest3 = (Button) findViewById(R.id.roaders_btn_tests_3);
        btnTest3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "test 3", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}