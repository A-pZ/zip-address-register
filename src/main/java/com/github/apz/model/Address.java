/**
 *
 */
package com.github.apz.model;

import com.github.mygreen.supercsv.annotation.CsvBean;
import com.github.mygreen.supercsv.annotation.CsvColumn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 日本郵便が提供する郵便番号データのエンティティ。
 *
 * @author a-pz
 *
 */
@Getter @Setter @NoArgsConstructor
@ToString
@CsvBean(header=false)
public class Address {
	/** 1. 全国地方公共団体コード */
	@CsvColumn(number=1, label="全国地方公共団体コード")
	private String allRegionPublicCompanyCode;

	/** 2. （旧）郵便番号（5桁） */
	@CsvColumn(number=2, label="（旧）郵便番号（5桁）")
	private String oldZipCode;

	/** 3. 郵便番号（7桁） */
	@CsvColumn(number=3, label="郵便番号（7桁）")
	private String zipCode;

	/** 4. 都道府県名（半角カナ） */
	@CsvColumn(number=4, label="都道府県名（半角カナ）")
	private String prefectureNameKana;

	/** 5. 市区町村名（半角カナ） */
	@CsvColumn(number=5, label="市区町村名（半角カナ）")
	private String municipalityNameKana;

	/** 6. 町域名（半角カナ） */
	@CsvColumn(number=6, label="町域名（半角カナ）")
	private String townNameKana;

	/** 7. 都道府県名 */
	@CsvColumn(number=7, label="都道府県名")
	private String prefectureName;

	/** 8. 市区町村名 */
	@CsvColumn(number=8, label="市区町村名")
	private String municipalityName;

	/** 9. 町域名 */
	@CsvColumn(number=9, label="町域名")
	private String townName;

	/** 10. 一町域が二以上の郵便番号で表される場合の表示 */
	@CsvColumn(number=10)
	private int singleTownHasMultipleZipCode;

	/** 11. 小字毎に番地が起番されている町域の表示 */
	@CsvColumn(number=11)
	private int eachVillageProvideZipCode;

	/** 12. 丁目を有する町域の場合の表示 */
	@CsvColumn(number=12)
	private int townHasStreetNumber;

	/** 13. 一つの郵便番号で二以上の町域を表す場合の表示 */
	@CsvColumn(number=13)
	private int singleZipCodeHasMultipleTown;

	/** 14. 更新の表示 */
	@CsvColumn(number=14)
	private int updateDivision;

	/** 15. 変更理由 */
	@CsvColumn(number=15)
	private int updateReasonDivision;
}
