package com.example.apiwithmvvm.Retrofit

import com.example.apitesting.basic.UtilityTools.Constants
import com.example.apiwithmvvm.model.ApiResponse
import com.example.apiwithmvvm.model.LoginResponse
import com.example.apitesting.model.UpdateResponse
import com.example.apiwithmvvm.model.User
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.FormUrlEncoded
import retrofit2.http.PUT
import retrofit2.http.FieldMap
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.PartMap
import retrofit2.http.Path

interface ApiService {

    @Multipart
    @POST(Const.signUp)
    suspend fun signUp(
        @Part profilePicture: MultipartBody.Part,          // For the image file
        @PartMap hm: Map<String, @JvmSuppressWildcards RequestBody> // For the other form data
    ): Response<ApiResponse>

    @POST(Const.login)
    @FormUrlEncoded
    suspend fun login(
        @FieldMap hm: HashMap<String, String>
    ): Response<LoginResponse>

    @GET(Const.get)
    suspend fun getAllUsers(
        @Header(Constants.Authorization) token: String
    ): Response<List<User>>

    @Multipart
    @PUT("${Const.update}/{userName}")
    suspend fun updateUser(
        @Header(Constants.Authorization) token: String,
        @Path("userName") userName: String,
        @Part profilePicture: MultipartBody.Part,
        @Part("name") name: RequestBody,
        @Part("email") email: RequestBody
    ): Response<UpdateResponse>


    @DELETE("${Const.delete}/{userName}")
    suspend fun deleteUser(
        @Header(Constants.Authorization) token: String,
        @Path("userName") userName: String
    ): Response<ApiResponse>


}