package com.example.Chain_of_Responsibility.MiddleWare

import android.util.Log
import com.example.Chain_of_Responsibility.TAG

/**
 * Created by Android Studio
 * Author: Duy-Linh Nguyen
 * Date: 3/6/19
 * Time: 6:07 PM
 */

/**
 * ConcreteHandler. Checks a user's role.
 */
class RoleCheckMiddleware : Middleware() {
    override fun check(email: String, password: String): Boolean {
        if (email == "admin@example.com") {
            Log.i(TAG, "Hello, admin!")
            return true
        }
        Log.i(TAG, "Hello, user!")
        return checkNext(email, password)
    }
}