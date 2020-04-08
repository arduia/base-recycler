package com.arduia.recsample.recylerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.arduia.recsample.viewbinding.DataBindingUtil

class GenericAdapter<T>(@LayoutRes private val row: Int, private val callback:(T)->Unit) :
    RecyclerView.Adapter<GenericAdapter.ViewHolder<T>>() {

    private val items = mutableListOf<T>()
    private val inflater: LayoutInflater? = null

    fun addItems(newItems: List<T>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<T> {
        val inflater = inflater ?: LayoutInflater.from(parent.context)
        val binding: ViewBinding = DataBindingUtil.inflate(inflater, row, parent, false)
        return ViewHolder(binding, callback)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder<T>, position: Int) {
        holder.bind(items[position])
    }


    class ViewHolder<T>(private val binding: ViewBinding,
                        private val callback:(T)->Unit) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dto: T) {
            binding.root.setOnClickListener{
                callback(dto)
            }
        }
    }

}
