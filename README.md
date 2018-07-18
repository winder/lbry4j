LBRY JSON-RPC bindings for Kotlin/Java.

# Prerequisits

Artifacts are published on maven:
```xml
    <dependency>
      <groupId>com.willwinder.lbry4j</groupId>
      <artifactId>lbry4j</artifactId>
      <version>1.0</version>
    </dependency>
```

# Usage

The LbryApi object should be initialized once and cached by the client application. The Command object should be provided an Array or HashMap depending on the RPC method being invoked.

A [**Call**](https://square.github.io/retrofit/2.x/retrofit/retrofit2/Call.html) may be executed synchronously with execute(), or asynchronously with enqueue(retrofit2.Callback<T>). In either case the call can be canceled at any time with cancel(). A call that is busy writing its request or reading its response may receive a IOException.

A [**Response**](https://square.github.io/retrofit/2.x/retrofit/retrofit2/Response.html) wraps the HTTP response, including the response code, body, and headers. Various convenience methods such as **isSuccessful()** exist.

Java API objects are accessed via the `LBRY` namespace:
```java
    // Daemon API
    LbryApi api = LBRY.getDaemonApi();
    Call call = api.call(new Command("resolve", ImmutableMap.of("uri", "what")));
    Response response = call.execute();
    System.out.println(response.body());
 
    // lbrycrd server API
    LbryApi api = LBRY.getLbrycrdApi("<username>", "<password>");
    Call call = api.call(new Command("help"));
    Response response = call.execute();
    System.out.println(response.body());
```

Kotlin accesses api objects via top level methods.
```kotlin
    // Daemon API
    val api = getDaemonApi()
    val call = api.call(Command("resolve", mapOf("uri" to "what")))
    val response = call.execute()
    val data = response.body()
    println(data)

    // lbrycrd server API
    val api = getLbrycrdApi("<username>", "<password>")
    val call = api.call(Command("help"))
    val response = call.execute()
    val data = response.body()
    println(data)
 ```

# Development

Leverages [Retrofit2](http://square.github.io/retrofit/), [Gson](https://github.com/google/gson), [Kotlin](https://kotlinlang.org/), and [Maven](https://maven.apache.org/).

# Unit Tests

There are some unit tests, but they were mainly used to manually verify that the retrofit configuration wasn't completely broken.

# Building

This project uses a standard Maven build process to package a jar library. Run **mvn package** to create the jar.

