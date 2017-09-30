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
    println("main()")
	hot.initialize()
	val root = dom.document.getElementById("app")
	
	//val w = implicitly[me.shadaj.slinky.core.Writer[com.jc776.sketch.example.ReactSwap.Props]]

    val _ = ReactDOM.render(ReactSwap( () ), root)
	
  }
}