package com.willwinder.lbry4j

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

@Disabled
class ApiClientKtTest {
  @Test
  fun testDaemon() {
    val call = getDaemonApi().call(Command("resolve", mapOf("uri" to "what")))
    val response = call.execute()
    val data = response.body()
    println(data)
  }

  @Test
  fun testCrd() {
    val call = getLbrycrdApi("username", "password")
        .call(Command("help"))
    val response = call.execute()
    val data = response.body()
    println(data)
  }
}
