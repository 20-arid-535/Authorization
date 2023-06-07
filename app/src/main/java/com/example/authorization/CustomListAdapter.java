package com.example.authorization;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter<String> {
    private final String[] itemName;
    private final int[] imageId;
    private final String[] itemDescription;
    private Context context;

    public CustomListAdapter(Activity context, int[] imgId, String[] itemNam, String[] itemDesc) {
        super(context, R.layout.customlist, itemNam);
        this.imageId = imgId;
        this.itemName = itemNam;
        this.itemDescription = itemDesc;
        this.context=context;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        //convertView = LayoutInflater.from(context).inflate(R.layout.customlist, parent, false);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      listItemView = inflater.inflate(R.layout.customlist, parent, false);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.icon);
        TextView itemTitle = (TextView) listItemView.findViewById(R.id.item);
        TextView itemTitle1 = (TextView) listItemView.findViewById(R.id.item1);

        imageView.setImageResource(imageId[position]);
        itemTitle.setText(itemName[position]);
        itemTitle1.setText(itemDescription[position]);

        return listItemView;
    };
}
