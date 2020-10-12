package br.com.hackroll.app.model

class SubItem(title: String, ok: Boolean) {
    var title: String? = null
    var resolved: Boolean = false

    init {
        this.title = title
        this.resolved = ok
    }
}
