package by.vgtk.englishinprofession.ui.computers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

import java.util.Locale;

import by.vgtk.englishinprofession.PlayerConfig;
import by.vgtk.englishinprofession.R;

public class EnglishVocForComputerActivity extends AppCompatActivity implements YouTubePlayer.OnInitializedListener, View.OnClickListener {

    private static final int RECOVERY_DIALOG_REQUEST = 1;

    private TextToSpeech tts;

    private Button speakButtons[];
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_voc_for_computer);

        YouTubePlayerFragment youTubePlayerFragment =
                (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youtube_player_fragment_english_voc_for_computer);
        youTubePlayerFragment.initialize(PlayerConfig.API_KEY,
                this);

        TextView tw = findViewById(R.id.textViewEvfc);
        tw.setText(formatText());

        linearLayout = (LinearLayout) findViewById(R.id.englishVocForComputerLayout);
        linearLayout.setPadding(0, 0, 0, 60);

        //get words for speech
        Resources res = getResources();
        String[] words = res.getStringArray(R.array.englishVocComputerSpeakStrings);

        //get words for buttons
        Resources buttonTextRes = getResources();
        String[] buttonsText = res.getStringArray(R.array.englishVocComputerButtonStrings);
        speakButtons = new Button[buttonsText.length];

        for (int i = 0; i < speakButtons.length; i++) {
            speakButtons[i] = new Button(getApplicationContext());
            speakButtons[i].setId(i);
            speakButtons[i].setAllCaps(false);
            speakButtons[i].setTextAlignment(TextView.TEXT_ALIGNMENT_TEXT_START);
            speakButtons[i].setTag(words[i]);
            speakButtons[i].setText(buttonsText[i]);
            speakButtons[i].setOnClickListener(this);
            linearLayout.addView(speakButtons[i]);
        }

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {

                    int result = tts.setLanguage(Locale.US);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "This Language is not supported");
                    } else {
                        Log.e("TTS", "Success init");
                    }

                } else {
                    Log.e("TTS", "Initilization Failed!");
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        speakOut(view.getTag().toString());
    }

    public Spanned formatText() {
        Spanned text = Html.fromHtml("<div class=\"tyJCtd mGzaTb baZpAe\"><p dir=\"ltr\" class=\"CDt4Ke zfr3Q\" style=\"margin-left: 0; margin-right: 0; padding-left: 0; text-align: left; text-indent: 0;\"><span style=\"font-family: 'Bitter'; font-size: 11pt; font-style: normal; font-weight: normal; text-decoration: normal; vertical-align: baseline;\">Computers are an essential part of everyone's day-to-day lives and are becoming more important all the time. Can you imagine living without a computer, the Internet or your smart phone for even just one day?</span></p><p dir=\"ltr\" class=\"CDt4Ke zfr3Q\" style=\"margin-left: 0; margin-right: 0; padding-left: 0; text-align: left; text-indent: 0;\"><span style=\"font-family: 'Bitter'; font-size: 11pt; font-style: normal; font-weight: normal; text-decoration: normal; vertical-align: baseline;\">It would be almost impossible! We've put together this list of computer </span><span style=\"font-family: 'Bitter'; font-size: 11pt; font-style: normal; font-weight: normal; text-decoration: underline; vertical-align: baseline;\"><a class=\"XqQF9c\" href=\"https://www.google.com/url?q=https%3A%2F%2Fwww.really-learn-english.com%2Fvocabulary-activities.html&amp;sa=D&amp;sntz=1&amp;usg=AFQjCNHoJpCwxL_WSBAEzMzLUoCQwPhlKA\" target=\"_blank\">vocabulary</a></span><span style=\"font-family: 'Bitter'; font-size: 11pt; font-style: normal; font-weight: normal; text-decoration: normal; vertical-align: baseline;\"> because these days, English language learners have to know how to talk about computers for both their personal and professional lives. People use computers constantly and even more so than for other fields, English is the dominant language for subjects such as computer science, programming and web design.</span></p></div>", Html.FROM_HTML_MODE_LEGACY);
        return text;
    }

    private void speakOut(String text) {
        tts.setSpeechRate(0.8f);
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        if (!wasRestored) {
            youTubePlayer.cueVideo("dUFKdASHB_E");
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