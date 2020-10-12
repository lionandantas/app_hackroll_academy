package br.com.hackroll.app.helpers

import br.com.hackroll.app.model.Item
import br.com.hackroll.app.model.SubItem


class Utils {
    companion object {
        fun loadItems(): ArrayList<Item> {

            val hackRollList = ArrayList<Item>()

            val sectionSSlPinning: ArrayList<SubItem> = ArrayList()
            sectionSSlPinning.add(SubItem("TrustManager", false))
            sectionSSlPinning.add(SubItem("OkKTTPV3", true))
            sectionSSlPinning.add(SubItem("TrustKit", false))
            sectionSSlPinning.add(SubItem("ITEM 1", false))
            sectionSSlPinning.add(SubItem("ITEM 2", false))
            sectionSSlPinning.add(SubItem("ITEM 3", false))
            sectionSSlPinning.add(SubItem("ITEM 4", false))
            sectionSSlPinning.add(SubItem("ITEM 5", false))
            sectionSSlPinning.add(SubItem("ITEM 6", false))
            sectionSSlPinning.add(SubItem("ITEM 7", false))
            sectionSSlPinning.add(SubItem("ITEM 8", false))
            sectionSSlPinning.add(SubItem("ITEM 9", false))
            sectionSSlPinning.add(SubItem("ITEM 10", false))
            hackRollList.add(Item("SSL-Pinning", sectionSSlPinning))


            val section2: ArrayList<SubItem> = ArrayList()
            section2.add(SubItem("TrustManagerImpl", true))
            section2.add(SubItem("OkKTTPV3", false))
            section2.add(SubItem("TrustKit", true))
            hackRollList.add(Item("SQL Inection", section2))

            return hackRollList
        }
    }
}