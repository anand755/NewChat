package com.example.defcon.chotusachat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class MainActivity extends AppCompatActivity {
    private ListView lvMessage;
    private EditText etMessage;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMessage = (ListView) findViewById(R.id.lv_messages);
        etMessage = (EditText) findViewById(R.id.et_message);
        btnSend = (Button) findViewById(R.id.btn_send);

        Firebase.setAndroidContext(this);

        final Firebase ref = new Firebase("https://chotusachat.firebaseio.com/");

        /*ref.authWithPassword("anandjha.755@gmail.com", "DefconOrNothing", new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                System.out.println("User Id : " + authData.getUid() + " , Provider : " + authData.getProvider());
            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                System.out.println("There was an error");
            }
        });*/

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChatMessageModel chatMessageModel = new ChatMessageModel("AbC", etMessage.getText().toString());
                ref.push().setValue(chatMessageModel);
                etMessage.setText("");
            }
        });
    }

}
