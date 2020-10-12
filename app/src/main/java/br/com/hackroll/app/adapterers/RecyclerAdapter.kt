package br.com.hackroll.app.adapterers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.hackroll.app.R
import br.com.hackroll.app.model.Item
import com.github.florent37.expansionpanel.ExpansionLayout
import com.github.florent37.expansionpanel.viewgroup.ExpansionLayoutCollection

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder>() {
    var list = ArrayList<Item>()
    private val expansionsCollection = ExpansionLayoutCollection()

    init {
        expansionsCollection.openOnlyOne(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerHolder {
        return RecyclerHolder.buildFor(parent)
    }

    override fun onBindViewHolder(holder: RecyclerHolder, position: Int) {
        holder.bind(list.get(position))
        expansionsCollection.add(holder.expansionLayout)
    }

    fun setItems(items: ArrayList<Item>) {
        this.list.addAll(items)
        notifyDataSetChanged()
    }

    class RecyclerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var expansionLayout: ExpansionLayout
            internal set
        var headerTitle: TextView
        var total: TextView
        var linearLayout_childItems: LinearLayout
        val context: Context

        init {
            expansionLayout = itemView.findViewById(R.id.expansionLayout)
            headerTitle = itemView.findViewById<TextView>(R.id.titleHeader)
            total = itemView.findViewById<TextView>(R.id.total)
            linearLayout_childItems = itemView.findViewById(R.id.ll_child_items)

            context = itemView.context
        }

        fun bind(item: Item) {
            expansionLayout.collapse(false)
            headerTitle.text = item.heading
            linearLayout_childItems.layoutParams.height = 125 * item.children.size
            total.text = "${item.children.count { item -> item.resolved }}/${item.children.size}"
            val lv = itemView.findViewById(R.id.listviews) as ListView
            lv.adapter = SubItemAdapter(context, item.children)

        }

        companion object {
            private val LAYOUT = R.layout.expansion_panel_recycler
            fun buildFor(viewGroup: ViewGroup): RecyclerHolder {
                return RecyclerHolder(
                    LayoutInflater.from(viewGroup.context).inflate(
                        LAYOUT,
                        viewGroup,
                        false
                    )
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}