package com.bitcamp.orl.crew.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchType {

	private String searchType;
	private String keyword;
	private int pageStart;
	private int perPageNum;

	public SearchType(String searchType, String keyword, int pageStart, int perPageNum) {
		this.searchType = searchType;
		this.keyword = keyword;
		this.pageStart = pageStart;
		this.perPageNum = perPageNum;
	}

	public SearchType() {
	}


	@Override
	public String toString() {
		return "SearchType [searchType=" + searchType + ", keyword=" + keyword + "]";
	}

}