package com.arduia.recsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arduia.recsample.model.SampleItem
import com.arduia.recsample.recylerview.SampleAdapter
import com.arduia.recsample.recylerview.bind
import com.arduia.recsample.recylerview.update
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_sample.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sampleList = listOf(SampleItem("id1","Kotlin","Multi-paradigm"),
            SampleItem("id2","Java","Old Guy")
        )
        /**
         * Please invoke only one method..
         */
//      sample1(sampleList)
        sample2(sampleList)
    }

    /**
     * Extension bind Style
     */
    private fun sample1(sampleList:List<SampleItem>){
        main_recycler_view.bind(sampleList,R.layout.item_sample){
                item->
            this.title.text = item.title
            this.description.text = item.description
        }
        main_recycler_view.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
    }

    /**
     * Sample Adapter Style
     */
    private fun sample2(sampleList: List<SampleItem>){
        main_recycler_view.adapter = SampleAdapter(layoutInflater).apply {
            dataList = sampleList
        }
        main_recycler_view.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)

    }
}
