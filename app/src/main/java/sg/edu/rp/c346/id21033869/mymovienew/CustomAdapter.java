package sg.edu.rp.c346.id21033869.mymovienew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Movies> moviesArrayList;

    public CustomAdapter(Context context, int resource, ArrayList<Movies> objects){
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        moviesArrayList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvTitle = rowView.findViewById(R.id.tvTitle);
        TextView tvGenre = rowView.findViewById(R.id.tvGenre);
        TextView tvYear = rowView.findViewById(R.id.tvYear);
        ImageView ivRating = rowView.findViewById(R.id.ivRating);

        Movies currentMovie = moviesArrayList.get(position);
        tvTitle.setText(currentMovie.getTitle());
        tvGenre.setText(currentMovie.getGenre());
        tvYear.setText(currentMovie.getYear());

        if (currentMovie.getRating() == "G") {
            ivRating.setImageResource(R.drawable.rating_g);
        } else if (currentMovie.getRating() == "PG") {
            ivRating.setImageResource(R.drawable.rating_pg);
        } else if (currentMovie.getRating() == "PG13") {
            ivRating.setImageResource(R.drawable.rating_pg13);
        } else if (currentMovie.getRating() == "NC16") {
            ivRating.setImageResource(R.drawable.rating_nc16);
        } else if (currentMovie.getRating() == "M18") {
            ivRating.setImageResource(R.drawable.rating_m18);
        } else {
            ivRating.setImageResource(R.drawable.rating_r21);
        }

        return rowView;
    }
}

