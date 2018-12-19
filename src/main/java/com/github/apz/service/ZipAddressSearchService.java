/**
 *
 */
package com.github.apz.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

	/**
	 * 入力パラメータ（郵便番号または住所の一部）に合致する住所検索をする。もし空文字ないしは未指定であれば検索せず終了する。パラメータ値の半角スペースはトリムする。
	 * @param parameter 検索パラメータ値。
	 * @return 検索結果のList
	 */
	public List<Address> search(String parameter) {
		if (StringUtils.isEmpty(parameter)) {
			return Collections.emptyList();
		}

		parameter = parameter.trim();

		if (parameter.matches("[\\d]+")) {
			return repository.searchFromZipCode(parameter);
		} else if (parameter.matches("[\\d]{3}-[\\d]{0,4}")) {
			// ハイフン付きの場合、NNN-NNNN 形式になるので、ハイフンの位置は固定化される
			String zipCode = Arrays.stream(parameter.split("-")).collect(Collectors.joining());
			return repository.searchFromZipCode(zipCode);
		} else {
			return repository.searchFromWord(parameter);
		}
	}
}
