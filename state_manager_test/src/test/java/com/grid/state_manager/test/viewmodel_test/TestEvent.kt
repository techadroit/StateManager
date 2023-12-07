package com.grid.state_manager.test.viewmodel_test

import com.state_manager.events.AppEvent

interface TestEvent : AppEvent

data class IncrementCountEvent(val counter: Int) : TestEvent
data class DecrementCountEvent(val counter: Int) : TestEvent