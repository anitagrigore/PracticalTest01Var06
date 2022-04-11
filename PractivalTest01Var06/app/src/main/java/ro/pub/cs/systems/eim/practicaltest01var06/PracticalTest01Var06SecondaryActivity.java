package ro.pub.cs.systems.eim.practicaltest01var06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var06SecondaryActivity extends AppCompatActivity {
    Button okButton;
    TextView textView;
    int score = 0;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.okButton) {
                setResult(score, null);
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_secondary);

        textView = findViewById(R.id.textView);
        Intent intent = getIntent();

        if (intent != null && intent.getExtras().containsKey(Constants.TEXT1) &&
                intent.getExtras().containsKey(Constants.TEXT2) &&
                intent.getExtras().containsKey(Constants.TEXT3)) {
            String first = intent.getStringExtra(Constants.TEXT1);
            String second = intent.getStringExtra(Constants.TEXT2);
            String third = intent.getStringExtra(Constants.TEXT3);
            int boxesChecked = intent.getIntExtra(Constants.CHECKED, 0);

            if (first.equals(second) && second.equals(third) ||
                    (first.equals(second) && third.equals("*")) ||
                    (first.equals("*") && second.equals(third)) ||
                    (first.equals(third) && second.equals("*")) ||
                    (first.equals("*") && second.equals("*")) ||
                    (first.equals("*") && third.equals("*")) ||
                    (second.equals("*") && third.equals("*"))||
                    (first.equals("*") && second.equals("*") && third.equals("*"))) {
                if (boxesChecked == 0) {
                    String s = "Gained 100";
                    textView.setText(s);
                    score += 100;
                } else if (boxesChecked == 1) {
                    String s = "Gained 50";
                    textView.setText(s);
                    score += 50;
                } else if (boxesChecked == 2) {
                    String s = "Gained 10";
                    textView.setText(s);
                    score += 10;
                }
            } else {
                String s ="You Lost";
                textView.setText(s);
            }
        }

        okButton = findViewById(R.id.okButton);
        okButton.setOnClickListener(buttonClickListener);
    }
}