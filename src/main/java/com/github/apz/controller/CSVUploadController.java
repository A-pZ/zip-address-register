/**
 *
 */
package com.github.apz.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.apz.model.Address;
import com.github.apz.model.response.ModalMessage;
import com.github.apz.service.ZipAddressRegisterService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * @author a-pz
 *
 */
@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
@Log4j2
public class CSVUploadController {
	private final ZipAddressRegisterService service;
	private final HttpSession session;
	@PostMapping("upload")
	@ResponseBody
	public ModalMessage upload(MultipartFile uploadfile, ModelAndView mnv) throws IOException {

		InputStream is = uploadfile.getInputStream();
		List<Address> addressList = service.upload(is);

		session.setAttribute("addressList", addressList);

		ModalMessage modelMessage  = ModalMessage.builder()
				.title("アップロード成功")
				.status("200")
				.message("CSVファイルのアップロードが完了しました。件数：[" + addressList.size() + "]。続いてデータベースへの登録を行っていますのでしばらくお待ちください。完了するとこのダイアログが更新されます。")
				.build();

		return modelMessage;
	}

	@PostMapping("register")
	@ResponseBody
	public ModalMessage register() {

		@SuppressWarnings("unchecked")
		List<Address> addressList = (List<Address>)session.getAttribute("addressList");

		service.register(addressList);

		session.removeAttribute("addressList");

		ModalMessage modelMessage  = ModalMessage.builder()
				.title("データベース登録完了")
				.status("200")
				.message("データベースへの登録が完了しました")
				.build();

		return modelMessage;
	}
}
