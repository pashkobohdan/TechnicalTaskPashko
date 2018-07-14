package practicaltask.riseapps.com.practicaltask.ui.regionList.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import practicaltask.riseapps.com.practicaltask.R
import practicaltask.riseapps.com.practicaltask.data.enums.Region

class RegionListAdapter(private val clickCallback: (Region) -> Unit) : RecyclerView.Adapter<RegionListAdapter.ViewHolder>() {

    private var mDataset: List<Region>? = null

    inner class ViewHolder constructor(val view: View, val mTextView: TextView) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegionListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.widget_region_element, parent, false)
        val textView = view.findViewById<View>(R.id.region_name) as TextView
        return ViewHolder(view, textView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val region = mDataset!![position]
        holder.mTextView.text = region.title
        holder.view.setOnClickListener { v -> clickCallback(region) }
    }

    override fun getItemCount(): Int {
        return mDataset?.size ?: 0
    }

    fun setmDataset(mDataset: List<Region>) {
        this.mDataset = mDataset
        notifyDataSetChanged()
    }
}
