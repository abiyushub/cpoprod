package com.abiyus.levelmoney.cc.txn;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    String txns = loadAPIService.getAllTransactions();

    ObjectMapper mapper = new ObjectMapper();
    TransactionHistory txnHistory = mapper.readValue(txns, TransactionHistory.class);

    System.out.println("Transactions size: " + txnHistory.getTransactions().size());
    return buildTranactionsSummary(txnHistory);
  }

  private JSONObject buildTranactionsSummary(TransactionHistory txnHistory){
    Map<String, TransactionSummary> txnSummaryMap = null;
    if(txnHistory != null) {
      txnSummaryMap = new HashMap<>();
      BigDecimal totalIncome = new BigDecimal(0);
      BigDecimal totalSpent = new BigDecimal(0);

      for(Transaction t : txnHistory.getTransactions()){
        TransactionSummary txnSummary = null;
        String txnTime = t.getTransactionTime().substring(0, 7);
        BigDecimal amount = t.getAmount();

        if(txnSummaryMap.containsKey(txnTime)){
          txnSummary = txnSummaryMap.get(txnTime);
          txnSummaryMap.remove(txnTime);

          if(amount.compareTo(BigDecimal.ZERO) > 0) {
            totalIncome = totalIncome.subtract(txnSummary.getIncome()==null ? BigDecimal.ZERO:txnSummary.getIncome());
            txnSummary.setIncome(amount.add(txnSummary.getIncome()==null ? BigDecimal.ZERO:txnSummary.getIncome()));
            totalIncome = totalIncome.add(txnSummary.getIncome());
          }else if(amount.compareTo(BigDecimal.ZERO) < 0){
            totalSpent = totalSpent.subtract(txnSummary.getSpent() == null ? BigDecimal.ZERO : txnSummary.getSpent());
            txnSummary.setSpent((txnSummary.getSpent() == null ? BigDecimal.ZERO : txnSummary.getSpent()).add(amount.abs()));
            totalSpent = totalSpent.add(txnSummary.getSpent());
          }

        }else{
          txnSummary = new TransactionSummary();
          if(amount.compareTo(BigDecimal.ZERO) > 0) {
            txnSummary.setIncome(amount);
            totalIncome = totalIncome.add(txnSummary.getIncome());
          }else if(amount.compareTo(BigDecimal.ZERO) < 0){
            txnSummary.setSpent(amount.abs());
            totalSpent = totalSpent.add(txnSummary.getSpent());
          }
        }

        txnSummary.setTransactionTitle(txnTime);
        txnSummaryMap.put(txnTime, txnSummary);
      }
      if(txnSummaryMap != null){
        TransactionSummary txnAvgSummary = new TransactionSummary();
        BigDecimal totalMonths = new BigDecimal(txnSummaryMap.size() - 1);
        System.out.println(totalMonths + " " + totalIncome +  " " + totalSpent);
        totalIncome = totalIncome.divide(totalMonths, 2, BigDecimal.ROUND_UP);
        totalSpent = totalSpent.divide(totalMonths, 2, BigDecimal.ROUND_UP);
        txnAvgSummary.setIncome(totalIncome);
        txnAvgSummary.setSpent(totalSpent);
        txnAvgSummary.setTransactionTitle("average");
        txnSummaryMap.put("average", txnAvgSummary);
      }
    }

    JSONObject jsonObj = new JSONObject(txnSummaryMap);

    return jsonObj;
  }

}
