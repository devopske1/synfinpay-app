package com.example.synfinpay.utils

import android.content.Context
import android.content.SharedPreferences


class SynFinSharedPreferences(context: Context) {
    private var prefs: SharedPreferences =
        context.getSharedPreferences(
            "DELIVERANCE_PREFERENCE_DATA",
            Context.MODE_PRIVATE
        )

    companion object {
        const val is_first_time: String = "is_first_time"
        const val EMAIL: String = "user_email"
    }

    fun setIsFirstTimerUser(isFirstTime: Boolean) {
        val editor = prefs.edit()
        editor.putBoolean(is_first_time, isFirstTime)
        editor.apply()
    }

    fun getIsFirstTimerUser(): Boolean {
        return prefs.getBoolean(is_first_time, true)
    }


    fun setEMAIL(Email: String) {
        val editor = prefs.edit()
        editor.putString(EMAIL, Email)
        editor.apply()
    }

    fun getEmail(): String {
        return prefs.getString(EMAIL, "").toString()
    }
}