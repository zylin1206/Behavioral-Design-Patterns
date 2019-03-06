package com.example.Chain_of_Responsibility;

import android.util.Log
import com.example.Chain_of_Responsibility.MiddleWare.RoleCheckMiddleware
import com.example.Chain_of_Responsibility.MiddleWare.ThrottlingMiddleware
import com.example.Chain_of_Responsibility.MiddleWare.UserExistsMiddleware
import com.example.Chain_of_Responsibility.Server.Server


/**
 * Created by Android Studio
 * Author: Duy-Linh Nguyen
 * Date: 3/6/19
 * Time: 5:55 PM
 */
public class Demo_CoR {
    private var server: Server? = null

    private fun init() {
        server = Server()
        server!!.register("admin@example.com", "admin_pass")
        server!!.register("user@example.com", "user_pass")

        // All checks are linked. Client can build various chains using the same
        // components.
        val middleware = ThrottlingMiddleware(2)
        middleware.linkWith(UserExistsMiddleware(server!!))
            .linkWith(RoleCheckMiddleware())

        // Server gets a chain from client code.
        server!!.setMiddleware(middleware)
    }

    fun runDemo(email: String, password: String) {
        Log.i(TAG, "Run demo")
        init()
        val success = server!!.logIn(email, password)
        Log.i(TAG, "Success: $success")
    }
}
