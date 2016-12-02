package com.example.android.basicgesturedetect

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.GestureDetector
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import com.example.android.common.logger.Log
import com.example.android.common.logger.LogFragment

class BasicGestureDetectFragment extends Fragment {
  override def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setHasOptionsMenu(true)
  }

  override def onActivityCreated(savedInstanceState: Bundle) {
    super.onActivityCreated(savedInstanceState)
    val gestureView: View = getActivity.findViewById(R.id.sample_output)
    gestureView.setClickable(true)
    gestureView.setFocusable(true)
    val gestureListener: GestureDetector.SimpleOnGestureListener = new GestureListener
    val gd: GestureDetector = new GestureDetector(getActivity, gestureListener)
    gestureView.setOnTouchListener(new View.OnTouchListener() {
      def onTouch(view: View, motionEvent: MotionEvent): Boolean = {
        gd.onTouchEvent(motionEvent)
        return false
      }
    })
  }

  override def onOptionsItemSelected(item: MenuItem): Boolean = {
    if (item.getItemId == R.id.sample_action) {
      clearLog
    }
    return true
  }

  def clearLog {
    val logFragment: LogFragment = (getActivity.getSupportFragmentManager.findFragmentById(R.id.log_fragment).asInstanceOf[LogFragment])
    logFragment.getLogView.setText("")
  }
}