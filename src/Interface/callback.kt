package Interface

import javax.swing.JOptionPane


class Exporter {
    fun export(item: Exportable, listener: ExportFinishListener) {
        val isFailed = (Math.random() * 3).toInt() % 3 == 0

        val msg = if (isFailed) {
            "輸出失敗，請重新嘗試！"
        } else {
            "輸出成功！ \n檔案路徑： ${item.getExportPath()}" + "\n檔案內容：\n${item.getExportContent()}"
        }

        listener.onFinish(msg)
    }
}

interface ExportFinishListener {
    fun onFinish(msg: String)
}

// 建立介面的object物件
val listener = object : ExportFinishListener {
    override fun onFinish(msg: String) {
        println(msg)
    }
}

//todo
fun showDialog(title: String, message: String) {
    JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE)
}

fun main() {
    val product = Product("BK001", "數學複習講義", 320, "本")

    //由於有些操作是「非同步」的，比方說網路連線、事件處理，程式流程未必能等到相關操作執行完畢再往下走。所以需要先寫好屆時要執行的程式，並包裝起來。
    val listener = object : ExportFinishListener {
        override fun onFinish(msg: String) {
            showDialog("匯出 ${product.name}", msg)
        }
    }

    Exporter().export(product, listener)
}











