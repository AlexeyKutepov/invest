package ru.kutepov.invest.entity.instrument;

import javax.persistence.*;
import java.util.Date;

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
  private Double nominalValue;

  // Рыночная стоимость
  private Double marketValue;

  // НКД
  private Double accruedInterest;

  // Текущий купон
  private Double couponValue;

  private Double couponPercent;

  // Валюта
  private String currency;

  // Дата выплаты купона
  @Temporal(TemporalType.DATE)
  private Date nextCouponDate;

  // Дата погашения
  @Temporal(TemporalType.DATE)
  private Date maturityDate;

  // Уровень облигации
  private Integer level;

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

  public Double getNominalValue() {
    return nominalValue;
  }

  public void setNominalValue(Double nominalValue) {
    this.nominalValue = nominalValue;
  }

  public Double getMarketValue() {
    return marketValue;
  }

  public void setMarketValue(Double marketValue) {
    this.marketValue = marketValue;
  }

  public Double getAccruedInterest() {
    return accruedInterest;
  }

  public void setAccruedInterest(Double accruedInterest) {
    this.accruedInterest = accruedInterest;
  }

  public Double getCouponValue() {
    return couponValue;
  }

  public void setCouponValue(Double couponValue) {
    this.couponValue = couponValue;
  }

  public Double getCouponPercent() {
    return couponPercent;
  }

  public void setCouponPercent(Double couponPercent) {
    this.couponPercent = couponPercent;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Date getNextCouponDate() {
    return nextCouponDate;
  }

  public void setNextCouponDate(Date nextCouponDate) {
    this.nextCouponDate = nextCouponDate;
  }

  public Date getMaturityDate() {
    return maturityDate;
  }

  public void setMaturityDate(Date maturityDate) {
    this.maturityDate = maturityDate;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }
}
