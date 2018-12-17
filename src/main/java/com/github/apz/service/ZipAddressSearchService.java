/**
 *
 */
package com.github.apz.service;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.github.apz.model.Address;
import com.github.apz.repository.ZipAddressSearchRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author a-pz
 *
 */
@Service
@RequiredArgsConstructor
public class ZipAddressSearchService {
	private final ZipAddressSearchRepository repository;

	public List<Address> search(String parameter) {
		if (StringUtils.isEmpty(parameter)) {
			return Collections.emptyList();
		}

		List<Address> addressList = (parameter.matches("[\\d]+")) ?
			repository.searchFromZipCode(parameter) :
				repository.searchFromWord(parameter);

		return addressList;
	}
}
