package by.vgtk.englishinprofession.ui.mechanics;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import by.vgtk.englishinprofession.R;
import by.vgtk.englishinprofession.databinding.FragmentMechanicsBinding;

public class MechanicsFragment extends Fragment {

    private FragmentMechanicsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentMechanicsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button button = (Button) root.findViewById(R.id.buttonCarMechanics);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), CarMechanicsActivity.class);
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
