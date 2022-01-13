package by.vgtk.englishinprofession.ui.roaders;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

import by.vgtk.englishinprofession.PlayerConfig;
import by.vgtk.englishinprofession.R;

public class RoadersVideoActivity extends AppCompatActivity implements YouTubePlayer.OnInitializedListener {

    private static final int RECOVERY_DIALOG_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roaders_video);

        YouTubePlayerFragment youTubePlayerFragment =
                (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youtube_player_fragment_roaders_builders);
        youTubePlayerFragment.initialize(PlayerConfig.API_KEY, this);
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

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        if (!wasRestored) {
            Bundle arguments = getIntent().getExtras();
            String position = arguments.get("linkPosition").toString();
            youTubePlayer.cueVideo(getVideoLink(position));
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
            String errorMessage = String.format("There was an error initializing the YouTubePlayer (%1$s)", youTubeInitializationResult.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
    }
}
