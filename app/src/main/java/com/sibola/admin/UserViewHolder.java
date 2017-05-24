package com.sibola.admin;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Aizen on 23 Mei 2017.
 */

public class UserViewHolder extends RecyclerView.ViewHolder {

    private TextView textUsername;
    private TextView textEmail;

    public UserViewHolder(View itemView) {
        super(itemView);
        this.textUsername = (TextView) itemView.findViewById(R.id.text_username);
        this.textEmail = (TextView) itemView.findViewById(R.id.text_email);
    }

    public void setTextUsername(String text) {
        textUsername.setText(text);
    }

    public void setTextEmail(String text) {
        textEmail.setText(text);
    }
}
