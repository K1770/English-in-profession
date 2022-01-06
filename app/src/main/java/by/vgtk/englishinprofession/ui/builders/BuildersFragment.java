package by.vgtk.englishinprofession.ui.builders;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import by.vgtk.englishinprofession.R;
import by.vgtk.englishinprofession.databinding.FragmentBuildersBinding;

public class BuildersFragment extends Fragment {

    private FragmentBuildersBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentBuildersBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        CardView cardView1 = (CardView) root.findViewById(R.id.builders_card_view1);
        cardView1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), BuildersProfessionsDescriptionActivity.class);
                startActivity(intent);
            }
        });

        CardView cardView2 = (CardView) root.findViewById(R.id.builders_card_view2);
        cardView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), BuildersVocabulary.class);
                startActivity(intent);
            }
        });

        CardView cardView3 = (CardView) root.findViewById(R.id.builders_card_view3);
        cardView3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), BuildersConstructionSiteSafetyRules.class);
                startActivity(intent);
            }
        });

        CardView cardView4 = (CardView) root.findViewById(R.id.builders_card_view4);
        cardView4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), BuildersBooksActivity.class);
                startActivity(intent);
            }
        });

        CardView cardView5 = (CardView) root.findViewById(R.id.builders_card_view5);
        cardView5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), BuildersToolsActivity.class);
                startActivity(intent);
            }
        });

        CardView cardView6 = (CardView) root.findViewById(R.id.builders_card_view6);
        cardView6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), BuildersMaterialsActivity.class);
                startActivity(intent);
            }
        });

        CardView cardView7 = (CardView) root.findViewById(R.id.builders_card_view7);
        cardView7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), BuildersBricksActivity.class);
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
