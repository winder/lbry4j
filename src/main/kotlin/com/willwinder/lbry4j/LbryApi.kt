package com.willwinder.lbry4j

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


data class Command @JvmOverloads constructor(
    val method: String,
    val params: Any = listOf<Any>()
)

interface LbryApi {
  /**
   * @param command POJO which is serialized to JSON and sent to LBRY as the body.
   */
  @POST("/")
  fun call(@Body command: Command): Call<JsonElement>
}
