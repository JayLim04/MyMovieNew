package sg.edu.rp.c346.id21033869.mymovienew;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle;
    TextView tvGenre;
    TextView tvYear;
    EditText etTitle;
    EditText etGenre;
    EditText etYear;
    Spinner spRating;
    Button btnInsert;
    Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.textViewTitle);
        tvGenre = findViewById(R.id.textViewGenre);
        tvYear = findViewById(R.id.textViewYear);
        etTitle = findViewById(R.id.editTextTitle);
        etGenre = findViewById(R.id.editTextGenre);
        etYear = findViewById(R.id.editTextYear);
        spRating = findViewById(R.id.spinnerRate);
        btnInsert = findViewById(R.id.buttonInsert);
        btnShow = findViewById(R.id.buttonShow);

        Spinner spinner = (Spinner) findViewById(R.id.spinnerRate);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Rating_List, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}