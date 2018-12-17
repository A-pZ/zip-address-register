/**
 *
 */
package com.github.apz.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.apz.model.Address;
import com.github.apz.service.ZipAddressSearchService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * @author a-pz
 *
 */
@Controller
@RequestMapping("/")
@Log4j2
@RequiredArgsConstructor
public class ZipSearchController {

	private final ZipAddressSearchService service;

	@GetMapping("")
	public ModelAndView display(ModelAndView mnv) {

		mnv.setViewName("search");
		mnv.addObject("message", "郵便番号を数値、または 住所の一部を入力してください。");
		return mnv;
	}

	@GetMapping("search")
	public ModelAndView search(ModelAndView mnv, @RequestParam String parameter) {
		List<Address> addressList = service.search(parameter);

		log.info("addressList: count:{}", addressList.size());
		mnv.addObject("addressList", addressList);
		String message = null;
		if (addressList.isEmpty()) {
			message = "検索結果はありませんでした。";
		} else {
			message = "検索結果は " + addressList.size() + " 件です";
		}
		mnv.addObject("message", message);
		mnv.setViewName("search");
		return mnv;
	}
}
