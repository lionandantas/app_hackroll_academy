package br.com.hackroll.app


import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.hackroll.app.adapterers.RecyclerAdapter
import br.com.hackroll.app.helpers.Utils


class MainActivity : AppCompatActivity() {
    private var mRecyclerView: RecyclerView? = null
    private var fullStatus: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        fullStatus = findViewById<ImageView>(R.id.fullStatus)

        val adapter = RecyclerAdapter()

        mRecyclerView?.adapter = adapter
        mRecyclerView?.layoutManager = LinearLayoutManager(this@MainActivity)
        mRecyclerView?.adapter = adapter
        mRecyclerView?.setHasFixedSize(true)

        val itens = Utils.loadItems()

        adapter.setItems(itens)
        val resolved = itens.any { item -> item.children.all { t -> t.resolved } }

        if (resolved)
            fullStatus?.setImageResource(R.drawable.circle_ok)
        else
            fullStatus?.setImageResource(R.drawable.circle_error)

    }

}
