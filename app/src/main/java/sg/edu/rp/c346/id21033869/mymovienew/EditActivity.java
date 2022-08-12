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
    Button btnUpdate, btnDelete, btnCancel;
    Movies data;

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
        btnCancel = findViewById(R.id.btnCancel);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                int year = Integer.parseInt(String.valueOf(etYear.getText()));

                data.setGenre(etGenre.getText().toString());
                data.setTitle(etTitle.getText().toString());
                data.setYear(year);

                dbh.updateMovies(data);
                dbh.close();

                btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DBHelper dbh = new DBHelper(EditActivity.this);
                        dbh.deleteMovies(data.getId());
                        finish();
                    }
                });
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
