package com.abiyus.levelmoney.cc.txn;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by afetene on 12/22/16.
 */
public class Transaction {

  @JsonProperty("transaction-id")
  private String transactionId;
  @JsonProperty("amount")
  private double amount;
  @JsonProperty("clear-date")
  private long clearDate;
  @JsonProperty("categorization")
  private String categorization;
  @JsonProperty("is-pending")
  private boolean isPending;
  @JsonProperty("account-id")
  private String accountId;
  @JsonProperty("merchant")
  private String merchant;
  @JsonProperty("transaction-time")
  private String transactionTime;
  @JsonProperty("raw-merchant")
  private String rawMerchant;
  @JsonProperty("aggregation-time")
  private long aggregationTime;

  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public long getClearDate() {
    return clearDate;
  }

  public void setClearDate(long clearDate) {
    this.clearDate = clearDate;
  }

  public String getCategorization() {
    return categorization;
  }

  public void setCategorization(String categorization) {
    this.categorization = categorization;
  }

  public boolean isPending() {
    return isPending;
  }

  public void setPending(boolean pending) {
    isPending = pending;
  }

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public String getMerchant() {
    return merchant;
  }

  public void setMerchant(String merchant) {
    this.merchant = merchant;
  }

  public String getTransactionTime() {
    return transactionTime;
  }

  public void setTransactionTime(String transactionTime) {
    this.transactionTime = transactionTime;
  }

  public String getRawMerchant() {
    return rawMerchant;
  }

  public void setRawMerchant(String rawMerchant) {
    this.rawMerchant = rawMerchant;
  }

  public long getAggregationTime() {
    return aggregationTime;
  }

  public void setAggregationTime(long aggregationTime) {
    this.aggregationTime = aggregationTime;
  }
}
