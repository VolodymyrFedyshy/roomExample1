package com.ls.room.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ls.room.R;
import com.ls.room.User;
import com.ls.room.RepoDatabase;

/**
 * Created on 03/01/2018.
 */

public class NewUserActivity extends AppCompatActivity {
    private TextView textViewName;
    private TextView textViewEmail;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_user_layout);

        textViewName = (TextView) findViewById(R.id.name_new_user);
        textViewEmail = (TextView) findViewById(R.id.name_new_email);
        buttonSave = (Button) findViewById(R.id.save_new_user);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... params) {
                        User user = new User(textViewName.getText().toString(), textViewEmail.getText().toString(), "123456");
                        RepoDatabase
                                .getInstance(getApplicationContext())
                                .getRepoDao()
                                .insert(user);

                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void result) {
                        super.onPostExecute(result);
                        finish();
                    }
                }.execute();
            }
        });
    }
}
