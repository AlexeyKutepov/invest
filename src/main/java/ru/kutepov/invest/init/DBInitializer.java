package ru.kutepov.invest.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kutepov.invest.entity.portfolio.deal.type.BondDealType;
import ru.kutepov.invest.repository.portfolio.deal.type.BondDealTypeRepository;

import java.util.List;

/**
 * Заполнение классификаторов базы данных
 */
@Component
public class DBInitializer {

  private BondDealTypeRepository bondDealTypeRepository;

  @Autowired
  public DBInitializer(BondDealTypeRepository bondDealTypeRepository) {
    this.bondDealTypeRepository = bondDealTypeRepository;
    init();
  }

  private void init() {
    List<BondDealType> bondDealTypeList = bondDealTypeRepository.findAll();
    if (bondDealTypeList.isEmpty()) {
      bondDealTypeRepository.save(new BondDealType(1,"Покупка облигации"));
      bondDealTypeRepository.save(new BondDealType(2,"Продажа облигации"));
      bondDealTypeRepository.save(new BondDealType(3,"Погашение облигации"));
      bondDealTypeRepository.save(new BondDealType(4,"Погашение купона"));
    }
  }
}
