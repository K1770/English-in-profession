package by.vgtk.englishinprofession.ui.computers;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import by.vgtk.englishinprofession.R;
import by.vgtk.englishinprofession.databinding.FragmentComputersBinding;

public class ComputersFragment extends Fragment {

    private FragmentComputersBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentComputersBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        CardView cardView1 = (CardView) root.findViewById(R.id.english_voc_for_computer_card_view1);
        cardView1.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), EnglishVocForComputerActivity.class);
            startActivity(intent);
        });

        CardView cardView2 = (CardView) root.findViewById(R.id.english_voc_for_computer_card_view2);
        cardView2.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), ListViewActivity.class);
            startActivity(intent);
        });

        CardView cardView3 = (CardView) root.findViewById(R.id.english_voc_for_computer_card_view3);
        cardView3.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), ComputersTestActivity.class);
            startActivity(intent);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}