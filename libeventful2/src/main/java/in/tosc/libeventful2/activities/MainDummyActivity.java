package in.tosc.libeventful2.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.WindowManager;
import android.widget.ImageView;

import org.json.JSONException;

import java.io.IOException;

import in.tosc.libeventful2.R;
import in.tosc.libeventful2.config.EventfulConfig;

public class MainDummyActivity extends ActionBarActivity {
    Drawable splash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_dummy);

        try {
            EventfulConfig.load(getApplicationContext());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        ImageView splashScreen = (ImageView) findViewById(R.id.splash_screen);
        try {
            splash = Drawable.createFromStream(getAssets().open("splash.png"), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        splashScreen.setImageDrawable(splash);

        startActivity(gotoTopActivity());

    }

    public Intent gotoTopActivity () {
        Intent i;
        switch (EventfulConfig.topNavStyle) {
            case NAVDRAWER:
                i = new Intent(this, TopNavdrawerActivity.class);
                break;
            case SPINNER:
                i = new Intent(this, TopSpinnertabsActivity.class);
                break;
            case SLIDING:
                i = new Intent(this, TopSwipeActivity.class);
                break;
            case SLIDING_TABS:
                i = new Intent(this, TopSwipetabsActivity.class);
                break;
            default:
                i = new Intent(this, TopNavdrawerActivity.class);
                break;
        }
        return i;
    }
}
