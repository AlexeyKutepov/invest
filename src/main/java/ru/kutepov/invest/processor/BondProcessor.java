package ru.kutepov.invest.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.kutepov.invest.entity.instrument.Bond;
import ru.kutepov.invest.repository.instrument.BondRepository;

import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Процессор формирующий актуальную информацию по облигациям
 */
@Component
public class BondProcessor {

  private static final Logger log = LoggerFactory.getLogger(BondProcessor.class);

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

            log.info("Обновление данных по облигации " + bondData.get(20) + ", ISIN = " + bondData.get(29));

            Bond bond = bondRepository.findBondByIsinCode(String.valueOf(bondData.get(29)));
            if (bond == null) {
              bond = new Bond();
            }
            if (bondData.get(20) != null) {
              bond.setName(String.valueOf(bondData.get(20)));
            }
            if (bondData.get(29) != null) {
              bond.setIsinCode(String.valueOf(bondData.get(29)));
            }
            if (bondData.get(32) != null) {
              bond.setCurrency(String.valueOf(bondData.get(32)));
            }
            if (bondData.get(10) != null) {
              bond.setNominalValue(Double.valueOf(String.valueOf(bondData.get(10))));
            }
            if (bondData.get(17) != null) {
              bond.setMarketValue(Double.valueOf(String.valueOf(bondData.get(17))));
            }
            if (bondData.get(5) != null) {
              bond.setCouponValue(Double.valueOf(String.valueOf(bondData.get(5))));
            }
            if (bondData.get(7) != null) {
              bond.setAccruedInterest(Double.valueOf(String.valueOf(bondData.get(7))));
            }
            if (bondData.get(6) != null && !"0000-00-00".equals(bondData.get(6))) {
              bond.setNextCouponDate(Date.valueOf(String.valueOf(bondData.get(6))));
            }
            if (bondData.get(13) != null && !"0000-00-00".equals(bondData.get(13))) {
              bond.setMaturityDate(Date.valueOf(String.valueOf(bondData.get(13))));
            }
            if (bondData.get(36) != null) {
              bond.setCouponPercent(Double.valueOf(String.valueOf(bondData.get(36))));
            }
            if (bondData.get(34) != null) {
              bond.setLevel(Integer.valueOf(String.valueOf(bondData.get(34))));
            }

            bondRepository.save(bond);
          }
        }
      }
    }
  }

}
