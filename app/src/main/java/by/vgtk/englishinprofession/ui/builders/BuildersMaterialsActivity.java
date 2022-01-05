package by.vgtk.englishinprofession.ui.builders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import by.vgtk.englishinprofession.PDFViewActivity;
import by.vgtk.englishinprofession.R;

public class BuildersMaterialsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_builders_materials);


        Button button1 = (Button) findViewById(R.id.buttonMaterials);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PDFViewActivity.class);
                intent.putExtra("bookLink",
                        "https://docs.google.com/file/d/1YB8JfhEzrFWSbdUB_5FCxKNCTmr7MK49/edit");
                startActivity(intent);
            }
        });

        Button button2 = (Button) findViewById(R.id.buttonModernBuildingMaterials);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PDFViewActivity.class);
                intent.putExtra("bookLink",
                        "https://docs.google.com/file/d/1h36nmUJNnXQ3zvbJOAUcv3spID8wkEjI/edit");
                startActivity(intent);
            }
        });

        Button button3 = (Button) findViewById(R.id.buttonNaturalAndArtificialBuildingMaterials);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PDFViewActivity.class);
                intent.putExtra("bookLink",
                        "https://docs.google.com/file/d/1_FzH_naP45dQKzzfZAnoD6-WWvfc0Zxz/edit");
                startActivity(intent);
            }
        });
    }
}
