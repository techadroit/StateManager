package com.grid.state_manager.test.viewmodel_test

import com.state_manager.events.AppEvent

data class CountingEvent(val counter: Int = 1) : AppEvent
