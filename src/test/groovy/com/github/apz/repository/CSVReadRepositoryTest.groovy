/**
 *
 */
package com.github.apz.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

import com.github.apz.model.Address

import spock.lang.Specification

/**
 * @author a-pz
 *
 */
@SpringBootTest
class CSVReadRepositoryTest extends Specification {
	@Autowired
	CSVReadRepository repo;

	def "読み込みテスト＆検証"() {
		when:
		List<Address> result = repo.read("KEN_TEST.CSV")

		then:
		noExceptionThrown()

		result
		result.size() == 2
	}

	def "全件読み込みテスト"() {
		when:
		List<Address> result = repo.read("KEN_ALL.CSV")

		then:
		noExceptionThrown()

		result
		result.size() == 124231
	}
}
