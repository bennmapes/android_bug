package test.androidbug;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_update) AppCompatButton updateButton;
    @BindView(R.id.testText) TextView testText;
    @BindView(R.id.input_test) TextInputEditText inputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MainActivity.this);

        updateButton.setOnClickListener(v -> {
            String inputText = inputEditText.getText().toString();
            if(inputText.isEmpty()) {
                inputEditText.setError("Please enter some text to update the text view.");
                return;
            } else {
                inputEditText.setError(null);
            }
            testText.setText(inputText);
        });
    }
}
