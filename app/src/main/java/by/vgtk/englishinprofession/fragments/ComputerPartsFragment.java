package by.vgtk.englishinprofession.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        TextView textView = (TextView)getView().findViewById(R.id.computerTextView);

        Bundle arguments = getActivity().getIntent().getExtras();
        String position = arguments.get("position").toString();

        textView.setText(getText(position));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private String getText(String position) {
        String text;
        switch (position) {
            case "00" : text = getString(R.string.monitor); break;
            case "01" : text = getString(R.string.printer); break;
            case "02" : text = getString(R.string.speaker); break;
            case "03" : text = getString(R.string.memory); break;
            case "04" : text = getString(R.string.keyboard); break;
            case "05" : text = getString(R.string.mouse); break;
            case "06" : text = getString(R.string.scanner); break;
            case "07" : text = getString(R.string.cpu); break;
            case "08" : text = getString(R.string.headsets); break;
            case "09" : text = getString(R.string.webcam); break;
            default : text = ""; break;
        }
        return text;
    }
}