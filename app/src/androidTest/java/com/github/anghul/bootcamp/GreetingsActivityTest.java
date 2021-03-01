package com.gifthub.anghul.bootcamp;

import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.github.anghul.bootcamp.GreetingsActivity;
import com.github.anghul.bootcamp.MainActivity;
import com.github.anghul.bootcamp.R;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class GreetingsActivityTest {

    @Test
    public void greetingsActivityShowTheCorrectMessage() {
        Intents.init();

        Intent intent = new Intent(ApplicationProvider.getApplicationContext(), GreetingsActivity.class);
        String name = "test";
        intent.putExtra(MainActivity.EXTRA_MESSAGE, name);

        ActivityScenario scenario = ActivityScenario.launch(intent);
        Espresso.onView(ViewMatchers.withId(R.id.textView))
                .check(ViewAssertions.matches(ViewMatchers.withText("Hello test !")));

        scenario.close();
        Intents.release();
    }
}
