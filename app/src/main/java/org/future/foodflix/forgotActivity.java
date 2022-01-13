package org.future.foodflix;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;

public class forgotActivity extends BaseActivities{
    @Override
    public int getLayoutId() {
        return R.layout.send_email;
    }

    @Override
    public void useUIElements() {
        ImageView imageView = findViewById(R.id.sendemailbackbtn);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Button send = findViewById(R.id.sendEmailButton);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDestroyed()||isFinishing()){
                    return;
                }

                TextInputEditText user = findViewById(R.id.nameInput);
                String name = user.getText().toString();

                TextInputEditText e_mail = findViewById(R.id.emailInput);
                String mail = e_mail.getText().toString();
                String[] support_mail = {"foodflix@gmail.com"};

                Intent email = new Intent(Intent.ACTION_SEND);
                email.setData(Uri.parse("mailto:"));
                email.setType("text/plain");
                email.putExtra(Intent.EXTRA_EMAIL, support_mail);
                email.putExtra(Intent.EXTRA_SUBJECT, "Foodflix Password Recovery");
                email.putExtra(Intent.EXTRA_TEXT, "My name is " + name + " my email address is " + mail + " and I ate my password!");
                startActivity(Intent.createChooser(email, "Choose an Email client:"));
            }
        });


    }

    @Override
    public void startOperations() {

    }

    @Override
    public void stopOperations() {

    }
}
