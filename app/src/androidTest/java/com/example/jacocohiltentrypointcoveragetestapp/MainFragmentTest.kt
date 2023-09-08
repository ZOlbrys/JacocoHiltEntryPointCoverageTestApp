package com.example.jacocohiltentrypointcoveragetestapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

@HiltAndroidTest
class MainFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @BindValue
    val viewModel = mock<MainViewModel>()

    @Test
    fun startAppAndPressButton() {
        launchFragmentInHiltContainer<MainFragment>()

        onView(withId(R.id.button)).perform(click())

        verify(viewModel).onButtonPress()
    }
}
