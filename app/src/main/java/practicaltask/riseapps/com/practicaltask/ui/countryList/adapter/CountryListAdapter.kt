package practicaltask.riseapps.com.practicaltask.ui.countryList.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import practicaltask.riseapps.com.practicaltask.R
import practicaltask.riseapps.com.practicaltask.data.model.CountryDTO

class CountryListAdapter(private val clickCallback: (CountryDTO) -> Unit) : RecyclerView.Adapter<CountryListAdapter.ViewHolder>() {

    private var mDataset: List<CountryDTO>? = null

    inner class ViewHolder constructor(val view: View, val countryName: TextView, val countryCapital: TextView) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.widget_country_element, parent, false)
        val name = view.findViewById<TextView>(R.id.country_name)
        val capital = view.findViewById<TextView>(R.id.country_capital)
        return ViewHolder(view, name, capital)
    }

    override fun onBindViewHolder(holder: CountryListAdapter.ViewHolder, position: Int) {
        val country = mDataset!![position]
        holder.countryName.text = country.name
        holder.countryCapital.text = country.capital
        holder.view.setOnClickListener { v -> clickCallback(country) }
    }

    override fun getItemCount(): Int {
        return mDataset?.size ?: 0
    }

    fun setmDataset(mDataset: List<CountryDTO>) {
        this.mDataset = mDataset
        notifyDataSetChanged()
    }
}
