package com.state_manager.side_effect

import com.state_manager.BaseUnitTest
import com.state_manager.logger.SystemOutLogger
import com.state_manager.side_effects.SideEffectHolderImpl
import com.state_manager.test.TestStateManagerScope
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.Test

class SideEffectHolderTest : BaseUnitTest() {

    val testManagerScope = TestStateManagerScope()
    val holder =
        SideEffectHolderImpl<TestSideEffects>(SystemOutLogger(""), testManagerScope.getScope())

    @Test
    fun `test side effect emitted`() {
        runTest {
            val list = mutableListOf<TestSideEffects?>()
            backgroundScope.launch(testManagerScope.testDispatcher) {
                holder.effectObservable.collect {
                    list.add(it)
                }
            }
            holder.post(ShowToast)
            assertEquals(ShowToast, list.first())
            list.clear()
            holder.post(ShowDialog)
            assertEquals(ShowDialog, list.first())
            list.clear()
        }
    }

    @Test
    fun `test side effect emitted multiple times`(){
        runTest {
            val list = mutableListOf<TestSideEffects?>()
            backgroundScope.launch(testManagerScope.testDispatcher) {
                holder.effectObservable.collect {
                    list.add(it)
                }
            }
            holder.post(ShowToast)
            holder.post(ShowToast)
            assertEquals("Value is ",2,list.size)
        }
    }

    @Test
    fun `test side effects are not cached`(){
        runTest {
            val list = mutableListOf<TestSideEffects?>()
            holder.post(ShowToast)
            holder.post(ShowToast)

            backgroundScope.launch(testManagerScope.testDispatcher) {
                holder.effectObservable.collect {
                    list.add(it)
                }
            }
            assertEquals("Size is ",0,list.size)
        }
    }
}