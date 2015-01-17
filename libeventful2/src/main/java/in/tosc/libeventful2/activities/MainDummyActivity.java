package in.tosc.libeventful2.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import org.json.JSONException;

import java.io.IOException;
import java.util.logging.Handler;

import in.tosc.libeventful2.R;
import in.tosc.libeventful2.config.EventfulConfig;

public class MainDummyActivity extends ActionBarActivity {
    public static final String TAG = "MainDummyActivity";
    Drawable splash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_dummy);

        ImageView splashScreen = (ImageView) findViewById(R.id.splash_screen);
        try {
            splash = Drawable.createFromStream(getAssets().open("splash.png"), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        splashScreen.setImageDrawable(splash);
        //TODO: Insert code to provide delay on splash screen

        splashScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(gotoTopActivity());
                finish();

            }
        });

    }

    public Intent gotoTopActivity () {
        Intent i;
        switch (EventfulConfig.topNavStyle) {
            case SPINNER:
                i = new Intent(this, TopSpinnertabsActivity.class);
                break;
            case SLIDING:
                i = new Intent(this, TopSwipeActivity.class);
                break;
            case SLIDING_TABS:
                i = new Intent(this, TopSwipetabsActivity.class);
                break;
            case NAVDRAWER:
            default:
                i = new Intent(this, TopNavdrawerActivity.class);
                break;
        }
        return i;
    }
}
