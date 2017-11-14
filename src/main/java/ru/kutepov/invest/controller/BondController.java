package ru.kutepov.invest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.kutepov.invest.entity.instrument.Bond;
import ru.kutepov.invest.repository.instrument.BondRepository;

import java.util.List;

/**
 * API для работы с облигациями
 */
@RestController
@RequestMapping(value = "/bond")
public class BondController {

  private BondRepository bondRepository;

  @Autowired
  public BondController(BondRepository bondRepository) {
    this.bondRepository = bondRepository;
  }

  /**
   * Получить список облигаций
   * @return {@link List<Bond>}
   */
  @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
  public List<Bond> getBonds() {
    return bondRepository.findAll();
  }

  /**
   * Получить облигацию по id
   * @param id идентификатор
   * @return {@link Bond}
   */
  @RequestMapping(value = "/{id}/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
  public Bond getBondById(@PathVariable long id) {
    return bondRepository.findOne(id);
  }


}
