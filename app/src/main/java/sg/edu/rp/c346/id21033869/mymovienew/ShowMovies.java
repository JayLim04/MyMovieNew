
package sg.edu.rp.c346.id21033869.mymovienew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ShowMovies extends AppCompatActivity {

    ListView lvMovies;
    ArrayList<Movies> alMovieList;
    //ArrayAdapter<Movies> aaMovies;
    CustomAdapter caMovies;
    Button btnPg13Movies;
    Movies movies;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_movies);

        btnPg13Movies = findViewById(R.id.btnStarMovies);
        lvMovies = findViewById(R.id.lvMovies);
        alMovieList = new ArrayList<>();
        //aaMovies = new ArrayAdapter<Movies>(this, R.layout.listview, alMoviesList);
        //lvMovies.setAdapter();
        caMovies = new CustomAdapter(this, R.layout.row, alMovieList);
        lvMovies.setAdapter(caMovies);

        DBHelper dbh = new DBHelper(ShowMovies.this);
        alMovieList.clear();
        alMovieList.addAll(dbh.getAllMovies());
        caMovies.notifyDataSetChanged();

        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long identity) {
                Movies movies = alMovieList.get(position);
                Intent i = new Intent(ShowMovies.this, EditActivity.class);
                i.putExtra("movies", movies);
                startActivity(i);
            }
        });

        btnPg13Movies.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                DBHelper dbh = new DBHelper(ShowMovies.this);
                alMovieList.clear();
                alMovieList.addAll(dbh.getPg13Movies());

                caMovies.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        DBHelper dbh = new DBHelper(ShowMovies.this);
        alMovieList.clear();
        alMovieList.addAll(dbh.getAllMovies());
        caMovies.notifyDataSetChanged();
    }
}