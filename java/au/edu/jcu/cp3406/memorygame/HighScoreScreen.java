package au.edu.jcu.cp3406.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class HighScoreScreen extends AppCompatActivity {

    int currentScore = 1;
    TextView tv_score, tv_speed;
    String speed = "default";
    Button restart_btn;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score_screen);

        prefs = this.getSharedPreferences("preference", Context.MODE_PRIVATE);

        Intent intent = getIntent();
        currentScore = intent.getIntExtra("score", 0);
        speed = intent.getStringExtra("speed");

        tv_score = findViewById(R.id.tv_score);
        tv_speed = findViewById(R.id.speed_test);

        String score_msg = "Your Score: "+ currentScore;
        String speed_msg = "Speed: "+speed;
        tv_score.setText(score_msg);
        tv_speed.setText(speed_msg);

        restart_btn = findViewById(R.id.restart_btn);
        restart_btn.setOnClickListener(v -> restart());
    }

    public void restart() {
        Intent intent = new Intent(HighScoreScreen.this, LandingPage.class);
        intent.putExtra("speed", speed);
        startActivity(intent);
        HighScoreScreen.this.finish();

    }
}