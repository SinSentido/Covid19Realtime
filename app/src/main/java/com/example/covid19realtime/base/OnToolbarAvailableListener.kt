package com.example.covid19realtime.base

import android.widget.Toolbar

interface OnToolbarAvailableListener {
    fun onToolbarCreated(toolbar: Toolbar)

    fun onToolbarDestroyed()
}