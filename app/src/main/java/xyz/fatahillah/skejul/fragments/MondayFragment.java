package xyz.fatahillah.skejul.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.fatahillah.skejul.R;
import xyz.fatahillah.skejul.adapter.JadwalAdapter;


public class MondayFragment extends Fragment {

    private static final int DATASET_COUNT = 11;
    protected LayoutManagerType mLayoutManagerType;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected String[] mDataset;
    protected JadwalAdapter mAdapter;
    private RecyclerView mRecyclerView;
    public MondayFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //fetch data dari server json
        initDataset();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vMon = inflater.inflate(R.layout.fragment_monday, container, false);

        mRecyclerView = (RecyclerView) vMon.findViewById(R.id.rv_mon);
        mLayoutManager = new LinearLayoutManager(getActivity());

        mLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        mAdapter = new JadwalAdapter(mDataset);
        mRecyclerView.setAdapter(mAdapter);

        return vMon;
    }

    private void initDataset() {
        mDataset = new String[DATASET_COUNT];
        for (int i = 0; i < DATASET_COUNT; i++) {
            mDataset[i] = "This is element #" + i;
        }
    }

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }
}
