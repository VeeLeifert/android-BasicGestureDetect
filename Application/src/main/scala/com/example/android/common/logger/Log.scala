package com.example.android.common.logger


object Log {

  val NONE: Int = -1
  val VERBOSE: Int = android.util.Log.VERBOSE
  val DEBUG: Int = android.util.Log.DEBUG
  val INFO: Int = android.util.Log.INFO
  val WARN: Int = android.util.Log.WARN
  val ERROR: Int = android.util.Log.ERROR
  val ASSERT: Int = android.util.Log.ASSERT

  private var mLogNode: LogNode = null

  def getLogNode: LogNode = mLogNode

  def setLogNode(node: LogNode) {
    mLogNode = node
  }

  def println(priority: Int, tag: String, msg: String, tr: Throwable) {
    if (mLogNode != null) {
      mLogNode.println(priority, tag, msg, tr)
    }
  }

  def println(priority: Int, tag: String, msg: String) {
    println(priority, tag, msg, null)
  }

  def v(tag: String, msg: String, tr: Throwable) {
    println(VERBOSE, tag, msg, tr)
  }

  def v(tag: String, msg: String) {
    v(tag, msg, null)
  }

  def d(tag: String, msg: String, tr: Throwable) {
    println(DEBUG, tag, msg, tr)
  }

  def d(tag: String, msg: String) {
    d(tag, msg, null)
  }

  def i(tag: String, msg: String, tr: Throwable) {
    println(INFO, tag, msg, tr)
  }

  def i(tag: String, msg: String) {
    i(tag, msg, null)
  }

  def w(tag: String, msg: String, tr: Throwable) {
    println(WARN, tag, msg, tr)
  }

  def w(tag: String, msg: String) {
    w(tag, msg, null)
  }

  def w(tag: String, tr: Throwable) {
    w(tag, null, tr)
  }

  def e(tag: String, msg: String, tr: Throwable) {
    println(ERROR, tag, msg, tr)
  }


  def e(tag: String, msg: String) {
    e(tag, msg, null)
  }


  def wtf(tag: String, msg: String, tr: Throwable) {
    println(ASSERT, tag, msg, tr)
  }

  def wtf(tag: String, msg: String) {
    wtf(tag, msg, null)
  }

  def wtf(tag: String, tr: Throwable) {
    wtf(tag, null, tr)
  }
}