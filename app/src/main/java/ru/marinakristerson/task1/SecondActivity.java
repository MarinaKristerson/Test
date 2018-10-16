package ru.marinakristerson.task1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    public static String TEXT_KEY = "TEXT_KEY";

    private TextView mUserText;
    private Button mBtn;
    private String searchWord;


    private View.OnClickListener mOnBtnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Uri googlePage = Uri.parse("http://google.com/search?q=" + searchWord);
            Intent startGoogleIntent = new Intent(Intent.ACTION_VIEW, googlePage);
            startActivity(startGoogleIntent);
        }
    };


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mUserText = findViewById(R.id.tv_second_activity);
        mBtn = findViewById(R.id.btn_second_activity);

        Bundle bundle = getIntent().getExtras();
        mUserText.setText(bundle.getString(TEXT_KEY));

        searchWord = bundle.getString(TEXT_KEY);
        mBtn.setOnClickListener(mOnBtnClickListener);
    }
}
