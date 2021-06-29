package com.example.sozlukuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetayActivity extends AppCompatActivity {
    private TextView textIngilizce, textTurkce;
    private Kelimeler kelime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        textIngilizce = findViewById(R.id.textIngilizce);
        textTurkce = findViewById(R.id.textTurkce);

        kelime= (Kelimeler) getIntent().getSerializableExtra("nesne");
        textIngilizce.setText(kelime.getIngilizce());
        textTurkce.setText(kelime.getTurkce());
    }
}