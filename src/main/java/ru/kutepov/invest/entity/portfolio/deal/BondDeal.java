package ru.kutepov.invest.entity.portfolio.deal;

import ru.kutepov.invest.entity.instrument.Bond;
import ru.kutepov.invest.entity.portfolio.deal.type.BondDealType;

import javax.persistence.*;

/**
 * Сделка по облигации
 */
@Entity
public class BondDeal {

  @Id
  @Column(name="id")
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private long id;

  // облигация
  @OneToOne
  private Bond bond;

  // тип сделки
  @OneToOne
  private BondDealType dealType;

  // количество бумаг, учавствующих в сделке
  private int quantity;

  // цена сделки
  private double price;

  public BondDeal() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Bond getBond() {
    return bond;
  }

  public void setBond(Bond bond) {
    this.bond = bond;
  }

  public BondDealType getDealType() {
    return dealType;
  }

  public void setDealType(BondDealType dealType) {
    this.dealType = dealType;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
