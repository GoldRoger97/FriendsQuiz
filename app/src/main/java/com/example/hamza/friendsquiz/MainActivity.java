package com.example.hamza.friendsquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_QUIZ = 1;
    public static final  String EXTRA_DIFFUCALITY="EXTRAdIFFICULTY";

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";

    private TextView textViewHighscore;

    private int highscore=2;

    private Button start_quiz;
    private Spinner Difficulty_Spiner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Difficulty_Spiner=findViewById(R.id.Difficulty_Spiner);
        String[] Difficulty = Question.getAllDificultyLevels();
        ArrayAdapter<String> adapterDificulty = new ArrayAdapter<String>(this,android
                .R.layout.simple_spinner_dropdown_item,Difficulty);
        adapterDificulty.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Difficulty_Spiner.setAdapter(adapterDificulty);

        start_quiz=findViewById(R.id.start_quizzz);
        textViewHighscore=findViewById(R.id.textViewHighscore);
        loadHighscore();

        start_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StartQuiz();



            }
        });
    }

    private void StartQuiz(){
        String Difficulty = Difficulty_Spiner.getSelectedItem().toString();

        Intent intent = new Intent(MainActivity.this, QuizzActivity.class);
        intent.putExtra(EXTRA_DIFFUCALITY,Difficulty);
        startActivityForResult(intent,REQUEST_CODE_QUIZ);

        Log.i("button  clicked","Button clicked");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_QUIZ) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizzActivity.EXTRA_SCORE, 0);
                if (score > highscore) {
                    updateHighscore(score);
                }
            }
        }
    }

    private void loadHighscore() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE,5);
        textViewHighscore.setText("Highscore: " + highscore);
    }

    private void updateHighscore(int highscoreNew) {
        highscore = highscoreNew;
        textViewHighscore.setText("Highscore: " + highscore);

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highscore);
        editor.apply();
    }
}



