package com.example.homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_search;
    Button btn_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_search = findViewById(R.id.search_et);
        btn_search = findViewById(R.id.search_btn);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchTerms = et_search.getText().toString();
                if (!searchTerms.equals("")){
                    searchNet(searchTerms);
                }

            }
        });

    }
    private void searchNet (String words){
        try {
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY,words);
            startActivity(intent);
        } catch (ActivityNotFoundException e){
            e.printStackTrace();
            searchNetCompat(words);
        }

    }
    private void searchNetCompat (String words){
        try {
            Uri uri = Uri.parse("http://wwwgoogle.com/#q" + words);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } catch (ActivityNotFoundException e){
            e.printStackTrace();
            Toast.makeText(this, "ошибка", Toast.LENGTH_SHORT).show();
        }

    }
}