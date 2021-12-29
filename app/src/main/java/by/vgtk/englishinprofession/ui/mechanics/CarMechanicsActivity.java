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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_mechanics);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
