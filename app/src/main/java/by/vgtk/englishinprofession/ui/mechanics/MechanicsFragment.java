package by.vgtk.englishinprofession.ui.mechanics;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import by.vgtk.englishinprofession.R;
import by.vgtk.englishinprofession.databinding.FragmentMechanicsBinding;

public class MechanicsFragment extends Fragment {

    private FragmentMechanicsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentMechanicsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        CardView cardView1 = (CardView) root.findViewById(R.id.car_mechanics_card_view1);
        cardView1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), CarMechanicsActivity.class);
                startActivity(intent);
            }
        });

        CardView cardView2 = (CardView) root.findViewById(R.id.car_mechanics_card_view2);
        cardView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), CarMechanicsAnatomyActivity.class);
                startActivity(intent);
            }
        });

        CardView cardView3 = (CardView) root.findViewById(R.id.car_mechanics_card_view3);
        cardView3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), CarMechanicsEnginesActivity.class);
                startActivity(intent);
            }
        });

        CardView cardView4 = (CardView) root.findViewById(R.id.car_mechanics_card_view4);
        cardView4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), CarMechanicsElectricalSystemActivity.class);
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
