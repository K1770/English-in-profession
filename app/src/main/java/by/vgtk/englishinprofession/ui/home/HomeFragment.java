package by.vgtk.englishinprofession.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import by.vgtk.englishinprofession.R;
import by.vgtk.englishinprofession.databinding.FragmentHomeBinding;
import by.vgtk.englishinprofession.ui.home.activity.EnglishVocForComputerActivity;
import by.vgtk.englishinprofession.ui.home.activity.ListViewActivity;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        CardView cardView = (CardView) root.findViewById(R.id.english_voc_for_computer_card_view1);
        cardView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), EnglishVocForComputerActivity.class);
                startActivity(intent);
            }
        });

        CardView cardView1 = (CardView) root.findViewById(R.id.english_voc_for_computer_card_view2);
        cardView1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), ListViewActivity.class);
                startActivity(intent);
            }
        });

        CardView cardView2 = (CardView) root.findViewById(R.id.english_voc_for_computer_card_view3);
        cardView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), EnglishVocForComputerActivity.class);
                startActivity(intent);
            }
        });

        CardView cardView3 = (CardView) root.findViewById(R.id.english_voc_for_computer_card_view4);
        cardView3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), EnglishVocForComputerActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}