package proyecto.gestioncobros;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.ButterKnife;

public class SplashScreen extends AppCompatActivity {

    private Context context;

    static final long SPLASH_SCREEN_DELAY= 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);
        setupActivity();
    }

    public void setupActivity(){
        context = this;
        setupTimer();
    }

    public void setupTimer() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent ppal = new Intent(SplashScreen.this, MenuPrincipal.class);
                startActivity(ppal);
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }


}
