package comp3350.team10.presentation;

import comp3350.team10.R;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentOnCardSelection extends Fragment {
    public FragmentOnCardSelection() {} //Required empty public constructor


    public static FragmentOnCardSelection newInstance() {
        FragmentOnCardSelection fragment = new FragmentOnCardSelection();
        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_on_card_selection, container, false);
    }
}