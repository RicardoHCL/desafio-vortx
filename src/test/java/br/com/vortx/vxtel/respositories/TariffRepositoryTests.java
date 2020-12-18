package br.com.vortx.vxtel.respositories;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.vortx.vxtel.models.Tariff;
import br.com.vortx.vxtel.repositories.TariffRepository;

@SpringBootTest
@DataJpaTest
public class TariffRepositoryTests {

	@Autowired
	private TariffRepository repository;
	

	@Test
	public void save() {
		Tariff t = new Tariff();
		t.setOrigin(10);
		t.setDestiny(9);
		t.setValue(BigDecimal.valueOf(1.30));
		
		repository.save(t);
		Assertions.assertThat(t.getId()).isNotNull();
		Assertions.assertThat(t.getOrigin()).isEqualTo(10);
		Assertions.assertThat(t.getDestiny()).isEqualTo(9);
		Assertions.assertThat(t.getValue()).isEqualTo(BigDecimal.valueOf(1.30));
	}

}