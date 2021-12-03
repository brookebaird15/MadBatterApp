package com.example.madbatterapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.madbatterapp.AboutFAQListview.CustomFAQAdapter;
import com.example.madbatterapp.AboutFAQListview.FAQItem;
import com.example.madbatterapp.R;

import java.util.ArrayList;


public class AboutFragment extends Fragment {
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);
//        listView = view.findViewById(R.id.faqList);
//        ArrayList<FAQItem> faqItemArrayList = new ArrayList<>();
//        faqItemArrayList.add(new FAQItem(getString(R.string.orderQuestion), getString(R.string.orderAnswer)));
//        faqItemArrayList.add(new FAQItem(getString(R.string.hoursQuestion), getString(R.string.hoursAnswer)));
//        faqItemArrayList.add(new FAQItem(getString(R.string.requestQuestion), getString(R.string.requestAnswer)));
//        faqItemArrayList.add(new FAQItem(getString(R.string.placeOrderQuestion), getString(R.string.placeOrderAnswer)));
//        listView.setAdapter(new CustomFAQAdapter(getContext(), faqItemArrayList));
        return view;

    }
}