package com.example.android.common.logger

class LogWrapper extends LogNode {

 private var mNext: LogNode = null


  def getNext: LogNode = mNext

  def setNext(node: LogNode) {
    mNext = node
  }

  override def println(priority: Int, tag: String, msg: String, tr: Throwable) {
    var useMsg: String = msg
    if (useMsg == null) {
      useMsg = ""
    }
    val mmsg =
      if (tr != null) {
        msg + "\n" + android.util.Log.getStackTraceString(tr)
      } else msg
    android.util.Log.println(priority, tag, useMsg)
    if (mNext != null) {
      mNext.println(priority, tag, mmsg, tr)
    }
  }
}