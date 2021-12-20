package by.vgtk.englishinprofession.ui.mechanics;

import static android.text.Html.FROM_HTML_MODE_LEGACY;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import by.vgtk.englishinprofession.R;

public class CarMechanicsActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    TextView[] tw;
    ImageView[] iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_mechanics);

        setMechanicsViews();

        /*TextView tw = findViewById(R.id.textViewEnglishForCarMechanics);
        tw.setText("Hello world");*/
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void setMechanicsViews() {
        linearLayout = (LinearLayout) findViewById(R.id.englishForCarMechanicsActivity);
        linearLayout.setPadding(15, 0, 15, 0);
        String[] mechanicsText = getResources().getStringArray(R.array.carMechanicsMainText);

        tw = new TextView[mechanicsText.length];
        iv = new ImageView[8];

        for (int i = 0; i < tw.length; i++) {
            tw[i] = new TextView(getApplicationContext());
            tw[i].setText(Html.fromHtml(mechanicsText[i], FROM_HTML_MODE_LEGACY));
        }

        for (int i = 0; i < iv.length; i++) {
            iv[i] = new ImageView(getApplicationContext());
            try {
                iv[i].setImageResource(R.drawable.class.getField("mechanics" + String.valueOf(i)).getInt(null));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }

        linearLayout.addView(tw[0]);
        linearLayout.addView(iv[0]);
        linearLayout.addView(tw[1]);
        linearLayout.addView(tw[2]);
        linearLayout.addView(iv[1]);
        linearLayout.addView(tw[3]);
        linearLayout.addView(tw[4]);
        linearLayout.addView(iv[2]);
        linearLayout.addView(tw[5]);
        linearLayout.addView(tw[6]);
        linearLayout.addView(iv[3]);
        linearLayout.addView(tw[7]);
        linearLayout.addView(tw[8]);
        linearLayout.addView(iv[4]);
        linearLayout.addView(tw[9]);
        linearLayout.addView(tw[10]);
        linearLayout.addView(tw[11]);
        linearLayout.addView(iv[5]);
        linearLayout.addView(tw[12]);
        linearLayout.addView(iv[6]);
        linearLayout.addView(tw[13]);
        linearLayout.addView(iv[7]);

        /*tw[0] = new TextView(getApplicationContext());
        tw[0].setText(mechanicsText[0]);
        tw[0].setTextAlignment(TextView.TEXT_ALIGNMENT_INHERIT);
        linearLayout.addView(tw[0]);

        iv[0] = new ImageView(getApplicationContext());
        iv[0].setImageResource(R.drawable.mechanics0);
        linearLayout.addView(iv[0]);

        tw[1] = new TextView(getApplicationContext());
        tw[1].setText(Html.fromHtml(mechanicsText[1], FROM_HTML_MODE_LEGACY));
        tw[1].setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        linearLayout.addView(tw[1]);

        tw[2] = new TextView(getApplicationContext());
        tw[2].setText(mechanicsText[2]);
        tw[2].setTextAlignment(TextView.TEXT_ALIGNMENT_INHERIT);
        linearLayout.addView(tw[2]);

        iv[1] = new ImageView(getApplicationContext());
        iv[1].setImageResource(R.drawable.mechanics0);
        linearLayout.addView(iv[1]);*/

    }
}
