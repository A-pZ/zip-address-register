package com.github.apz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 該当する(1)|該当しない(0)の列挙型。
 * @author a-pz
 *
 */
@AllArgsConstructor
@Getter
public enum CorrespondFlag {
	True(1), False(0);

	private int value;
}
