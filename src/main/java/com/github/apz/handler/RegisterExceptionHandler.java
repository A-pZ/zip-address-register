/**
 *
 */
package com.github.apz.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.apz.model.response.ModalMessage;

import lombok.extern.log4j.Log4j2;

/**
 * @author a-pz
 *
 */
@ControllerAdvice
@Log4j2
public class RegisterExceptionHandler {
	@ResponseBody
	@ExceptionHandler(Exception.class)
	public ModalMessage exceptionHandle(Exception exception) {
		log.warn("cause exception - {}" , exception);
		log.warn(exception);

		ModalMessage modalMessage = ModalMessage.builder()
				.title("エラーが発生しました")
				.status("500")
				.message("アプリケーション例外が発生しました。正しいCSVファイルをアップロードしてください")
				.build();

		return modalMessage;
	}
}
