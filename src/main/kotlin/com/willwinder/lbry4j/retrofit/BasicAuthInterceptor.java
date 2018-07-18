package com.willwinder.lbry4j.retrofit;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Inject basic authentication for lbrycrd calls.
 */
public class BasicAuthInterceptor implements Interceptor {
  private final String credentials;

  public BasicAuthInterceptor(String username, String password) {
    credentials = Credentials.basic(username, password);
  }

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request authenticatedRequest = chain.request().newBuilder()
        .header("Authorization", credentials).build();
    return chain.proceed(authenticatedRequest);
  }
}
