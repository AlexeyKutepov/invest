package ru.kutepov.invest.entity.portfolio;

import ru.kutepov.invest.entity.portfolio.deal.BondDeal;

import javax.persistence.*;
import java.util.List;

/**
 * Инвестиционный портфель
 */
@Entity
public class Portfolio {

  @Id
  @Column(name="id")
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private long id;

  // Денежные средства
  private double cash;

  // Список сделок по облигациям
  @OneToMany(targetEntity = BondDeal.class, fetch = FetchType.LAZY)
  @OrderBy("id")
  private List<BondDeal> bondDealList;

  public Portfolio() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public double getCash() {
    return cash;
  }

  public void setCash(double cash) {
    this.cash = cash;
  }

  public List<BondDeal> getBondDealList() {
    return bondDealList;
  }

  public void setBondDealList(List<BondDeal> bondDealList) {
    this.bondDealList = bondDealList;
  }
}
