package com.example.testlistmap.navigation

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.testlistmap.LocationReferencesActivity
import com.example.testlistmap.MainActivity
import com.example.testlistmap.OptionPermissionsViewHolder
import com.example.testlistmap.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class EntriesFragmentTest {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testRecyclerViewDisplay() {
        // Verificar que el RecyclerView se muestra en la vista
        onView(withId(R.id.rv_entries_2)).check(matches(isDisplayed()))
        // Verificar que el RecyclerView tiene 2 elementos
        onView(withId(R.id.rv_entries_2)).check(matches(hasChildCount(2)))
    }

    @Test
    fun testRecyclerViewItemClick() {
        // Hacer clic en el primer elemento del RecyclerView
        onView(withId(R.id.rv_entries_2))
            .perform(actionOnItemAtPosition<OptionPermissionsViewHolder>(1, click()))

    }

    @get:Rule
    val activityScenarioTwoRule = ActivityScenarioRule(LocationReferencesActivity::class.java)
    @Test
    fun dataEntryFilterName() {
        onView(withId(R.id.rv_entries_2))
            .perform(actionOnItemAtPosition<OptionPermissionsViewHolder>(1, click()))

        onView(withId(R.id.ed_probar))
            .perform(typeText("Name "), closeSoftKeyboard())
    }
}
