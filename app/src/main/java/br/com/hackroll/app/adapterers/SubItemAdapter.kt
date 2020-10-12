package br.com.hackroll.app.adapterers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import br.com.hackroll.app.R
import br.com.hackroll.app.model.SubItem


class SubItemAdapter(context: Context,list:List<SubItem>) : BaseAdapter() {
    var sList = ArrayList<SubItem>()

    private val mInflator: LayoutInflater = LayoutInflater.from(context)

    init {
        this.sList = list as ArrayList
    }

    override fun getCount(): Int {
        return sList.size
    }

    override fun getItem(position: Int): Any {
        return sList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val view: View?
        val vh: ListRowHolder
        if (convertView == null) {
            view = this.mInflator.inflate(R.layout.list_row, parent, false)
            vh = ListRowHolder(view)
            view?.tag = vh
        } else {
            view = convertView
            vh = view.tag as ListRowHolder
        }
        var item = sList[position]
        vh.label.text = item.title
        if(item.resolved)
            vh.status.setImageResource(R.drawable.circle_ok)
        else
            vh.status.setImageResource(R.drawable.circle_error)

        return view
    }
    fun setItems(items:List<SubItem>) {
        this.sList.addAll(items)
        notifyDataSetChanged()
    }

    private class ListRowHolder(row: View?) {
        val label: TextView
        val status: ImageView

        init {
            this.label = row?.findViewById(R.id.label) as TextView
            this.status = row?.findViewById(R.id.status) as ImageView
        }
    }
}

