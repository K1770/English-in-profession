package by.vgtk.englishinprofession.ui.builders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import by.vgtk.englishinprofession.PDFViewActivity;
import by.vgtk.englishinprofession.R;

public class BuildersToolsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_builders_tools);


        Button button1 = (Button) findViewById(R.id.buttonToolsExercises);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PDFViewActivity.class);
                intent.putExtra("bookLink", "https://docs.google.com/file/d/15qdBUsp2M2c46DFJEaBKaLQBcdpXvApu/edit?rtpof=true&sd=true");
                startActivity(intent);
            }
        });

        Button button2 = (Button) findViewById(R.id.buttonToolsAndDevices);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PDFViewActivity.class);
                intent.putExtra("bookLink", "https://docs.google.com/file/d/1srqHpWhguSa-UtzycCdqgEPf00kCp0ml/edit");
                startActivity(intent);
            }
        });
    }
}
