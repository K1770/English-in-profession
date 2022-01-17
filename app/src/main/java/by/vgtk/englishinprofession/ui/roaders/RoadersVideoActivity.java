package by.vgtk.englishinprofession.ui.roaders;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import by.vgtk.englishinprofession.R;

public class RoadersVideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roaders_video);

        YouTubePlayerView youTubePlayerView1 = findViewById(R.id.youtube_player_view_1);
        getLifecycle().addObserver(youTubePlayerView1);

        YouTubePlayerView youTubePlayerView2 = findViewById(R.id.youtube_player_view_2);
        getLifecycle().addObserver(youTubePlayerView2);

        YouTubePlayerView youTubePlayerView3 = findViewById(R.id.youtube_player_view_3);
        getLifecycle().addObserver(youTubePlayerView3);

    }

}
