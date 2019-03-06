package com.example.Chain_of_Responsibility.MiddleWare

/**
 * Created by Android Studio
 * Author: Duy-Linh Nguyen
 * Date: 3/6/19
 * Time: 5:59 PM
 */

/**
 * ConcreteHandler. Checks whether there are too many failed login requests.
 */
class ThrottlingMiddleware(private val requestPerMinute: Int) : Middleware() {
    private var request: Int = 0
    private var currentTime: Long = 0

    init {
        this.currentTime = System.currentTimeMillis()
    }

    /**
     * Please, not that checkNext() call can be inserted both in the beginning
     * of this method and in the end.
     *
     * This gives much more flexibility than a simple loop over all middleware
     * objects. For instance, an element of a chain can change the order of
     * checks by running its check after all other checks.
     */
    override fun check(email: String, password: String): Boolean {
        if (System.currentTimeMillis() > currentTime + 60000) {
            request = 0
            currentTime = System.currentTimeMillis()
        }

        request++

        if (request > requestPerMinute) {
            println("Request limit exceeded!")
            Thread.currentThread().interrupt()
        }
        return checkNext(email, password)
    }
}