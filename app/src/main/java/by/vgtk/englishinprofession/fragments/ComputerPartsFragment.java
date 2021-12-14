package by.vgtk.englishinprofession.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import by.vgtk.englishinprofession.R;
import by.vgtk.englishinprofession.databinding.FragmentComputerPartsBinding;

public class ComputerPartsFragment extends Fragment {

    private FragmentComputerPartsBinding binding;

    public ComputerPartsFragment(){
        super(R.layout.fragment_computer_parts);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentComputerPartsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Bundle arguments = getActivity().getIntent().getExtras();
        String position = arguments.get("position").toString();

        TextView textView = (TextView)getView().findViewById(R.id.computerTextView);
        ImageView img = (ImageView)getView().findViewById(R.id.imageViewComputer);
        //textView.setText(Resources.getSystem().getIdentifier(getText(position), "values/strings", "android"));
        try {
            textView.setText(R.string.class.getField(getText(position)).getInt(null));
            img.setImageResource(R.drawable.class.getField(getText(position)).getInt(null));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private String getText(String position) {
        String text;
        switch (position) {
            case "00" : text = "monitor"; break;
            case "01" : text = "printer"; break;
            case "02" : text = "speaker"; break;
            case "03" : text = "memory"; break;
            case "04" : text = "keyboard"; break;
            case "05" : text = "mouse"; break;
            case "06" : text = "scanner"; break;
            case "07" : text = "cpu"; break;
            case "08" : text = "headsets"; break;
            case "09" : text = "webcam"; break;
            default : text = ""; break;
        }
        return text;
    }
}