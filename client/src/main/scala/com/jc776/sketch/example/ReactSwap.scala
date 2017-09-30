package com.jc776.sketch.example
import scalajs.js 
import org.scalajs.dom

import me.shadaj.slinky.core.ComponentWrapper 
import me.shadaj.slinky.web.html._
import me.shadaj.slinky.core.{Writer, Reader}

import scalajs.js 
import org.scalajs.dom

object ReactSwap extends ComponentWrapper {
  type Props = Unit
  sealed trait State
  case object A extends State
  case object B extends State
  val time = new js.Date()
  implicit val stateWriter: Writer[State] = (inst, root) => {
    println(s"${time} write $inst")
    val str = inst match {
      case A => "A"
      case B => "B"
    }
    js.Dynamic.literal(value = str)
  }
  implicit val stateReader: Reader[State] = (obj, root) => {
    val str = obj.asInstanceOf[js.Dynamic].value.asInstanceOf[String]
    println(s"${time} read ${js.Dynamic.global.JSON.stringify(obj)}")
    str match {
      case "A" => A 
      case "B" => B 
      case _ => throw new Exception("This isn't a serialized State.")
    }
  }

  class Def(jsProps: js.Object) extends Definition(jsProps) {
    def initialState = A
    
    def render() = {
      state match {
        case A => button("B!!", onClick := {(e: dom.Event) => {println("change to B"); setState(B)} })
        case B => button("A!!", onClick := {(e: dom.Event) => {println("change to A"); setState(A)} }) 
      }
    }
  }
}