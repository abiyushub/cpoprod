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
public class TransactionManager {

  private static TransactionManager transactionManager = new TransactionManager();

  protected TransactionManager(){}

  public static TransactionManager getInstance(){
    return transactionManager;
  }

  private LoadAPIService loadAPIService = new LoadAPIService();

  public JSONObject getAllTransactions() throws IOException {
    loadAPIService.setUri("https://2016.api.levelmoney.com/api/v2/core/get-all-transactions");
    JSONObject jsonObject = loadAPIService.getAllTransactions();
    return jsonObject;
  }

}
