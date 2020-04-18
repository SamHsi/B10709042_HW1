package com.example.B10709042_HW1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<MainActivity.Item> mData;

    MyAdapter(List<MainActivity.Item> data) {
        mData = data;
    }

    // 建立ViewHolder
    class ViewHolder extends RecyclerView.ViewHolder{
        // 宣告元件
        private TextView txtItem;
        private CheckBox checkBox;

        ViewHolder(View itemView) {
            super(itemView);
            txtItem = (TextView) itemView.findViewById(R.id.txtItem);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 連結項目布局檔list_item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // 設置要顯示的內容
        holder.txtItem.setText(mData.get(position).text);
        holder.checkBox.setChecked(mData.get(position).check);
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean b = ((CheckBox) v).isChecked();
                holder.checkBox.setChecked(b);
                mData.get(position).setCheck(b);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
