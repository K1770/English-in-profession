package by.vgtk.englishinprofession.ui.builders;

import static android.os.SystemClock.sleep;

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

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

import java.util.Locale;

import by.vgtk.englishinprofession.PlayerConfig;
import by.vgtk.englishinprofession.R;

public class BuildersVocabulary extends AppCompatActivity implements View.OnClickListener {

    private TextToSpeech tts;

    private Button speakButtons[];
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buildrers_vocabulary);

        linearLayout=(LinearLayout)findViewById(R.id.buildersVocabularyActivity);

        Resources res = getResources();
        String[] words = res.getStringArray(R.array.buildersVocabularySpeakingStrings);

        Resources buttonTextRes = getResources();
        String[] buttonsText = res.getStringArray(R.array.buildersVocabularyStrings);
        speakButtons = new Button[buttonsText.length];

        for(int i=0; i<speakButtons.length; i++) {
            speakButtons[i]=new Button(getApplicationContext());
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
    public void onClick(View view)
    {
        speakOut(view.getTag().toString());
    }

    private void speakOut(String text) {
        String speakArray[] = text.split(";");
        tts.setSpeechRate(0.8f);
        for(String str: speakArray) {
            tts.speak(str, TextToSpeech.QUEUE_FLUSH, null);
            sleep(1000);
        }
    }

}