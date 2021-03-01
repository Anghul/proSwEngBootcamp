package com.github.anghul.bootcamp;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.intent.matcher.ComponentNameMatchers.hasClassName;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public IntentsTestRule<MainActivity> rules = new IntentsTestRule<>(MainActivity.class);

    @Test
    public void mainActivityLeadToGreetingsAndSetMessage() {
        Espresso.onView(ViewMatchers.withId(R.id.mainName))
                .perform(ViewActions.replaceText("Test"));
        Espresso.onView(ViewMatchers.withId(R.id.mainGoButton))
                .perform(ViewActions.click());

        Intents.intended(Matchers.allOf(
                hasComponent(hasClassName(GreetingsActivity.class.getName())),
                hasExtra(MainActivity.EXTRA_MESSAGE, "Test")));
    }
}
