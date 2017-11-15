package ru.kutepov.invest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.kutepov.invest.entity.instrument.Bond;
import ru.kutepov.invest.processor.BondProcessor;
import ru.kutepov.invest.repository.instrument.BondRepository;

import java.util.List;

/**
 * API для работы с облигациями
 */
@RestController
@RequestMapping(value = "/bond")
public class BondController {

  private BondRepository bondRepository;
  private BondProcessor bondProcessor;

  @Autowired
  public void setBondRepository(BondRepository bondRepository) {
    this.bondRepository = bondRepository;
  }

  @Autowired
  public void setBondProcessor(BondProcessor bondProcessor) {
    this.bondProcessor = bondProcessor;
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

  /**
   * Обновление списка облигаций
   */
  @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  @ResponseStatus(value = HttpStatus.OK)
  public void updateBonds() {
    bondProcessor.process();
  }

}
