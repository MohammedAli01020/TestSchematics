package com.example.mohamed.homedbschematics;

import android.database.Cursor;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mohamed.homedbschematics.data.HomeContentProvider;
import com.example.mohamed.homedbschematics.data.HomeContract.PersonEntry;
import com.example.mohamed.homedbschematics.sync.PersonsSyncUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements
        LoaderManager.LoaderCallbacks<Cursor> {

    private static final int LOADER_ID = 104;
    @BindView(R.id.tv_result)
    TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        PersonsSyncUtils.initialize(this);

        getSupportLoaderManager().initLoader(LOADER_ID, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this,
                HomeContentProvider.Persons.CONTENT_URI_PERSONS,
                null,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        updateUi(data);
    }

    private void updateUi(Cursor data) {

        while (data.moveToNext()) {
            mResultTextView.append(data.getString(data.getColumnIndexOrThrow(PersonEntry.COLUMN_NAME)) +
                    "\n\n");
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mResultTextView.setText("");
    }
}
