package ro.pub.cs.systems.eim.practicaltest01var06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PracticalTest01Var06MainActivity extends AppCompatActivity {
    EditText editText1, editText2, editText3;
    Button playButton;
    CheckBox box1, box2, box3;

    ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            List<Integer> numberList = Arrays.asList(1, 2, 3, 4);
            Random rand = new Random();
            int randomElement1 = 0, randomElement2 = 0, randomElement3 = 0;
            int boxesChecked = 0;
            String s1 = editText1.getText().toString(), s2 = editText2.getText().toString(), s3 = editText3.getText().toString();
            switch (view.getId()) {
                case R.id.play:
                    if (!box1.isChecked()) {
                        randomElement1 = numberList.get(rand.nextInt(numberList.size()));
                        if (randomElement1 == 4) {
                            s1 = Constants.STAR;
                        } else {
                            s1 = String.valueOf(randomElement1);
                        }
                    }else {
                        boxesChecked++;
                    }
                    editText1.setText(s1);
                    if (!box2.isChecked()) {
                        randomElement2 = numberList.get(rand.nextInt(numberList.size()));
                        if (randomElement2 == 4) {
                            s2 = Constants.STAR;
                        } else {
                            s2 = String.valueOf(randomElement2);
                        }
                    }else {
                        boxesChecked++;
                    }
                    editText2.setText(s2);

                    if (!box3.isChecked()) {
                        randomElement3 = numberList.get(rand.nextInt(numberList.size()));
                        if (randomElement3 == 4) {
                            s3 = Constants.STAR;
                        } else {
                            s3 = String.valueOf(randomElement3);
                        }
                    } else {
                        boxesChecked++;
                    }
                    editText3.setText(s3);

                    String s = randomElement1 + " " + randomElement2 + " " + randomElement3;
                    Log.d("Numbers: ", s);

                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var06SecondaryActivity.class);
                    intent.putExtra(Constants.TEXT1, s1);
                    intent.putExtra(Constants.TEXT2, s2);
                    intent.putExtra(Constants.TEXT3, s3);
                    intent.putExtra(Constants.CHECKED, boxesChecked);
                    startActivityForResult(intent,Constants.SECONDARY_ACTIVITY_REQUEST_CODE);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_main);

        editText1 = findViewById(R.id.text1);
        editText2 = findViewById(R.id.text2);
        editText3 = findViewById(R.id.text3);

        playButton = findViewById(R.id.play);
        playButton.setOnClickListener(buttonClickListener);

        box1 = findViewById(R.id.checkbox1);
        box2 = findViewById(R.id.checkbox2);
        box3 = findViewById(R.id.checkbox3);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == Constants.SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "The score is: " + resultCode, Toast.LENGTH_LONG).show();
        }
    }
}