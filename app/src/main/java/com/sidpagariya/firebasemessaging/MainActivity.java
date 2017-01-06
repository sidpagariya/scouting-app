package io.sidpagariya.firebasemessaging;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import java.util.Date;

public class MainActivity extends AppCompatActivity
{
    ImageButton sendButton;
    EditText teamN, teamP;

    DatabaseReference mDB = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendButton = (ImageButton)findViewById(R.id.sendButton);
        teamN = (EditText)findViewById(R.id.teamN);
        teamP = (EditText)findViewById(R.id.teamP);
    }

    @Override
    protected void onStart() {
        super.onStart();
        sendButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Integer i = Integer.parseInt(teamN.getText().toString());
                Double d = Double.parseDouble(teamP.getText().toString());
                Date date = new Date();

                DatabaseReference mTrialRef = mDB.child(i.toString());
                mTrialRef.child(date.toString()).setValue(d);
                teamP.setText("");
            }

        });
    }

    private void hideKeyboard(EditText t)
    {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(t.getWindowToken(), 0);
    }
}