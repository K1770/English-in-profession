package by.vgtk.englishinprofession.ui.roaders;

import android.content.Intent;
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
        btnTest1.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), RoadersTest1Activity.class);
            startActivity(intent);
        });

        Button btnTest2 = (Button) findViewById(R.id.roaders_btn_tests_2);
        btnTest2.setOnClickListener(view -> {
//            Toast.makeText(getApplicationContext(), "Здесь будет второй тест", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), RoadersTest2Activity.class);
            startActivity(intent);
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}