package com.kulya.dev.testproject.ui.common.adapter


import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.kulya.dev.testproject.util.inflate
import com.kulya.dev.testproject.util.swap


abstract class BaseAdapter<ITEM> constructor(protected var itemList: MutableList<ITEM>,
                                             private val layoutResId: Int)
    : RecyclerView.Adapter<BaseAdapter.Holder>(){
    override fun getItemCount() = itemList.size

    protected lateinit var itemView:View

    protected lateinit var viewHolder:Holder


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = parent inflate layoutResId
        viewHolder = Holder(view)


        return viewHolder
    }



    override fun onBindViewHolder(holder: BaseAdapter.Holder, position: Int) {
        val item = itemList[position]
        holder.itemView.bind(item, position, holder)
    }

    fun update(items: MutableList<ITEM>) {
        updateAdapterWithDiffResult(calculateDiff(items))

    }

    private fun updateAdapterWithDiffResult(result: DiffUtil.DiffResult) {

        result.dispatchUpdatesTo(this)
    }

    private fun calculateDiff(newItems: MutableList<ITEM>) =
            DiffUtil.calculateDiff(DiffUtilCallback(itemList, newItems))

    fun add(item: ITEM) {
        itemList.add(item)
        notifyItemInserted(itemList.size)
    }

    fun remove(position: Int) {
        itemList.removeAt(position)
        notifyItemRemoved(position)
    }

    fun clear(){
        itemList.clear()
        notifyDataSetChanged()
    }

    fun getList() = itemList.toMutableList()



    fun moveUp(position: Int){
        if(position>0){
            itemList.swap(position, position-1)
            notifyItemMoved(position, position-1)
        }
    }
    fun moveDown(position: Int){
        if(itemList.lastIndex>position){
            itemList.swap(position, position + 1)
            notifyItemMoved(position, position + 1 )

        }
    }
    fun updateData(newItems:MutableList<ITEM>){
        itemList.clear()
        itemList.addAll(newItems)
        notifyDataSetChanged()
    }

    final override fun onViewRecycled(holder: Holder) {
        super.onViewRecycled(holder)
        onViewRecycled(holder.itemView)
    }

    protected open fun onViewRecycled(itemView: View) {
    }

    protected open fun onItemClick(itemView: View, position: Int) {
    }

    protected open fun View.bind(item: ITEM, position: Int,holder: BaseAdapter.Holder) {
    }

    fun getCurrentPosition() = viewHolder.adapterPosition

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)
}