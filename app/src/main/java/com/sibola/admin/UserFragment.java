package com.sibola.admin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class UserFragment extends Fragment {

    private RecyclerView rView;
    private DatabaseReference mDatabase;
    private FirebaseRecyclerAdapter<User, UserViewHolder> mAdapter;

    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("users");

        mAdapter = new FirebaseRecyclerAdapter<User, UserViewHolder>(User.class, R.layout.row_user,
                UserViewHolder.class, mDatabase) {
            @Override
            protected void populateViewHolder(UserViewHolder viewHolder, User model, int position) {
                viewHolder.setTextEmail(model.getEmail());
                viewHolder.setTextUsername(model.getUsername());
                            }
        };

        mAdapter.notifyDataSetChanged();

        rView = (RecyclerView) view.findViewById(R.id.rv_user);
        rView.setHasFixedSize(false);
        rView.setLayoutManager(new LinearLayoutManager(getContext()));
        rView.setItemAnimator(new DefaultItemAnimator());
        // add line decoration
        rView.addItemDecoration(new DividerItemDecorator(getContext()));
        rView.setAdapter(mAdapter);

        return view;
    }

}
