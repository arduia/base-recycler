package com.arduia.recsample.recylerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<Item>(private val layoutInflater: LayoutInflater):RecyclerView.Adapter<BaseAdapter.BaseViewHolder>(){

    @get:LayoutRes
    protected abstract val viewItemID:Int

    var dataList :List<Item> = arrayListOf ()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return BaseViewHolder(layoutInflater.inflate(viewItemID,parent,false))
    }

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.view.bindViewHolder(dataList[position])
    }

    protected abstract fun View.bindViewHolder(item:Item)

    class BaseViewHolder(val view:View):RecyclerView.ViewHolder(view)

}

class ExtensionBaseAdapter<Item>(layoutInflater: LayoutInflater,
                                 override val viewItemID: Int,
                                 private val onBind:View.(Item)->Unit):BaseAdapter<Item>(layoutInflater){

    override fun View.bindViewHolder(item: Item) = this.onBind(item)
}


//Code Style from fast-list repository https://github.com/dev-labs-bg/fast-list

fun <Item> RecyclerView.bind(list:List<Item>,@LayoutRes id:Int,onBind:View.(Item)->Unit){
    val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    adapter = ExtensionBaseAdapter(layoutInflater = layoutInflater,viewItemID = id,onBind = onBind ).apply {
        dataList = list
    }
}

@SuppressWarnings("Unchecked Cast")
fun < Item>RecyclerView.update(list:List<Item>){
    (adapter as? ExtensionBaseAdapter<Item>)?.dataList = list
}


