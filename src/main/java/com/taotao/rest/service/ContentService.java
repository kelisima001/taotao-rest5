package com.taotao.rest.service;

import java.util.List;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

public interface ContentService {

	TaotaoResult insertContent(TbContent content);
	List<TbContent> getContntList(Long cid);
	TaotaoResult deleteContent(Long id);
	TaotaoResult updateContent(TbContent tbContent);
}
