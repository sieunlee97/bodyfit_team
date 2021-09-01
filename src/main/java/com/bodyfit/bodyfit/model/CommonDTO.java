package com.bodyfit.bodyfit.model;

import com.bodyfit.bodyfit.paging.Criteria;
import com.bodyfit.bodyfit.paging.PaginationInfo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonDTO extends Criteria {
	private PaginationInfo paginationInfo;
	
}
