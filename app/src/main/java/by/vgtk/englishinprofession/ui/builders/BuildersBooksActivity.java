package by.vgtk.englishinprofession.ui.builders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import by.vgtk.englishinprofession.PDFViewActivity;
import by.vgtk.englishinprofession.R;

public class BuildersBooksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_builders_books);


        Button button1 = (Button) findViewById(R.id.buttonBookEnglishForEngineersBuilders);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), PDFViewActivity.class);
                intent.putExtra("bookLink", "https://drive.google.com/file/d/1S7tJig6yObCbGqkk0NLvNBhcQbezrGD3/view?usp=sharing");
                startActivity(intent);
            }
        });

        Button button2 = (Button) findViewById(R.id.buttonBookReadingRules);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), PDFViewActivity.class);
                intent.putExtra("bookLink", "https://drive.google.com/file/d/1vm_hY8GkPMcg4uOjtmHSYpK57UOypsEF/view?usp=sharing");
                startActivity(intent);
            }
        });

        Button button3 = (Button) findViewById(R.id.buttonBookEnglishInTables);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), PDFViewActivity.class);
                intent.putExtra("bookLink", "https://drive.google.com/file/d/1JC8h3MqCaHxg3Vzx2ASCLVeahe2-hSpr/view?usp=sharing");
                startActivity(intent);
            }
        });

        Button button4 = (Button) findViewById(R.id.buttonBookSafetyTechnique);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), PDFViewActivity.class);
                intent.putExtra("bookLink", "https://docs.google.com/file/d/1bnRlOvUHQOJGBdMWqXUY3uMGOX86ANHd/edit");
                startActivity(intent);
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
