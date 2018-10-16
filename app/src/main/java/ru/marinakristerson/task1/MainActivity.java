package ru.marinakristerson.task1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mUserText;
    private Button mBtn;

    private boolean isTextEmprty () {
        return !TextUtils.isEmpty(mUserText.getText());
    }

    private View.OnClickListener mOnBtnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (isTextEmprty()) {
                Toast.makeText(MainActivity.this, mUserText.getText(), Toast.LENGTH_LONG).show();

                Intent startSecAcIntent = new Intent(MainActivity.this, SecondActivity.class);
                startSecAcIntent.putExtra(SecondActivity.TEXT_KEY, mUserText.getText().toString());
                startActivity(startSecAcIntent);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserText = findViewById(R.id.etUserText);
        mBtn = findViewById(R.id.btn);

        mBtn.setOnClickListener(mOnBtnClickListener);
    }
}
