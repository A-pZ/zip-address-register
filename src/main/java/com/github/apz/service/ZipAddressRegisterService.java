/**
 *
 */
package com.github.apz.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.apz.model.Address;
import com.github.apz.repository.CSVReadRepository;
import com.github.apz.repository.ZipAddressRegisterRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * @author a-pz
 *
 */
@Service
@Log4j2
@RequiredArgsConstructor
public class ZipAddressRegisterService {
	private final CSVReadRepository csvReadRepository;
	private final ZipAddressRegisterRepository zipAddressRegisterRepository;

	/**
	 * ファイル名を指定したCSVのインポート。
	 * @param filename ファイル名（クラスパス内）
	 * @throws IOException
	 */
	public void register(String filename) throws IOException {
		log.info("CSV filename: {}", filename);
		List<Address> addressList = csvReadRepository.read(filename);

		log.info("register count: {}", addressList.size());
		zipAddressRegisterRepository.register(addressList);

		log.info("register success.");
	}

	public void register(InputStream is) throws IOException {
		log.info("CSV uploaded: {}", is.available());
		List<Address> addressList = csvReadRepository.read(is);

		log.info("register count: {}", addressList.size());
		zipAddressRegisterRepository.register(addressList);

		log.info("register success.");
	}

	public List<Address> upload(InputStream is) throws IOException {
		log.info("CSV uploaded: {}", is.available());
		List<Address> addressList = csvReadRepository.read(is);

		log.info("register count: {}", addressList.size());
		return addressList;
	}

	public void register(List<Address> addressList) {
		zipAddressRegisterRepository.deleteAll();

		zipAddressRegisterRepository.register(addressList);
		log.info("register success.");
	}
}
