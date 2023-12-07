package com.grid.state_manager.test.container

import com.state_manager.side_effects.SideEffect
import com.state_manager.state.AppState
import org.junit.Assert.assertEquals

/**
 * compare the emitted states with the list of states
 */
fun com.grid.state_manager.test.container.TestResult.StateResult<*>.expect(states: List<Any>) {
    assertEquals(states, emittedStates)
}

fun <S : AppState> com.grid.state_manager.test.container.TestResult.StateResult<*>.expect(vararg states: S) {
    assertEquals(states.toList(), emittedStates)
}

fun <S : AppState> com.grid.state_manager.test.container.TestResult.StateResult<S>.has(expression: (S) -> Boolean) {
    assert(expression(emittedStates.last()))
}

fun <SIDE_EFFECT : SideEffect> com.grid.state_manager.test.container.TestResult.SideEffectsResult<SIDE_EFFECT>.expect(vararg effects: SIDE_EFFECT) {
    assertEquals(effects.toList(), emittedEffects)
}

fun com.grid.state_manager.test.container.TestResult.StateResult<*>.expectNotEmpty() {
    assert(emittedStates.isNotEmpty())
}