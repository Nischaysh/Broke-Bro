package com.example.brokebro

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.core.app.ActivityOptionsCompat

fun View.startHeroTransition(
    activity: Activity,
    targetActivity: Class<*>,
    transitionName: String
) {
    val intent = Intent(activity, targetActivity)

    val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
        activity,
        this, // `this` is the clicked view
        transitionName
    )
    activity.startActivity(intent, options.toBundle())
}
