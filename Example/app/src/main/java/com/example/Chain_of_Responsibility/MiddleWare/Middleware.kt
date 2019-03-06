package com.example.Chain_of_Responsibility.MiddleWare

/**
 * Created by Android Studio
 * Author: Duy-Linh Nguyen
 * Date: 3/6/19
 * Time: 5:56 PM
 */

/**
 * Base middleware class.
 */
abstract class Middleware {
    private var next: Middleware? = null

    /**
     * Builds chains of middleware objects.
     */
    fun linkWith(next: Middleware): Middleware {
        this.next = next
        return next
    }

    /**
     * Subclasses will implement this method with concrete checks.
     */
    abstract fun check(email: String, password: String): Boolean

    /**
     * Runs check on the next object in chain or ends traversing if we're in
     * last object in chain.
     */
    protected fun checkNext(email: String, password: String): Boolean {
        return if (next == null) {
            true
        } else next!!.check(email, password)
    }
}
