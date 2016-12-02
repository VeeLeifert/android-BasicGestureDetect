package com.example.android.basicgesturedetect

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import com.example.android.common.logger.Log
import android.view.Menu
import com.example.android.common.activities.SampleActivityBase
import com.example.android.common.logger.LogFragment
import com.example.android.common.logger.LogWrapper
import com.example.android.common.logger.MessageOnlyLogFilter

object MainActivity {
  val TAG: String = "MainActivity"
  val FRAGTAG: String = "BasicGestureDetectFragment"
}

class MainActivity extends SampleActivityBase {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    if (getSupportFragmentManager.findFragmentByTag(MainActivity.FRAGTAG) == null) {
      val transaction: FragmentTransaction = getSupportFragmentManager.beginTransaction
      val fragment: BasicGestureDetectFragment = new BasicGestureDetectFragment
      transaction.add(fragment, MainActivity.FRAGTAG)
      transaction.commit
    }
  }

  override def onCreateOptionsMenu(menu: Menu): Boolean = {
    getMenuInflater.inflate(R.menu.main, menu)
    return true
  }

  override def initializeLogging {
    val logWrapper: LogWrapper = new LogWrapper
    Log.setLogNode(logWrapper)
    val msgFilter: MessageOnlyLogFilter = new MessageOnlyLogFilter
    logWrapper.setNext(msgFilter)
    val logFragment: LogFragment = getSupportFragmentManager.findFragmentById(R.id.log_fragment).asInstanceOf[LogFragment]
    msgFilter.setNext(logFragment.getLogView)
    logFragment.getLogView.setBackgroundColor(Color.WHITE)
    Log.i(MainActivity.TAG, "Ready")
  }
}