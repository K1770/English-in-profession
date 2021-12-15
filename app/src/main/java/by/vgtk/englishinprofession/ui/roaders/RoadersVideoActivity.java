package by.vgtk.englishinprofession.ui.roaders;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import by.vgtk.englishinprofession.PlayerConfig;
import by.vgtk.englishinprofession.R;

public class RoadersVideoActivity extends YouTubeBaseActivity {

    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roaders_video);

        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player_roaders_builders);

        onInitializedListener = new YouTubePlayer.OnInitializedListener(){

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Bundle arguments = getIntent().getExtras();
                String position = arguments.get("linkPosition").toString();

                youTubePlayer.loadVideo(getVideoLink(position));

                youTubePlayer.play();
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        youTubePlayerView.initialize(PlayerConfig.API_KEY,onInitializedListener);
    }

    private String getVideoLink(String position) {
        String link;
        switch (position) {
            case "10":
                link = "d1lZpS7KU10";
                break;
            case "11":
                link = "bHOptfGtxWk";
                break;
            case "12":
                link = "64Xt74RJg1o";
                break;
            default:
                link = "";
                break;
        }
        return link;
    }
}
