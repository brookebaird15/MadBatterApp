package com.example.madbatterapp.CartListView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.madbatterapp.R;

import java.util.List;

/**
 * Populate the listview with data of different items, using the custom layout
 */
public class CustomCartListAdapter extends BaseAdapter {
    private List<Product> productList;
    private LayoutInflater layoutInflater;
    private boolean showCheckbox;

    /**
     *  Constructor
     *  checkbox set to a bool so it can be seen in only the shopping cart
     * @param list | ArrayList
     * @param inflater | LayoutInflater
     * @param checkbox | bool
     */
    public CustomCartListAdapter(List<Product> list, LayoutInflater inflater, boolean checkbox){
        productList = list;
        layoutInflater = inflater;
        showCheckbox = checkbox;
    }
    @Override
    public int getCount(){
        return productList.size();
    }
    @Override
    public Object getItem(int position){
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        final ViewItem item;
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.custom_item_layout, parent, false );
            item = new ViewItem();

            item.productImgView = convertView.findViewById(R.id.itemImg);
            item.productTitle = convertView.findViewById(R.id.itemTitle);
            item.productCheckbox = convertView.findViewById(R.id.checkbox);

            convertView.setTag(item);
        } else {
            item = (ViewItem)convertView.getTag();
        }
        Product currentItem = productList.get(position);
        item.productImgView.setImageResource(currentItem.productImg);
        item.productTitle.setText(currentItem.title);

        //Hide the checkbox
        if (!showCheckbox) {
            item.productCheckbox.setVisibility(View.GONE);
        } else {
            if (currentItem.selected == true){
                item.productCheckbox.setChecked(true);
            } else {
                item.productCheckbox.setChecked(false);
            }
        }
        return convertView;

    }


    private class ViewItem{
        ImageView productImgView;
        TextView productTitle;
        CheckBox productCheckbox;
    }
}

