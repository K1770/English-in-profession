package by.vgtk.englishinprofession.ui.roaders;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import by.vgtk.englishinprofession.PDFViewActivity;
import by.vgtk.englishinprofession.R;
import by.vgtk.englishinprofession.databinding.FragmentRoadersBinding;

public class RoadersFragment extends Fragment {

    private FragmentRoadersBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentRoadersBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        CardView cardViewBook = (CardView) root.findViewById(R.id.roaders_card_view1);
        cardViewBook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PDFViewActivity.class);
                intent.putExtra("bookLink", "https://drive.google.com/file/d/1j5qesLJe1TDuej6wCfz12Ds1j8hNEd8Q/view?usp=sharing");
                startActivity(intent);
            }
        });

        CardView cardViewTests = (CardView) root.findViewById(R.id.roaders_card_view2);
        cardViewTests.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RodersTestsActivity.class);
                startActivity(intent);
            }
        });

        CardView cardViewVideo = (CardView) root.findViewById(R.id.roaders_card_view3);
        cardViewVideo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RoadersVideoActivity.class);
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
