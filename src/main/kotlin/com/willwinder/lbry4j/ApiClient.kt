// Namespace hack for Java interop.
@file:JvmName("LBRY")
package com.willwinder.lbry4j

import com.willwinder.lbry4j.retrofit.BasicAuthInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val LBRYCRD_URL = "http://localhost:9245"
private const val DAEMON_URL = "http://localhost:5279"

/**
 * Daemon API, no credentials.
 */
fun getDaemonApi() = buildApi(DAEMON_URL, OkHttpClient.Builder().build())

/**
 * Lbrycrd API requires credentials. Details for setting this up can be found here:
 * https://lbry.io/faq/mining-credits
 *
 * @param username found in lbrycrd.conf
 * @param password found in lbrycrd.conf
 */
fun getLbrycrdApi(username: String, password: String): LbryApi {
  val lbrycrdClient = OkHttpClient.Builder()
      .addInterceptor(BasicAuthInterceptor(username, password))
      .build()

  return buildApi(LBRYCRD_URL, lbrycrdClient)
}

/**
 * Build the retrofit object with given base url and client.
 */
private fun buildApi(url: String, client: OkHttpClient) = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(url)
    .client(client)
    .build()
    .create(LbryApi::class.java) ?: throw IllegalArgumentException("Failed to initialize.")
