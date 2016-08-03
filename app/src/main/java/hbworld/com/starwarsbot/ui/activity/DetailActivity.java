package hbworld.com.starwarsbot.ui.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import hbworld.com.starwarsbot.R;
import hbworld.com.starwarsbot.databinding.ActivityDetailBinding;
import hbworld.com.starwarsbot.model.Films;
import hbworld.com.starwarsbot.model.People;
import hbworld.com.starwarsbot.viewModel.DetailViewModel;

public class DetailActivity extends AppCompatActivity {
    private static final String INTENT_PEOPLE = "people";
    private static final String INTENT_FILMS = "films";
    private static final String INTENT_TAG = "tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        Intent intent = getIntent();
        People people = intent.getParcelableExtra(INTENT_PEOPLE);
        Films films = intent.getParcelableExtra(INTENT_FILMS);
        binding.setViewModel(new DetailViewModel(DetailActivity.this, people, films, intent.getBooleanExtra(INTENT_TAG, true)));
    }
}
