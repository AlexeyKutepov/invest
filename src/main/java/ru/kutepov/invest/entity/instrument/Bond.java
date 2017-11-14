package ru.kutepov.invest.entity.instrument;

import javax.persistence.*;

/**
 * Облигация
 */
@Entity
public class Bond {

  @Id
  @Column(name="id")
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private long id;

  // Название
  private String name;

  // ISIN код
  @Column(unique = true)
  private String isinCode;

  // Номинальная стоимость
  private double nominalValue;

  // Рыночная стоимость
  private double marketValue;

  // НКД
  private double accruedInterest;

  // Валюта
  private String currency;

  public Bond() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIsinCode() {
    return isinCode;
  }

  public void setIsinCode(String isinCode) {
    this.isinCode = isinCode;
  }

  public double getNominalValue() {
    return nominalValue;
  }

  public void setNominalValue(double nominalValue) {
    this.nominalValue = nominalValue;
  }

  public double getMarketValue() {
    return marketValue;
  }

  public void setMarketValue(double marketValue) {
    this.marketValue = marketValue;
  }

  public double getAccruedInterest() {
    return accruedInterest;
  }

  public void setAccruedInterest(double accruedInterest) {
    this.accruedInterest = accruedInterest;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }
}
