package practicaltask.riseapps.com.practicaltask.ui.countryList.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import practicaltask.riseapps.com.practicaltask.R;
import practicaltask.riseapps.com.practicaltask.data.model.CountryDTO;
import practicaltask.riseapps.com.practicaltask.ui.base.Callback;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.ViewHolder> {

    private List<CountryDTO> mDataset;
    private Callback<CountryDTO> clickCallback;

    static class ViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private TextView countryName;
        private TextView countryCapital;

        private ViewHolder(View view, TextView countryName, TextView countryCapital) {
            super(view);
            this.countryName = countryName;
            this.countryCapital = countryCapital;
            this.view = view;
        }
    }

    public CountryListAdapter(Callback<CountryDTO> clickCallback) {
        this.clickCallback = clickCallback;
    }

    @Override
    public CountryListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.widget_country_element, parent, false);
        TextView name = view.findViewById(R.id.country_name);
        TextView capital = view.findViewById(R.id.country_capital);
        return new CountryListAdapter.ViewHolder(view, name, capital);
    }

    @Override
    public void onBindViewHolder(CountryListAdapter.ViewHolder holder, int position) {
        final CountryDTO country = mDataset.get(position);
        holder.countryName.setText(country.getName());
        holder.countryCapital.setText(country.getCapital());
    }

    @Override
    public int getItemCount() {
        return mDataset == null ? 0 : mDataset.size();
    }

    public void setmDataset(List<CountryDTO> mDataset) {
        this.mDataset = mDataset;
        notifyDataSetChanged();
    }
}
