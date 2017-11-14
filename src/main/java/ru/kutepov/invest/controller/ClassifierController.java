package ru.kutepov.invest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.kutepov.invest.entity.portfolio.deal.type.BondDealType;
import ru.kutepov.invest.repository.portfolio.deal.type.BondDealTypeRepository;

import java.util.List;

/**
 * Классификаторы
 */
@RestController
@RequestMapping(value = "/classifier")
public class ClassifierController {

  private BondDealTypeRepository bondDealTypeRepository;

  @Autowired
  public void setBondDealTypeRepository(BondDealTypeRepository bondDealTypeRepository) {
    this.bondDealTypeRepository = bondDealTypeRepository;
  }

  /**
   * Получить типы сделок по облигациям
   * @return {@link List<BondDealType>}
   */
  @RequestMapping(value = "/bond/deal/type", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
  public List<BondDealType> getCountryClassifier() {
    return bondDealTypeRepository.findAll();
  }
}
