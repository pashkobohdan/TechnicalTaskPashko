package practicaltask.riseapps.com.practicaltask.ui.regionList.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import practicaltask.riseapps.com.practicaltask.R;
import practicaltask.riseapps.com.practicaltask.data.enums.Region;
import practicaltask.riseapps.com.practicaltask.ui.base.Callback;

public class RegionListAdapter extends RecyclerView.Adapter<RegionListAdapter.ViewHolder> {

    private List<Region> mDataset;
    private Callback<Region> clickCallback;

    static class ViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private TextView mTextView;
        private ViewHolder(View view, TextView textView) {
            super(view);
            mTextView = textView;
            this.view = view;
        }
    }

    public RegionListAdapter(Callback<Region> clickCallback) {
        this.clickCallback = clickCallback;
    }

    @Override
    public RegionListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.widget_region_element, parent, false);
        TextView textView = (TextView) view;
        return new ViewHolder(view, textView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Region region = mDataset.get(position);
        holder.mTextView.setText(region.getTitle());
        holder.view.setOnClickListener(v -> clickCallback.call(region));
    }

    @Override
    public int getItemCount() {
        return mDataset == null ? 0 : mDataset.size();
    }

    public void setmDataset(List<Region> mDataset) {
        this.mDataset = mDataset;
        notifyDataSetChanged();
    }
}
