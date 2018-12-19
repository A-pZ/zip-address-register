/**
 *
 */
package com.github.apz.service

import com.github.apz.repository.ZipAddressSearchRepository

import spock.lang.Specification

/**
 * @author a-pz
 *
 */
class ZipAddressSearchServiceTest extends Specification {
	ZipAddressSearchService sut

	ZipAddressSearchRepository repository = Mock()

	def setup() {
		sut = new ZipAddressSearchService(repository)
	}

	def "ハイフンなし郵便番号"() {
		when:
		1 * repository.searchFromZipCode(parameter)
		0 * repository.searchFromWord(_)

		def resultList = sut.search(parameter)

		then:
		noExceptionThrown()

		where:
		parameter || _
		'1234567' || _
		'1'       || _
		'12345678'|| _
	}

	def "ハイフンあり郵便番号"() {
		when:
		1 * repository.searchFromZipCode(zipcode)
		0 * repository.searchFromWord(_)

		def resultList = sut.search(parameter)

		then:
		noExceptionThrown()

		where:
		parameter  | zipcode   || _
		'123-4567' | '1234567' || _
		'123-'     | '123'     || _
		'123-4'    | '1234'    || _
	}
}
