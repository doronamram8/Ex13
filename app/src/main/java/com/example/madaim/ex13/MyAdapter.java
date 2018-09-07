package com.example.madaim.ex13;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ResourceCursorAdapter;

/**
 * Created by Madaim on 07/09/2018.
 */

public class MyAdapter extends ResourceCursorAdapter {
    public final static int SORT_BY_NUMS=1;
    public final static int SORT_BY_COLORS=2;
    public final static int SHUFFLE=3;
    DatabaseHelper dbh;
    public MyAdapter(Context context, int layout) {
        super(context, layout,null);
        this.dbh=DatabaseHelper.getInstance(context);
        changeCursor(dbh.getAllItems(SORT_BY_NUMS));
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
