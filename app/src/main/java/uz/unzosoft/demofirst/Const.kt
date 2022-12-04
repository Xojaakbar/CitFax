package uz.unzosoft.demofirst

import com.google.gson.annotations.SerializedName


/**
 * Created by Abdurashidov Shahzod on 28/11/22 19:20.
 * company QQBank
 * shahzod9933@gmail.com
 */
object Const {
    const val BASE_URL = "https://jsonplaceholder.typicode.com/"
}

//interface UserService {
//    @GET("photos")
//    suspend fun getPhotos(): Response<ResponseClass>
//
//
//}

// baseurl UserService -> BASE_URL


data class ResponseClass(

    @SerializedName("albumId") var albumId: Int? = null,
    @SerializedName("id") var id: Int? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("thumbnailUrl") var thumbnailUrl: String? = null

)


