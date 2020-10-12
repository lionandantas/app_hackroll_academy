package br.com.hackroll.app.model

class Item(heading: String, list: List<SubItem>) {
    var heading: String = ""
    var children: List<SubItem> = emptyList<SubItem>()

    init {
        this.heading = heading
        this.children = list
    }
}