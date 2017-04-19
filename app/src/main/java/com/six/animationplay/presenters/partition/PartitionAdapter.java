package com.six.animationplay.presenters.partition;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.six.animationplay.R;

/**
 * Created by Administrator on 2017/4/7.
 */

public class PartitionAdapter extends BaseAdapter {

    private String[] mNames;
    private int[] mResourceIDs;
    private Context mContext;

    public PartitionAdapter(Context context, String[] names, int[] resourceIDs) {
        this.mNames = names;
        this.mResourceIDs = resourceIDs;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mNames.length;
    }

    @Override
    public String getItem(int position) {
        return mNames[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.item_partition_gridview, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.mTitle = (TextView) convertView.findViewById(R.id.partition_grid_view_title);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Drawable image = mContext.getResources().getDrawable(mResourceIDs[position]);
        image.setBounds(0, 0, image.getMinimumWidth(), image.getMinimumHeight());
        viewHolder.mTitle.setText(mNames[position]);
        viewHolder.mTitle.setCompoundDrawables(null, image, null, null);
        return convertView;
    }

    private class ViewHolder {
        TextView mTitle;
    }
}
