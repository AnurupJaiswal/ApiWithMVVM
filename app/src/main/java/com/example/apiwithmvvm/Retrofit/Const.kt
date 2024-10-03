package com.example.apiwithmvvm.Retrofit

import com.example.apitesting.basic.UtilityTools.Constants

interface Const {

    companion object {

        // Environment  **NOTE**  Change "Live" With "Debug"  When Going Live
        const val Development = Constants.Debug

        //Live
//            const val HOST_URL = "https://sales.supportyws9.net/"


        //Debug
        const val HOST_URL = "http://192.168.0.13:4000/api/users/"


        const val signUp = "signUp"

        const val login = "login"

        const val get = "get"

        const val update = "update"

        const val delete = "delete"

    }
}
