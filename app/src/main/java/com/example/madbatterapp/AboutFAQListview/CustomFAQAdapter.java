package com.example.madbatterapp.AboutFAQListview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.madbatterapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CustomFAQAdapter extends ArrayAdapter<FAQItem> {
    public CustomFAQAdapter(@NonNull Context context, @NonNull ArrayList<FAQItem> items) {
        super(context, 0, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_listview_faq, parent, false);
        }
        TextView question = convertView.findViewById(R.id.question);
        question.setText(getItem(position).getQuestion());
        TextView answer = convertView.findViewById(R.id.answer);
        answer.setVisibility(View.GONE);
        answer.setText(getItem(position).getAnswer());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * Set it so when the view is clicked, the answer is revealed
             */
            public void onClick(View view) {
                answer.setVisibility(View.VISIBLE);
            }
        });
        return convertView;
    }
}
