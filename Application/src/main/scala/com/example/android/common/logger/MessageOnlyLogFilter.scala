package com.example.android.common.logger

class MessageOnlyLogFilter extends LogNode {
  private[logger] var mNext: LogNode = null

  def this(next: LogNode) {
    this()
    mNext = next
  }

  def println(priority: Int, tag: String, msg: String, tr: Throwable) {
    if (mNext != null) {
      getNext.println(Log.NONE, null, msg, null)
    }
  }

  def getNext: LogNode = mNext

  def setNext(node: LogNode) {
    mNext = node
  }
}
