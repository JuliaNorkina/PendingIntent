package com.example.pandingintent;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int REQUEST_CODE = 1;
    public static final int FINISH_CODE = 2;
    public static final String NUMBER = "number";
    public static final String PINTENT = "pintent";
    public static final String PARAM_RESULT = "result";
    private EditText etNumber;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber = findViewById(R.id.etNumber);
        tvResult = findViewById(R.id.tvResult);
        findViewById(R.id.bCalculate).setOnClickListener(this);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == FINISH_CODE) {
            int result = data.getIntExtra(PARAM_RESULT, 0);
            tvResult.setText(String.valueOf(result));
        }
    }

    @Override
    public void onClick(View v) {
        PendingIntent pendingIntent = createPendingResult(REQUEST_CODE, new Intent(), 0);
        Intent intent = new Intent(this, CalculateFactorialService.class).
                putExtra(NUMBER, etNumber.getText().toString()).putExtra(PINTENT, pendingIntent);
        startService(intent);
    }
}
