package com.example.magics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class NewNoteActivity extends AppCompatActivity {
    private EditText editTextTitle;
    private EditText editTextDescription;
    private EditText editTextPriority;
    private Button buttonCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        editTextTitle=findViewById(R.id.edit_text_title);
        editTextDescription=findViewById(R.id.edit_text_description);
        editTextPriority=findViewById(R.id.edit_text_priority);
        buttonCreate=findViewById(R.id.button_create);
        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.new_group,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_group:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        }
        private void saveNote() {
        String title=editTextTitle.getText().toString();
        String description=editTextDescription.getText().toString();
        String priority=editTextPriority.getText().toString();
        int intPriority=Integer.parseInt(priority);

        if(title.trim().isEmpty() ||description.trim().isEmpty()||priority.trim().isEmpty()){
            Toast.makeText(this,"Please insert a title and description",Toast.LENGTH_SHORT).show();
            return;
        }
            CollectionReference notebookRef= FirebaseFirestore.getInstance()
                    .collection("Notebook");
        notebookRef.add(new Note(title,description,intPriority));
        Toast.makeText(this,"Note added",Toast.LENGTH_SHORT).show();
        finish();
        }
    }

