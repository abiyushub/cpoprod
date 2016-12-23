package com.abiyus.levelmoney.cc.txn;

import org.glassfish.jersey.client.ClientConfig;
import org.json.JSONObject;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by afetene on 12/22/16.
 */
public class LoadAPIService {

  private static final String apiString = "{\"args\": {\"uid\": 1110590645, \"token\": " +
      "\"4D1A038FD99CBB230BC099247885B212\", \"api-token\": \"AppTokenForInterview\", " +
      "\"json-strict-mode\": false, \"json-verbose-response\": false}}";
  private ClientConfig clientConfig;
  private Client client;
  private String uri;

  public void setUri(String uri) {
    this.uri = uri;
  }

  public JSONObject getAllTransactions() throws IOException {

   clientConfig = new ClientConfig();
   client = ClientBuilder.newClient(clientConfig);

    WebTarget webTarget = client.target(uri);
    Invocation.Builder request = webTarget.request(MediaType.APPLICATION_JSON_TYPE);
    Response response = request.post(Entity.json(apiString));
    System.out.print("Jersey Response Code : " + response.getStatus());

    BufferedReader rd = new BufferedReader(new InputStreamReader((InputStream) response.getEntity()));

    StringBuffer txns = new StringBuffer();
    String line = "";
    while ((line = rd.readLine()) != null) {
      txns.append(line);
    }
    JSONObject jsonObject = new JSONObject(txns.toString());

    return jsonObject;
  }
}
