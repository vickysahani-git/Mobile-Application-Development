package com.example.p15;

import android.annotation.SuppressLint;
import android.content.*;
import android.view.*;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.*;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    List<String> titles;
    Context context;

    public NotesAdapter(Context context, List<String> titles) {
        this.context = context;
        this.titles = titles;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        public ViewHolder(View view) {
            super(view);
            text = view.findViewById(android.R.id.text1);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.text.setText(titles.get(position));

        holder.itemView.setOnLongClickListener(v -> {
            // Delete
            context.getContentResolver().delete(
                    NotesProvider.CONTENT_URI,
                    "title=?",
                    new String[]{titles.get(position)}
            );
            titles.remove(position);
            notifyDataSetChanged();
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }
}