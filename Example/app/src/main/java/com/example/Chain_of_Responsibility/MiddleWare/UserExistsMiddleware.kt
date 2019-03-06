package com.example.Chain_of_Responsibility.MiddleWare

import android.util.Log
import com.example.Chain_of_Responsibility.Server.Server
import com.example.Chain_of_Responsibility.TAG

/**
 * Created by Android Studio
 * Author: Duy-Linh Nguyen
 * Date: 3/6/19
 * Time: 6:06 PM
 */

/**
 * ConcreteHandler. Checks whether a user with the given credentials exists.
 */
class UserExistsMiddleware(private val server: Server) : Middleware() {

    override fun check(email: String, password: String): Boolean {
        if (!server.hasEmail(email)) {
            Log.i(TAG, "$email is not registered!")
            return false
        }
        if (!server.isValidPassword(email, password)) {
            Log.i(TAG, "Wrong password!")
            return false
        }
        return checkNext(email, password)
    }
}