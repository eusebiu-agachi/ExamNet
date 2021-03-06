package com.example.examnet.ui.domenii

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.examnet.R
import com.example.examnet.ui.domenii.ItemsAdapter.ItemsAdapterVH
import kotlinx.android.synthetic.main.row_item.view.*
import java.util.*
import kotlin.collections.ArrayList

class ItemsAdapter
    (var clickListener: ClickListener)
    : RecyclerView.Adapter<ItemsAdapterVH>(), Filterable {

    var itemsModelList = ArrayList<ItemsModel>()
    var itemsModelListFilter = ArrayList<ItemsModel>()

    fun setData(itemsModelList : ArrayList<ItemsModel>) {
        this.itemsModelList = itemsModelList
        this.itemsModelListFilter = itemsModelList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsAdapterVH {
        return ItemsAdapterVH(LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false))
    }

    override fun getItemCount(): Int {
        return itemsModelList.size
    }

    override fun onBindViewHolder(holder: ItemsAdapterVH, position: Int) {

        val itemsModel = itemsModelList[position]
        holder.name.text = itemsModel.name

        holder.itemView.setOnClickListener{
            clickListener.ClickedItem(itemsModel)
        }

    }

    class ItemsAdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name = itemView.tvName
    }


    interface ClickListener{
        fun ClickedItem(itemsModel : ItemsModel)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filterResults = FilterResults()
                if (constraint == null || constraint.length < 0){
                    filterResults.count = itemsModelListFilter.size
                    filterResults.values = itemsModelListFilter
                } else {
                    val searchChr = constraint.toString().toLowerCase(Locale.ROOT)
                    val itemModel = ArrayList<ItemsModel>()

                    for (item in itemsModelListFilter) {
                        if (item.name.contains(searchChr)){
                            itemModel.add(item)
                        }
                    }

                    filterResults.count = itemModel.size
                    filterResults.values = itemModel
                }
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                itemsModelList = results!!.values as ArrayList<ItemsModel>
                notifyDataSetChanged()
            }

        }
    }
}