package com.abiyus.levelmoney.cc.txn;

import org.glassfish.jersey.client.ClientConfig;
import org.json.JSONObject;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;

/**
 * Created by afetene on 12/22/16.
 */
public class LoadAPIService {

  private static final String apiString = "{\"args\": {\"uid\": 1110590645, \"token\": " +
      "\"4D1A038FD99CBB230BC099247885B212\", \"api-token\": \"AppTokenForInterview\", " +
      "\"json-strict-mode\": false, \"json-verbose-response\": false}}";
  private ClientConfig clientConfig = null;
  private Client client = null;
  private String uri = "";

  public void setUri(String uri) {
    this.uri = uri;
  }

  public String getAllTransactions() throws IOException {

    clientConfig = new ClientConfig();
    client = ClientBuilder.newClient(clientConfig);
    String txnResponse = null;
    WebTarget webTarget = client.target(uri);
    Invocation.Builder request = webTarget.request(MediaType.APPLICATION_JSON_TYPE);
    Response response = request.post(Entity.json(apiString));
    System.out.println("Jersey Response Code : " + response.getStatus());
    if(response.getStatus() == 200) {
      BufferedReader rd = new BufferedReader(new InputStreamReader((InputStream) response.getEntity()));
      //BufferedReader rd = new BufferedReader(new FileReader("Transactions.txt"));

      StringBuffer txns = new StringBuffer();
      String line = "";
      while((line = rd.readLine()) != null) {
        txns.append(line);
      }
      txnResponse = txns.toString();
    }
    return txnResponse;
  }
}
