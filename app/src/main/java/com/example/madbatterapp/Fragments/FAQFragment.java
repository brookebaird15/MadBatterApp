package com.example.madbatterapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.madbatterapp.AboutFAQListview.CustomFAQAdapter;
import com.example.madbatterapp.Pojo.FAQItem;
import com.example.madbatterapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FAQFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FAQFragment extends Fragment {
    ListView listView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FAQFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FAQFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FAQFragment newInstance(String param1, String param2) {
        FAQFragment fragment = new FAQFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_f_a_q, container, false);
        listView = view.findViewById(R.id.faqList);
        ArrayList<FAQItem> faqItemArrayList = new ArrayList<>();
        faqItemArrayList.add(new FAQItem(getString(R.string.orderQuestion), getString(R.string.orderAnswer)));
        faqItemArrayList.add(new FAQItem(getString(R.string.hoursQuestion), getString(R.string.hoursAnswer)));
        faqItemArrayList.add(new FAQItem(getString(R.string.requestQuestion), getString(R.string.requestAnswer)));
        faqItemArrayList.add(new FAQItem(getString(R.string.placeOrderQuestion), getString(R.string.placeOrderAnswer)));
        listView.setAdapter(new CustomFAQAdapter(getContext(), faqItemArrayList));
        return view;
    }
}