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
public class ZipAddressSearchRepository {
	private final SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 郵便番号で検索する。
	 * @param zipCode 郵便番号
	 * @return 検索結果
	 */
	public List<Address> searchFromZipCode(String zipCode) {
		return sqlSessionTemplate.selectList("address.searchFromZipCode", zipCode);
	}

	/**
	 * 入力した単語を含んだ住所を検索する。
	 * @param word 入力単語
	 * @return 検索結果
	 */
	public List<Address> searchFromWord(String word) {
		return sqlSessionTemplate.selectList("address.searchFromWord", word);
	}
}
