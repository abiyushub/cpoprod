package com.abiyus.levelmoney.cc.txn;

import java.math.BigDecimal;

/**
 * Created by afetene on 12/23/16.
 */
public class TransactionSummary {
  private BigDecimal spent;
  private BigDecimal income;
  private String transactionTitle;


  public void setTransactionTitle(String transactionTitle) {
    this.transactionTitle = transactionTitle;
  }

  public String getTransactionTitle() {
    return transactionTitle;
  }

  public BigDecimal getSpent() {
    return spent;
  }

  public void setSpent(BigDecimal spent) {
    this.spent = spent;
  }

  public BigDecimal getIncome() {
    return income;
  }

  public void setIncome(BigDecimal income) {
    this.income = income;
  }
}
