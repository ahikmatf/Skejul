package xyz.fatahillah.skejul.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.fatahillah.skejul.R;
import xyz.fatahillah.skejul.adapterdataholder.SeninAdapter;


public class MondayFragment extends Fragment {

    protected RecyclerView mRecyclerView;
    protected SeninAdapter mAdapter;

    public MondayFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_monday, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_mon);
        mAdapter = new SeninAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);
        //mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

//        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_mon);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        final RecyclerAdapter recyclerAdapter = new RecyclerAdapter(list);
//        mRecyclerView.setAdapter(recyclerAdapter);

        return rootView;
    }

}