package com.example.hp.tacle;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.hp.tacle.dao.SQLiteHelper;
import com.example.hp.tacle.model.Commentaire;

import java.util.List;

public class CommentaireAptater extends RecyclerView.Adapter<CommentaireAptater.CommentaireViewHolder> {
    private Context mContext;
    private Cursor mCursor;

    public CommentaireAptater(Context context, Cursor cursor) {
        mContext = context;
        mCursor = cursor;
    }

    public class CommentaireViewHolder extends RecyclerView.ViewHolder {
        public TextView nameText;
        public TextView countText;

        public CommentaireViewHolder(View itemView) {
            super(itemView);

            nameText = itemView.findViewById(R.id.textview_name_item);

        }
    }

    @Override
    public CommentaireViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.model_commentaire, parent, false);
        return new CommentaireViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommentaireViewHolder holder, int position) {
        if (!mCursor.moveToPosition(position)) {
            return;
        }

        String name = mCursor.getString(mCursor.getColumnIndex(SQLiteHelper.COL2));

        holder.nameText.setText(name);

    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }


    public void swapCursor(Cursor newCursor) {
        if (mCursor != null) {
            mCursor.close();
        }

        mCursor = newCursor;

        if (newCursor != null) {
            notifyDataSetChanged();
        }
    }
}

