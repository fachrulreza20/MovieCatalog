package com.example.mymoviecatalog.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mymoviecatalog.Class.TVShow;
import com.example.mymoviecatalog.R;

public class TVShowDetailActivity extends AppCompatActivity {

    TextView name, desc, runtime, releaseDate;
    ImageView myImageView;
    private ProgressBar progressBar;

    public static final String EXTRA_TVSHOW = "extra movie";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvshow_detail);

        name = findViewById(R.id.tvName_tvshow);
        desc = findViewById(R.id.tvDesc_tvshow);
        runtime = findViewById(R.id.tvPopularity_tvshow);
        releaseDate = findViewById(R.id.tvReleaseDate_tvshow);
        myImageView = findViewById(R.id.imgVIew_tvshow);
        progressBar = findViewById(R.id.progressBar);

        showLoading(true);

        TVShow tvshow = getIntent().getParcelableExtra(EXTRA_TVSHOW);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.appbartitle_tvshow);
        }

        name.setText((tvshow.getName_tvshow().toUpperCase()));
        desc.setText(tvshow.getDescription_tvshow());
        runtime.setText(getString(R.string.text_runtime, tvshow.getPopularity_tvshow()));
        releaseDate.setText(getString(R.string.text_releasedate, tvshow.getReleasedate_tvshow()));

        Glide.with(this)
                .load(tvshow.getPhoto_tvshow())
                .apply(new RequestOptions().override(600,600))
                .into(myImageView);



        showLoading(false);

    }

    private void showLoading(Boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

}
