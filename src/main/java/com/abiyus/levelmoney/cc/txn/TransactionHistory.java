package com.abiyus.levelmoney.cc.txn;

import java.util.List;

/**
 * Created by afetene on 12/22/16.
 */
public class TransactionHistory {

  private String error;
  private List<Transaction> transactions;

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public List<Transaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<Transaction> transactions) {
    this.transactions = transactions;
  }

}
