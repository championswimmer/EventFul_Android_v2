package in.tosc.libeventful2.activities;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.io.IOException;

import in.tosc.libeventful2.R;

public class MainDummyActivity extends ActionBarActivity {
    Drawable splash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
