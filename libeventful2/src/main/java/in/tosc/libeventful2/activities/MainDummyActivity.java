package in.tosc.libeventful2.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import java.io.IOException;

import in.tosc.libeventful2.R;

public class MainDummyActivity extends ActionBarActivity {
    Drawable splash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(View.SYSTEM_UI_FLAG_FULLSCREEN);
        getWindow().addFlags(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        getWindow().addFlags(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        getWindow().addFlags(View.SYSTEM_UI_FLAG_IMMERSIVE);
        setContentView(R.layout.activity_main_dummy);
        ImageView splashScreen = (ImageView) findViewById(R.id.splash_screen);
        try {
            splash = Drawable.createFromStream(getAssets().open("splash.png"), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        splashScreen.setImageDrawable(splash);
    }
}
