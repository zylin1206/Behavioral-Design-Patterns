package com.example.Chain_of_Responsibility.Server

import android.util.Log
import com.example.Chain_of_Responsibility.MiddleWare.Middleware
import com.example.Chain_of_Responsibility.TAG


/**
 * Created by Android Studio
 * Author: Duy-Linh Nguyen
 * Date: 3/6/19
 * Time: 6:08 PM
 */

/**
 * Server class.
 */
class Server {
    private val users = HashMap<String, String>()
    private var middleware: Middleware? = null

    /**
     * Client passes a chain of object to server. This improves flexibility and
     * makes testing the server class easier.
     */
    fun setMiddleware(middleware: Middleware) {
        this.middleware = middleware
    }

    /**
     * Server gets email and password from client and sends the authorization
     * request to the chain.
     */
    fun logIn(email: String, password: String): Boolean {
        if (middleware!!.check(email, password)) {
            Log.i(TAG, "Authorization have been successful for $email!")

            // Do something useful here for authorized users.

            return true
        }
        return false
    }

    fun register(email: String, password: String) {
        users.put(email, password)
    }

    fun hasEmail(email: String): Boolean {
        return users.containsKey(email)
    }

    fun isValidPassword(email: String, password: String): Boolean {
        return users.get(email) == password
    }
}