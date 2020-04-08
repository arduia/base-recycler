package com.arduia.recsample.viewbinding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding

class DataBindingUtil private constructor(private val view:View):ViewBinding{
    override fun getRoot() = view
    companion object{
        fun inflate(inflater: LayoutInflater,
                    @LayoutRes row:Int,
                    parent:ViewGroup,
                    attachToRoot:Boolean= false):DataBindingUtil{
            return DataBindingUtil(inflater.inflate(row,parent,attachToRoot))
        }
    }
}
