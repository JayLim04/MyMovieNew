package sg.edu.rp.c346.id21033869.mymovienew;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    TextView tvID;
    EditText etGenre;
    EditText etYear;
    EditText etTitle;
    Spinner rating;
    Button btnUpdate, btnDelete;
    Movie data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        tvID = findViewById(R.id.editTextID);
        etGenre = findViewById(R.id.editTextGenre);
        etTitle = findViewById(R.id.editTextTitle);
        etYear = findViewById(R.id.editTextYear);
        rating = findViewById(R.id.spinnerRate);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                data.setMovieContent(etGenre.getText().toString());
                data.setMovieContent(etTitle.getText().toString());
                data.setMovieContent(etYear.getText().toString());

                dbh.updateMovie(data);
                dbh.close();

                btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DBHelper dbh = new DBHelper(EditActivity.this);
                        dbh.deleteNote(data.getId());
                        finish();
                    }
                });
            }
        });
    }
}