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
class ZipAddressRegisterRepositoryTest extends Specification {
	@Autowired
	ZipAddressRegisterRepository sut

	def "登録テスト"() {
		when:
		Address address = new Address()
		address.allRegionPublicCompanyCode = '01101'
		address.oldZipCode = '060  '
		address.zipCode = '0600000'
		address.prefectureNameKana = 'ﾎｯｶｲﾄﾞｳ'
		address.municipalityNameKana = 'ｻｯﾎﾟﾛｼﾁｭｳｵｳｸ'
		address.townNameKana = 'ｲｶﾆｹｲｻｲｶﾞﾅｲﾊﾞｱｲ'
		address.prefectureName = '北海道'
		address.municipalityName = '札幌市中央区'
		address.townName = '以下に掲載がない場合'

		sut.register([address])

		then:
		noExceptionThrown()
	}
}
