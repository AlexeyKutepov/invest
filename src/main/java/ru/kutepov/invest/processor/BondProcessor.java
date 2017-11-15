package ru.kutepov.invest.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.kutepov.invest.entity.instrument.Bond;
import ru.kutepov.invest.repository.instrument.BondRepository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Процессор формирующий актуальную информацию по облигациям
 */
@Component
public class BondProcessor {

  private final String GET_BONDS_URL = "http://moex.com/iss/engines/stock/markets/bonds/securities.json";
  private final String SECURITIES = "securities";
  private final String DATA = "data";

  private BondRepository bondRepository;

  @Autowired
  public void setBondRepository(BondRepository bondRepository) {
    this.bondRepository = bondRepository;
  }

  public void process() {
    Map bondsMap = new RestTemplate().getForObject(GET_BONDS_URL, LinkedHashMap.class);
    if (bondsMap.containsKey(SECURITIES) && bondsMap.get(SECURITIES) instanceof Map) {
      Map securitiesMap = (Map) bondsMap.get(SECURITIES);
      if (securitiesMap.containsKey(DATA) && securitiesMap.get(DATA) instanceof List) {
        List bondList = (List) securitiesMap.get(DATA);
        for (Object item : bondList) {
          if (item != null && item instanceof List) {
            List bondData = ((List) item);
            Bond bond = new Bond();
            bond.setName(String.valueOf(bondData.get(20)));
            bond.setIsinCode(String.valueOf(bondData.get(29)));
            bond.setCurrency("RUB");
            bond.setNominalValue(bondData.get(10)!=null?Double.valueOf(String.valueOf(bondData.get(10))):null);
            bond.setMarketValue(bondData.get(17)!=null?Double.valueOf(String.valueOf(bondData.get(17))):null);
            bond.setAccruedInterest(bondData.get(7)!=null?Double.valueOf(String.valueOf(bondData.get(7))):null);
            bondRepository.save(bond);
          }
        }
      }
    }
  }

}
