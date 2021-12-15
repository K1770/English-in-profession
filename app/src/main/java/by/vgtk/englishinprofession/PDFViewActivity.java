package by.vgtk.englishinprofession;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class PDFViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView mWebView=new WebView(PDFViewActivity.this);
        mWebView.getSettings().setJavaScriptEnabled(true);
        //mWebView.getSettings().setPluginsEnabled(true);
        //https://drive.google.com/file/d/1j5qesLJe1TDuej6wCfz12Ds1j8hNEd8Q/view?usp=sharing
        Bundle arguments = getIntent().getExtras();
        mWebView.loadUrl(arguments.get("bookLink").toString());
        //mWebView.loadUrl("https://drive.google.com/file/d/1j5qesLJe1TDuej6wCfz12Ds1j8hNEd8Q/view?usp=sharing");
        setContentView(mWebView);
    }
}
