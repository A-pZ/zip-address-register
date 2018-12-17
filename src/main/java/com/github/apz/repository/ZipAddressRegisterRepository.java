/**
 *
 */
package com.github.apz.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.github.apz.model.Address;

import lombok.RequiredArgsConstructor;

/**
 * @author a-pz
 *
 */
@Repository
@RequiredArgsConstructor
public class ZipAddressRegisterRepository {
	private final SqlSessionTemplate sqlSessionTemplate;

	public void register(List<Address> addressList) {
		addressList.stream()
			.forEach(address -> {
			sqlSessionTemplate.insert("address.register", address);
		});
	}

	public void deleteAll() {
		sqlSessionTemplate.delete("address.deleteAll");
	}
}
