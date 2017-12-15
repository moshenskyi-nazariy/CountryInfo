package com.example.nazarii_moshenskyi.hometask;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends BaseActivity {
    private EditText email;
    private EditText subject;
    private EditText body;
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        init();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + email));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject.getText());
                emailIntent.putExtra(Intent.EXTRA_TEXT, body.getText());

                startActivity(Intent.createChooser(emailIntent, "My title"));
            }
        });
    }

    private void init() {
        email = findViewById(R.id.e_mail);
        subject = findViewById(R.id.subject);
        body = findViewById(R.id.body);
        send = findViewById(R.id.btn_send);
    }

}
