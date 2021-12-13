package by.vgtk.englishinprofession.ui.home.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import by.vgtk.englishinprofession.R;
import by.vgtk.englishinprofession.databinding.ActivityListViewBinding;
import by.vgtk.englishinprofession.fragments.ComputerPartsFragment;

public class ListViewActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityListViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container_view, ComputerPartsFragment.class, null)
                    .commit();
        }
    }


    /*protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityListViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //setSupportActionBar(binding.appBarMain.toolbar);
        DrawerLayout drawer = binding.drawerLayout;
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_monitor)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
    }*/

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity3, menu);
        return true;
    }

   /*@Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }*/
}