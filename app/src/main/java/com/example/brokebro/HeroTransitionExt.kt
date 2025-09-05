package com.example.brokebro

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.core.app.ActivityOptionsCompat

fun View.startHeroTransition(
    activity: Activity,
    targetActivity: Class<*>,
    transitionName: String,
    extras: Map<String, Any>? = null
) {
    val intent = Intent(activity, targetActivity)

    // Add extras if provided
    extras?.forEach { (key, value) ->
        when (value) {
            is String -> intent.putExtra(key, value)
            is Int -> intent.putExtra(key, value)
            is Boolean -> intent.putExtra(key, value)
            is Float -> intent.putExtra(key, value)
            is Double -> intent.putExtra(key, value)
            is Long -> intent.putExtra(key, value)
        }
    }

    val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
        activity,
        this, // clicked view
        transitionName
    )
    activity.startActivity(intent, options.toBundle())
}
