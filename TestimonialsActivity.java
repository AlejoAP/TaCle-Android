package com.example.hp.tacle;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.hp.tacle.dao.SQLiteHelper;
import com.example.hp.tacle.model.Commentaire;

import org.w3c.dom.Text;

import java.util.List;

public class TestimonialsActivity extends AppCompatActivity {
    private SQLiteDatabase mDatabase;
    private CommentaireAptater mAdapter;
    private EditText mEditTextName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testimonials);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SQLiteHelper dbHelper = new SQLiteHelper(this);
        mDatabase = dbHelper.getWritableDatabase();

        RecyclerView recyclerView = findViewById(R.id.listView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new CommentaireAptater(this, getAllItems());
        recyclerView.setAdapter(mAdapter);

        mEditTextName = findViewById(R.id.edittext_name);


        Button buttonAdd = findViewById(R.id.button_add);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });

    }
    private void addItem() {

        if (mEditTextName.getText().toString().trim().length() == 0 ) {
            return;
        }

        String name = mEditTextName.getText().toString();
        ContentValues cv = new ContentValues();
        cv.put(SQLiteHelper.COL2, "ITEM1");


        mDatabase.insert(SQLiteHelper.TABLE_NAME2, null, cv);
        mAdapter.swapCursor(getAllItems());

        mEditTextName.getText().clear();
    }

    private Cursor getAllItems() {
        return mDatabase.query(
                SQLiteHelper.TABLE_NAME2,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }
}
