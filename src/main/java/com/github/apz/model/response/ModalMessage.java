package com.github.apz.model.response;

import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class ModalMessage {
	private String title;
	private String status;
	private String message;
}
