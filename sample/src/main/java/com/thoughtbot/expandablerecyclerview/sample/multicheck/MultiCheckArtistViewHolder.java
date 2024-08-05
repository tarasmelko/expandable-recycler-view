package com.thoughtbot.expandablerecyclerview.sample.multicheck;

import android.view.View;
import android.widget.Checkable;
import android.widget.CheckedTextView;

import com.thoughtbot.expandablecheckrecyclerview.viewholders.CheckableChildViewHolder;
import com.thoughtbot.expandablerecyclerview.sample.R;

public class MultiCheckArtistViewHolder extends CheckableChildViewHolder {

    private final CheckedTextView childCheckedTextView;

    public MultiCheckArtistViewHolder(View itemView) {
        super(itemView);
        childCheckedTextView = itemView.findViewById(R.id.list_item_multicheck_artist_name);
    }

    @Override
    public Checkable getCheckable() {
        return childCheckedTextView;
    }

    public void setArtistName(String artistName) {
        childCheckedTextView.setText(artistName);
    }
}