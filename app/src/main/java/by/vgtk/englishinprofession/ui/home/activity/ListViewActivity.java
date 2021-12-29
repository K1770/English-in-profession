package by.vgtk.englishinprofession.ui.home.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import by.vgtk.englishinprofession.R;
import by.vgtk.englishinprofession.databinding.ActivityListViewBinding;
import by.vgtk.englishinprofession.fragments.ComputerPartsFragment;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}