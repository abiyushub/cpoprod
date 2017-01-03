package com.abiyus.levelmoney.cc.txn;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by afetene on 12/23/16.
 */
public class TransactionSummary {
  private BigDecimal spent;
  private BigDecimal income;
  private String transactionTitle;

  public TransactionSummary() {
    this.spent = new BigDecimal(0.0);
    this.income = new BigDecimal(0.0);
  }

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

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    DecimalFormat f = new DecimalFormat("#,###.00");
    spent = spent.setScale(2, BigDecimal.ROUND_DOWN);
    income = income.setScale(2, BigDecimal.ROUND_DOWN);
    sb = sb.append( " {" +
        "\"spent\": " + "\"$" + f.format(spent) +
        "\", \"income\": " + "\"$"+ f.format(income) +
        "\" }");
    return sb.toString();
  }
}
