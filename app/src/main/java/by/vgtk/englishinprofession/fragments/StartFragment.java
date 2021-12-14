package by.vgtk.englishinprofession.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import by.vgtk.englishinprofession.R;
import by.vgtk.englishinprofession.databinding.FragmentStartBinding;

public class StartFragment extends Fragment {


    private FragmentStartBinding binding;

    public StartFragment() {
        super(R.layout.fragment_start);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentStartBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }
}