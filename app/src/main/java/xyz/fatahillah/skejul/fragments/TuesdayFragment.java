package xyz.fatahillah.skejul.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.fatahillah.skejul.R;
import xyz.fatahillah.skejul.adapterdataholder.SelasaAdapter;


public class TuesdayFragment extends Fragment {
    protected RecyclerView mRecyclerView;
    protected SelasaAdapter mAdapter;

    public TuesdayFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tuesday, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_tue);
        mAdapter = new SelasaAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);
        //mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return rootView;
    }

}
