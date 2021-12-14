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

        Button button = (Button) root.findViewById(R.id.EnglishVocabularyForComputersButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), EnglishVocForComputerActivity.class);
                startActivity(intent);
            }
        });

        ExpandableListView elv = (ExpandableListView) root.findViewById(R.id.expListViewEICO);
        elv.setAdapter(new EngInComOperationList());

        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                    String position = String.valueOf(groupPosition) + String.valueOf(childPosition);
                    Intent intent=new Intent(getContext(), ListViewActivity.class);
                    intent.putExtra("position", position);
                    startActivity(intent);
                return false;
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public class EngInComOperationList extends BaseExpandableListAdapter {

        private String[] groups = {"Сomputer components"};

        private String[][] children = {
                {"Monitor", "Printer", "Speaker", "Memory unit", "KeyBoard", "Computer mouse",
                        "Scanner", "CPU", "Headsets", "Webcam"},
        };

        @Override
        public int getGroupCount() {
            return groups.length;
        }

        @Override
        public int getChildrenCount(int i) {
            return children[i].length;
        }

        @Override
        public Object getGroup(int i) {
            return groups[i];
        }

        @Override
        public Object getChild(int i, int i1) {
            return children[i][i1];
        }

        @Override
        public long getGroupId(int i) {
            return i;
        }

        @Override
        public long getChildId(int i, int i1) {
            return i1;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            if (view == null) {
                LayoutInflater  ltInflater = getLayoutInflater();
                view = ltInflater.inflate(R.layout.group_items, null, false);
            }
            TextView textView = (TextView) view.findViewById(R.id.listGroupData);
            textView.setText(getGroup(i).toString());
            return textView;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            if (view == null) {
                LayoutInflater  ltInflater = getLayoutInflater();
                view = ltInflater.inflate(R.layout.child_items, null, false);
            }
            TextView textView = (TextView) view.findViewById(R.id.groupListChildItm);
            textView.setText(getChild(i, i1).toString());
            return textView;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return true;
        }
    }
}