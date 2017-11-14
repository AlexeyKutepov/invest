package ru.kutepov.invest.entity.portfolio.deal.type;

import javax.persistence.*;

/**
 * Тип сделки по облигации
 */
@Entity
@Cacheable
public class BondDealType {

  @Id
  @Column(updatable = false)
  private Integer id;

  private String name;

  public BondDealType() {
  }

  public BondDealType(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
