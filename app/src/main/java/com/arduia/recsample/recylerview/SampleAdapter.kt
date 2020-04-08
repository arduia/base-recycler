package com.arduia.recsample.recylerview

import android.view.LayoutInflater
import android.view.View
import com.arduia.recsample.R
import com.arduia.recsample.model.SampleItem
import kotlinx.android.synthetic.main.item_sample.view.*

class SampleAdapter(layoutInflater: LayoutInflater):BaseAdapter<SampleItem>(layoutInflater){
    override val viewItemID: Int
        get() = R.layout.item_sample

    override fun View.bindViewHolder(item: SampleItem) {
        title.text = item.title
        description.text = item.description
    }
}
