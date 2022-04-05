package com.dream.awesome.audiobookone;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText Searchtext;
    private adpter adapter;
    ImageButton bt_mic;
    private List<items> exampleList;
    private List<items> examples;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);
        fillExampleList();
        setUpRecyclerView();
        initToolbar();
//        findViewById(R.id.filter).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent  = new Intent(getApplicationContext(), Country_A.class);
//                startActivity(intent);
//            }
//        });
        this.Searchtext = (EditText) findViewById(R.id.search_input);
        this.Searchtext.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            public void afterTextChanged(Editable editable) {
                MainActivity.this.filterQuery(editable.toString());
            }
        });
    }

    private void fillExampleList() {
        this.exampleList = new ArrayList();
        this.exampleList.add(new items(R.drawable.seasonof, "Season of Migration to the North", "Tayeb Salih"));
        this.exampleList.add(new items(R.drawable.blindness, "Blindness", "José Saramago"));
        this.exampleList.add(new items(R.drawable.hamlet, "Hamlet", "by William Shakespeare"));;
        this.exampleList.add(new items(R.drawable.king, "King Lear", "by William Shakespeare"));
        this.exampleList.add(new items(R.drawable.ww, "Othello", "by William Shakespeare"));
        this.exampleList.add(new items(R.drawable.oedipus, "Oedipus the King", "Sophocles"));
        this.exampleList.add(new items(R.drawable.red, "The Red and the Black", "Stendhal"));
        this.exampleList.add(new items(R.drawable.shandy, "The Life And Opinions of Tristram Shandy", "Laurence Sterne"));
        this.exampleList.add(new items(R.drawable.zeno, "Confessions of Zeno", "Italo Svevo"));
        this.exampleList.add(new items(R.drawable.gul, "Gulliver's Travels", "Jonathan Swift"));
    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);
        LayoutManager layoutManager = new LinearLayoutManager(this);
        this.adapter = new adpter(this.exampleList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(this.adapter);
    }

    private void initToolbar() {
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle((CharSequence) "AudioBookActivity2");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /* access modifiers changed from: private */
    public void filterQuery(String text) {
        ArrayList<items> filterdNames = new ArrayList<>();
        for (items s : this.exampleList) {
            if (s.getText1().toLowerCase().contains(text) || s.getText2().toLowerCase().contains(text)) {
                filterdNames.add(s);
            }
        }
        this.adapter.setFilter(filterdNames);
    }
}