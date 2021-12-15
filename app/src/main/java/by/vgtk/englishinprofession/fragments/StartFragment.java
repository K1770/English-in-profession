package by.vgtk.englishinprofession.fragments;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import by.vgtk.englishinprofession.R;
import by.vgtk.englishinprofession.databinding.FragmentStartPartsBinding;

public class StartFragment extends Fragment {

    private FragmentStartPartsBinding binding;

    public StartFragment() {
        super(R.layout.fragment_start_parts);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStartPartsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        TextView textView = (TextView) getView().findViewById(R.id.startTextView);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText(formatText());
    }

    public Spanned formatText() {
        Spanned text = Html.fromHtml("<span style=\"color: black;\">\n" +
                        "Расширение международных связей делает иностранный язык востребованным в практической и интеллектуальной\n" +
                        "деятельности специалиста.\n" +
                        "профессионально направленного обучения иностранному языку определяется социальным заказом общества и государства по\n" +
                        "отношению\n" +
                        "к языковому образованию рабочих кадров с учетом образовательной концепции учебной дисциплины «Иностранный язык».\n" +
                        "</span>" +
                        "<br><br>" +
                        "<span style=\"color: black;\">\n" +
                        "Основной целью изучения учебной дисциплины «Иностранный язык (профессиональная лексика)» является" +
                        "формирование профессиональной иноязычной коммуникативной компетенции в соответствии с профилем подготовки.</span>" +
                        "<br><br>" +
                        "<span style=\"color: black;\">\n" +
                        "Данный образовательный ресурс разработан для оказания помощи," +
                        " снятия языковых трудностей в изучении иностранного языка как" +
                        " профессионального компонента. Материалы соответствуют темам обязательным для изучения," +
                        " содержат тексты для чтения и упражнения к ним, видеоматериалы и наглядности," +
                        " материалы для самоконтроля.</span>"
                , Html.FROM_HTML_MODE_LEGACY);
        return text;
    }
}