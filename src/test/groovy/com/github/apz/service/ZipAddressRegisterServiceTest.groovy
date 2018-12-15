/**
 *
 */
package com.github.apz.service

import com.github.apz.model.Address
import com.github.apz.repository.CSVReadRepository
import com.github.apz.repository.ZipAddressRegisterRepository

import spock.lang.Specification

/**
 * @author a-pz
 *
 */
class ZipAddressRegisterServiceTest extends Specification {

	CSVReadRepository csvReadRepository = Mock()
	ZipAddressRegisterRepository zipAddressRegisterRepository = Mock()

	ZipAddressRegisterService sut = new ZipAddressRegisterService(csvReadRepository, zipAddressRegisterRepository)

	def "ZipAddress登録"() {
		when:
		Address address = new Address()
		1 * csvReadRepository.read(_) >> [address]
		1 * zipAddressRegisterRepository.register([address])

		sut.register("TEST.CSV")

		then:
		noExceptionThrown()

	}
}
