package com.jc776.sketch
import scalajs.js 
import js.annotation.{JSExportTopLevel, JSExport}
import example.ReactSwap

import me.shadaj.slinky.hot
import me.shadaj.slinky.web.ReactDOM
import org.scalajs.dom

@JSExportTopLevel("Sketch")
object Sketch {
  @JSExport
  def main() {
    try {
		println("main()")
		hot.initialize()
		val root = dom.document.getElementById("app")
		val _ = ReactDOM.render(ReactSwap( () ), root)
	} catch { case (ex: Exception) =>
	  ex.printStackTrace()
	  throw ex
	}
  }
}