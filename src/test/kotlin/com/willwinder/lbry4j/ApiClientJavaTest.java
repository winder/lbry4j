package com.willwinder.lbry4j;

import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

/**
 * @author wwinder
 * Created on: 7/18/18
 */
public class ApiClientJavaTest {
  @Test
  public void testDaemon() throws IOException {
    LbryApi api = LBRY.getDaemonApi();
    Call call = api.call(new Command("resolve", ImmutableMap.of("uri", "what")));
    Response response = call.execute();
    System.out.println(response.body());
  }

  @Test
  public void testLbrycrd() throws IOException {
    LbryApi api = LBRY.getLbrycrdApi("username", "password");
    Call call = api.call(new Command("help"));
    Response response = call.execute();
    System.out.println(response.body());
  }
}
