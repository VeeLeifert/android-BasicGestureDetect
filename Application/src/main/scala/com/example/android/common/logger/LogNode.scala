package com.example.android.common.logger

trait LogNode {
  def println(priority: Int, tag: String, msg: String, tr: Throwable)
}