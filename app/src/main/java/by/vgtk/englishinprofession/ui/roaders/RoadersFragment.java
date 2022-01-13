package by.vgtk.englishinprofession.ui.roaders;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import by.vgtk.englishinprofession.PDFViewActivity;
import by.vgtk.englishinprofession.R;
import by.vgtk.englishinprofession.databinding.FragmentRoadersBinding;
import by.vgtk.englishinprofession.ui.computers.EnglishVocForComputerActivity;


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
                Intent intent = new Intent(getContext(), PDFViewActivity.class);
                intent.putExtra("bookLink", "https://drive.google.com/file/d/1j5qesLJe1TDuej6wCfz12Ds1j8hNEd8Q/view?usp=sharing");
                startActivity(intent);
            }
        });


        ExpandableListView elv = (ExpandableListView) root.findViewById(R.id.expListViewEICO);
        elv.setAdapter(new RoadersFragment.RoadersExpandableList());

        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                String position = String.valueOf(groupPosition) + String.valueOf(childPosition);
                Intent intent = new Intent(getContext(), RoadersVideoActivity.class);
                intent.putExtra("linkPosition", position);
                startActivity(intent);
                return false;
            }
        });

//        Button button = (Button) root.findViewById(R.id.buttonRoadersBook);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), PDFViewActivity.class);
//                intent.putExtra("bookLink", "https://drive.google.com/file/d/1j5qesLJe1TDuej6wCfz12Ds1j8hNEd8Q/view?usp=sharing");
//                startActivity(intent);
//            }
//        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public class RoadersExpandableList extends BaseExpandableListAdapter {

        //"Tests"
        private String[] groups = {"Videos"};

        //{"Test1", "Test2", "Test3"},
        private String[][] children = {
                {"Video1", "Video2", "Video3"}
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
                LayoutInflater ltInflater = getLayoutInflater();
                view = ltInflater.inflate(R.layout.group_items, null, false);
            }
            TextView textView = (TextView) view.findViewById(R.id.listGroupData);
            textView.setText(getGroup(i).toString());
            return textView;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            if (view == null) {
                LayoutInflater ltInflater = getLayoutInflater();
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
