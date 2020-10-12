package br.com.hackroll.app


import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.hackroll.app.adapterers.RecyclerAdapter
import br.com.hackroll.app.helpers.Utils


class MainActivity : AppCompatActivity() {
    private var mRecyclerView: RecyclerView? = null
    private var mContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mContext = this@MainActivity
        mRecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = RecyclerAdapter()
        mRecyclerView?.adapter = adapter
        mRecyclerView?.layoutManager = LinearLayoutManager(mContext)
        mRecyclerView?.adapter = adapter
        mRecyclerView?.setHasFixedSize(true)
        val itens = Utils.loadItems()
        adapter.setItems(itens)
    }

}
