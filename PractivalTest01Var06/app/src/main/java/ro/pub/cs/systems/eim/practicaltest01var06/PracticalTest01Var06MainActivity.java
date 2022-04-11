package ro.pub.cs.systems.eim.practicaltest01var06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

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

            switch (view.getId()) {
                case R.id.play:
                    if (!box1.isChecked()) {
                        randomElement1 = numberList.get(rand.nextInt(numberList.size()));
                        if (randomElement1 == 4) {
                            editText1.setText(Constants.STAR);
                        } else {
                            editText1.setText(String.valueOf(randomElement1));
                        }
                    } else {
                        editText1.setText(editText1.getText().toString());
                    }
                    if (!box2.isChecked()) {
                        randomElement2 = numberList.get(rand.nextInt(numberList.size()));
                        if (randomElement2 == 4) {
                            editText2.setText(Constants.STAR);
                        } else {
                            editText2.setText(String.valueOf(randomElement2));
                        }
                    } else {
                        editText2.setText(editText2.getText().toString());
                    }
                    if (!box3.isChecked()) {
                        randomElement3 = numberList.get(rand.nextInt(numberList.size()));
                        if (randomElement3 == 4) {
                            editText3.setText(Constants.STAR);
                        } else {
                            editText3.setText(String.valueOf(randomElement3));
                        }
                    } else {
                        editText3.setText(editText3.getText().toString());
                    }

                    String s = randomElement1 + " " + randomElement2 + " " + randomElement3;
                    Log.d("Numbers: ", s);
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
}